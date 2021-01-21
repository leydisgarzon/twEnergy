package uk.tw.energy.generator;

import org.springframework.stereotype.Component;
import uk.tw.energy.common.Constants;
import uk.tw.energy.domain.ElectricityReading;
import uk.tw.energy.interfaces.IElectricityReadingsProvider;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class StaticElectricityReadingsGenerator implements IElectricityReadingsProvider {

    @Override
    public List<ElectricityReading> obtainReadings(int number) {
        List<ElectricityReading> readings = new ArrayList<>();
        Instant now = Instant.now();

        for (int i = 0; i < number; i++) {
            BigDecimal randomReading = BigDecimal.valueOf(20L * i).setScale(Constants.READINGS_SCALE, RoundingMode.CEILING);
            ElectricityReading electricityReading = new ElectricityReading(now.minusSeconds(i * Constants.SECONDS_ELAPSE_BETWEEN_READINGS), randomReading);
            readings.add(electricityReading);
        }

        readings.sort(Comparator.comparing(ElectricityReading::getTime));
        return readings;
    }
}
