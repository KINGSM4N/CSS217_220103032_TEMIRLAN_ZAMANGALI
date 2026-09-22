public class BulbAdapter implements SmartDevice {

    private final LegacyBulb bulb;
    private static final int K = 2; // Student-ID calibration seed

    public BulbAdapter(LegacyBulb bulb) {
        if (bulb == null) {
            throw new IllegalArgumentException("bulb cannot be null");
        }
        this.bulb = bulb;
    }

    @Override
    public void turnOn() {
        bulb.setBrightness(255);
    }

    @Override
    public void turnOff() {
        bulb.setBrightness(0);
    }

    @Override
    public boolean isOn() {
        if (!bulb.hasPower()) {
            return false;
        }
        return bulb.readBrightness() > 0;
    }

    @Override
    public int getPowerPercent() {
        if (!bulb.hasPower()) {
            return 0;
        }

        int raw = bulb.readBrightness();
        if (raw == 0) {
            return 0;
        }

        int basePercent = (raw * 100) / 255;
        int calibratedPercent = basePercent + K;

        if (calibratedPercent > 100) {
            calibratedPercent = 100;
        }
        return calibratedPercent;
    }
}