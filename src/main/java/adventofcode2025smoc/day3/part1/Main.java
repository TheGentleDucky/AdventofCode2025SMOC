package adventofcode2025smoc.day3.part1;

import adventofcode2025smoc.FileProcessor;

public class Main {

    public static void main(String[] args)  {
        BatteryCalculator batteryCalculator = new BatteryCalculator();
        FileProcessor fileProcessor = new FileProcessor();
        BatteryBankCalculator batteryBankCalculator = new BatteryBankCalculator(batteryCalculator);

        long total = batteryBankCalculator.calculateTotalVoltage(fileProcessor.readLines("D3_Test.txt"));
        System.out.println("Total voltage: " + total);

    }
}
