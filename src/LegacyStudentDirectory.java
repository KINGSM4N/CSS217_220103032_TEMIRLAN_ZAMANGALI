public class LegacyStudentDirectory {
    private final String[] students = {"Alice", "Bob", "Charlie", "David"};

    public int totalEntries() {
        return students.length;
    }

    public String getStudentAt(int oneBasedIndex) {
        if (oneBasedIndex < 1 || oneBasedIndex > students.length) {
            throw new IndexOutOfBoundsException("Legacy index out of bounds: " + oneBasedIndex);
        }
        return students[oneBasedIndex - 1];
    }
}