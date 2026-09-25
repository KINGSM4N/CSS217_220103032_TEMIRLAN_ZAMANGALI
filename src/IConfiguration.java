public interface IConfiguration {
    String getString(String dottedKey); // e.g. "database.host" -> "127.0.0.1"
}