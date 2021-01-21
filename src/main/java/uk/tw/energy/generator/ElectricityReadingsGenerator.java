package uk.tw.energy.generator;

import uk.tw.energy.common.Constants;
import uk.tw.energy.domain.ElectricityReading;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ElectricityReadingsGenerator {

    public List<ElectricityReading> generate(int number) {
        List<ElectricityReading> readings = new ArrayList<>();
        Instant now = Instant.now();

        Random readingRandomiser = new Random();
        for (int i = 0; i < number; i++) {
            double positiveRandomValue = Math.abs(readingRandomiser.nextGaussian());
            BigDecimal randomReading = BigDecimal.valueOf(positiveRandomValue).setScale(Constants.READINGS_SCALE, RoundingMode.CEILING);
            ElectricityReading electricityReading = new ElectricityReading(now.minusSeconds(i * Constants.SECONDS_ELAPSE_BETWEEN_READINGS), randomReading);
            readings.add(electricityReading);
        }

        readings.sort(Comparator.comparing(ElectricityReading::getTime));
        return readings;
    }
}
