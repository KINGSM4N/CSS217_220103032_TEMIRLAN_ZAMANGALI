public class CsvUserAdapter implements IUserSource {

    private final LegacyCsvUserStore legacyCsvUserStore;

    public CsvUserAdapter(LegacyCsvUserStore legacyCsvUserStore) {
        this.legacyCsvUserStore = legacyCsvUserStore;
    }

    @Override
    public UserProfile getNextUser() {
        String rawLine = legacyCsvUserStore.fetchNextRow();

        if (rawLine == null) {
            throw new IllegalStateException("Legacy store returned null line");
        }

        String[] tokens = rawLine.split(",");

        if (tokens.length != 3) {
            throw new IllegalStateException("Invalid CSV line: " + rawLine);
        }

        String idToken = tokens[0].trim();
        String nameToken = tokens[1].trim();
        String roleToken = tokens[2].trim();

        int id;
        try {
            id = Integer.parseInt(idToken);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid id in CSV line: " + rawLine, e);
        }

        return new UserProfile(id, nameToken, roleToken);
    }
}