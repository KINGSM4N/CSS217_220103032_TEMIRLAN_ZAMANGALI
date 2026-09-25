public class TwoWaySpeedAdapter implements ISpeedInMph, ISpeedInKmh {

    private static final double MPH_TO_KMH = 1.60934;
    private static final double KMH_TO_MPH = 0.621371;

    // Единая каноничная единица хранения — км/ч
    private double speedInKmh;

    @Override
    public double getSpeedMph() {
        return speedInKmh * KMH_TO_MPH;
    }

    @Override
    public void setSpeedMph(double mph) {
        this.speedInKmh = mph * MPH_TO_KMH;
    }

    @Override
    public double getSpeedKmh() {
        return speedInKmh;
    }

    @Override
    public void setSpeedKmh(double kmh) {
        this.speedInKmh = kmh;
    }
}