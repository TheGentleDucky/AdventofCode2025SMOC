package adventofcode2025smoc.day3.part1;

import java.util.stream.Stream;

public class BatteryBankCalculator {
    private final BatteryCalculator batteryCalculator;

    public BatteryBankCalculator(BatteryCalculator batteryCalculator) {
        this.batteryCalculator = batteryCalculator;
    }

    public long calculateTotalVoltage(Stream<String> banks) {
        return banks.mapToLong(batteryCalculator::calculateMaxVoltage).sum();
    }
}
