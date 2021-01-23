package uk.tw.energy.domain;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class MeterReadings {

    @NotEmpty(message = "Smart meter list of readings is required. Must not be empty.")
    private List<ElectricityReading> electricityReadings;

    @NotEmpty(message = "Smart meter id is required. Must not be empty.")
    private String smartMeterId;

    public MeterReadings() { }

    public MeterReadings(String smartMeterId, List<ElectricityReading> electricityReadings) {
        this.smartMeterId = smartMeterId;
        this.electricityReadings = electricityReadings;
    }

    public List<ElectricityReading> getElectricityReadings() {
        return electricityReadings;
    }

    public String getSmartMeterId() {
        return smartMeterId;
    }
}
