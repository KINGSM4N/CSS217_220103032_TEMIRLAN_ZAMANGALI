import java.util.Map;

public class FlattenedConfigAdapter implements IConfiguration {

    private final NestedConfigStore nestedConfigStore;

    public FlattenedConfigAdapter(NestedConfigStore nestedConfigStore) {
        this.nestedConfigStore = nestedConfigStore;
    }

    @Override
    public String getString(String dottedKey) {
        String[] segments = dottedKey.split("\\.");

        Object current = nestedConfigStore.getRawConfig();

        for (String segment : segments) {
            if (!(current instanceof Map)) {
                return null;
            }

            Map<?, ?> currentMap = (Map<?, ?>) current;

            if (!currentMap.containsKey(segment)) {
                return null;
            }

            current = currentMap.get(segment);
        }

        return String.valueOf(current);
    }
}