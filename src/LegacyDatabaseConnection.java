public class LegacyDatabaseConnection {
    // Returns 0 on success, -1 if record not found, -2 if locked
    public int executeFetch(int recordId, String[] outBuffer) {
        if (recordId == 404) return -1;
        if (recordId == 500) return -2;
        outBuffer[0] = "RECORD_DATA";
        return 0;
    }
}