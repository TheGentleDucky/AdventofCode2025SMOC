package adventofcode2025smoc.day3.part1;

import adventofcode2025smoc.FileProcessor;

public class Main {

    public static void main(String[] args)  {
        BatteryCalculator batteryCalculator = new BatteryCalculator();
        FileProcessor fileProcessor = new FileProcessor();

        long total = fileProcessor.readLines("D3_Input.txt")
                .mapToLong(batteryCalculator::calculateMaxVoltage).sum();

        System.out.println("Total voltage: " + total);

    }
}
