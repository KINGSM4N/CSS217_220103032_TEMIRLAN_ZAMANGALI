public class BoxAdapter implements IImperialBox {

    private static final double CM_PER_INCH = 2.54;

    private final MetricBox metricBox;

    public BoxAdapter(MetricBox metricBox) {
        this.metricBox = metricBox;
    }

    @Override
    public double getWidthInches() {
        return metricBox.getWidthCm() / CM_PER_INCH;
    }

    @Override
    public double getHeightInches() {
        return metricBox.getHeightCm() / CM_PER_INCH;
    }

    @Override
    public double getAreaSquareInches() {
        return getWidthInches() * getHeightInches();
    }
}