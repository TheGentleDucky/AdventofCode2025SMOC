package adventofcode2025smoc.day10.common;

import java.util.ArrayList;
import java.util.List;

public class JoltageParser {
    public List<Integer> parse(String input){
        String[] values = input.split(",");
        List<Integer> requirements = new ArrayList<>();

        for (String value : values){
            requirements.add(Integer.parseInt(value));

        }
        return requirements;
    }
}
