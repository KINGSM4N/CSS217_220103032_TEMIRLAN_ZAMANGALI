public class EnterpriseTelemetryLogger {
    // Level 1 = INFO, Level 2 = WARN, Level 3 = ERROR
    public void writeLog(int level, String appName, String message) {
        System.out.println("[" + appName + "][Level " + level + "] " + message);
    }
}