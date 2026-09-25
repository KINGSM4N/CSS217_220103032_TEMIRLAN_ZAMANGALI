public interface IModernAuthenticator {
    boolean login(String username, String plainTextPassword);
}