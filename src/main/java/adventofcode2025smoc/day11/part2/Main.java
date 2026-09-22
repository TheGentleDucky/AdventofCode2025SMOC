package adventofcode2025smoc.day11.part2;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day11.common.Device;
import adventofcode2025smoc.day11.common.DeviceParser;

import java.util.List;

public class Main {
    static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        DeviceParser deviceParser = new DeviceParser();
        List<Device> devices = fileProcessor.readLines("D11_Input.txt").map(deviceParser::parseDevice).toList();

        PathCounter pathCounter = new PathCounter(devices);

        long totalPaths = pathCounter.countPaths("svr");
        System.out.println("Caminos totales: " + totalPaths);


    }
}
