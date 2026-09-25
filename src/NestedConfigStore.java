import java.util.Map;

public class NestedConfigStore {
    // Returns nested map: Map.of("db", Map.of("host", "localhost"))
    public Map<String, Object> getRawConfig() {
        return Map.of(
                "database", Map.of("host", "127.0.0.1", "port", 5432),
                "server", Map.of("name", "SDU-Gateway")
        );
    }
}