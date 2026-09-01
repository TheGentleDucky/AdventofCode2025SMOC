package adventofcode2025smoc.day3.part2;

public class BatteryCalculator {

    private static final int maxBatteries = 12;

    public long calculateMaxJoltage(String bank) {
        String voltage = "";

        int start = 0;

        for (int i = 0; i < maxBatteries; i++) {
            int count = maxBatteries - i;
            int lastIndex = bank.length() - count;

            int maxIndex = start;

            for (int j = start; j <= lastIndex; j++) {
                if (bank.charAt(j) > bank.charAt(maxIndex)) {
                    maxIndex = j;
                }
            }
            voltage += bank.charAt(maxIndex);
            start = maxIndex + 1;
        }
        return Long.parseLong(voltage);
    }
}
