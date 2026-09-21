package adventofcode2025smoc.day11.part1;

import adventofcode2025smoc.day11.common.Device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathCounter {
    private final Map<String, Device> devices;

    public PathCounter(List<Device> devices) {
        this.devices = new HashMap<>();

        for (Device device : devices){
            this.devices.put(device.name(), device);
        }
    }

    public long countPaths(String start) {
        if (start.equals("out")) {
            return 1;
        }

        Device device = devices.get(start);
        long total = 0;

        for (String output : device.outputs()) {
            total += countPaths(output);
        }
        return total;
    }
}
