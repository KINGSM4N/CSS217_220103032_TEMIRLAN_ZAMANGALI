import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureSensorAdapter implements ICelsiusSensor {

    private final FahrenheitSensor fahrenheitSensor;

    public TemperatureSensorAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        String raw = fahrenheitSensor.readRawTemperature();

        String numericPart = raw.replace(" F", "").trim();

        double fahrenheit = Double.parseDouble(numericPart);

        double celsius = (fahrenheit - 32) * (5.0 / 9.0);

        BigDecimal rounded = BigDecimal.valueOf(celsius)
                .setScale(2, RoundingMode.HALF_UP);

        return rounded.doubleValue();
    }
}