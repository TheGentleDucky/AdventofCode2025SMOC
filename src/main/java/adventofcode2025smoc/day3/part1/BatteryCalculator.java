package adventofcode2025smoc.day3.part1;

public class BatteryCalculator {
    public int calculateMaxVoltage(String bank) {
        int max = 0;

        for (int i = 0; i < bank.length() - 1; i++) {
            int first = bank.charAt(i) - '0';

            for (int j = i + 1; j < bank.length(); j++) {
                int second = bank.charAt(j) - '0';
                int value = first * 10 + second;

                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }
}
