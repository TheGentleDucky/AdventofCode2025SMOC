package adventofcode2025smoc.day11.part2;

import adventofcode2025smoc.day11.common.Device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathCounter {
    private final Map<String, Device> devices;
    private final Map<PathState, Long> pathsCounts;

    public PathCounter(List<Device> devices){
        this.devices = new HashMap<>();
        this.pathsCounts = new HashMap<>();

        for (Device device : devices){
            this.devices.put(device.name(), device);
        }
    }
    public long countPaths(String start) {
        return countPaths(start, false, false);
    }

    private long countPaths(String start, boolean visitDac, boolean visitFft) {
        if (start.equals("dac")) {
            visitDac = true;
        }
        if (start.equals("fft")) {
            visitFft = true;
        }
        if (start.equals("out")) {
            if (visitDac && visitFft) {
                return 1;
            }
            return 0;
        }
        PathState state = new PathState(start, visitDac, visitFft);
        if (pathsCounts.containsKey(state)) {
            return pathsCounts.get(state);
        }

        Device device = devices.get(start);
        long count = 0;

        for (String output : device.outputs()) {
            count += countPaths(output, visitDac, visitFft);
        }
        pathsCounts.put(state, count);

        return count;
    }
}
