package uk.tw.energy.interfaces;

import uk.tw.energy.domain.ElectricityReading;
import java.util.List;

/**
 * Electricity Readings Provider.
 */
public interface IElectricityReadingsProvider {
    List<ElectricityReading> obtainReadings();
}
