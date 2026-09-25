public class TelemetryLoggerAdapter implements ISimpleLogger {

    private static final int LEVEL_INFO = 1;
    private static final int LEVEL_WARN = 2;
    private static final int LEVEL_ERROR = 3;

    private final EnterpriseTelemetryLogger enterpriseTelemetryLogger;
    private final String appName;

    public TelemetryLoggerAdapter(EnterpriseTelemetryLogger enterpriseTelemetryLogger, String appName) {
        this.enterpriseTelemetryLogger = enterpriseTelemetryLogger;
        this.appName = appName;
    }

    @Override
    public void info(String message) {
        enterpriseTelemetryLogger.writeLog(LEVEL_INFO, appName, message);
    }

    @Override
    public void warn(String message) {
        enterpriseTelemetryLogger.writeLog(LEVEL_WARN, appName, message);
    }

    @Override
    public void error(String message) {
        enterpriseTelemetryLogger.writeLog(LEVEL_ERROR, appName, message);
    }
}