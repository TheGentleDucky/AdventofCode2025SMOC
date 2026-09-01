package adventofcode2025smoc.day3.part2;

import adventofcode2025smoc.FileProcessor;

public class Main {
    static void main() {
        BatteryCalculator batteryCalculator = new BatteryCalculator();
        FileProcessor fileProcessor = new FileProcessor();

        long total = fileProcessor.readLines("D3_Input.txt").mapToLong(batteryCalculator::calculateMaxJoltage).sum();
        System.out.println("Total voltage: " + total);
    }
}
