import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class ClockAdapter implements IModernCalendar {

    private final LegacyClock legacyClock;

    public ClockAdapter(LegacyClock legacyClock) {
        this.legacyClock = legacyClock;
    }

    @Override
    public LocalDate getCurrentDate() {
        long epochSeconds = legacyClock.getEpochSeconds();
        Instant instant = Instant.ofEpochSecond(epochSeconds);
        return instant.atZone(ZoneOffset.UTC).toLocalDate();
    }
}