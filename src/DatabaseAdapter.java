public class DatabaseAdapter implements IRepository {

    private final LegacyDatabaseConnection legacyDatabaseConnection;

    public DatabaseAdapter(LegacyDatabaseConnection legacyDatabaseConnection) {
        this.legacyDatabaseConnection = legacyDatabaseConnection;
    }

    @Override
    public String findById(int id) throws RecordNotFoundException, DatabaseLockedException {
        String[] outBuffer = new String[1];
        int resultCode = legacyDatabaseConnection.executeFetch(id, outBuffer);

        switch (resultCode) {
            case 0:
                return outBuffer[0];
            case -1:
                throw new RecordNotFoundException("Record not found for id: " + id);
            case -2:
                throw new DatabaseLockedException("Database is locked for id: " + id);
            default:
                throw new IllegalStateException("Unknown result code: " + resultCode);
        }
    }
}