package adventofcode2025smoc.day11.common;

import java.util.Arrays;
import java.util.List;

public class DeviceParser {
    public Device parseDevice(String input) {
        String[] parts = input.split(":");

        String deviceName = parts[0].trim();
        List<String> outputs = Arrays.asList(parts[1].trim().split(" "));

        return new Device(deviceName, outputs);
    }
}
