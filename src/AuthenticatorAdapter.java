import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenticatorAdapter implements IModernAuthenticator {

    private final LegacyAuthService legacyAuthService;

    public AuthenticatorAdapter(LegacyAuthService legacyAuthService) {
        this.legacyAuthService = legacyAuthService;
    }

    @Override
    public boolean login(String username, String plainTextPassword) {
        String hexHash = hashToMd5Hex(plainTextPassword);
        return legacyAuthService.authenticateUserHex(username, hexHash);
    }

    private String hashToMd5Hex(String plainTextPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = messageDigest.digest(plainTextPassword.getBytes());
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            // MD5 всегда доступен в стандартной JVM, поэтому это исключение
            // практически недостижимо — оборачиваем в unchecked, чтобы не
            // загрязнять сигнатуру метода login() из интерфейса
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            hexStringBuilder.append(String.format("%02x", b));
        }
        return hexStringBuilder.toString();
    }
}