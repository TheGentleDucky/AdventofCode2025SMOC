package adventofcode2025smoc.day10.common;

import java.util.ArrayList;
import java.util.List;

public class ButtonParser {
    public List<Button> parse(String input){
        List<Button> buttons = new ArrayList<>();
        int position = 0;

        while (position < input.length()) {
            int start = input.indexOf('(', position);

            if (start == -1) {
                break;
            }

            int end = input.indexOf(')', start);

            String buttonContent = input.substring(start + 1, end);
            buttons.add(parseButtons(buttonContent));

            position = end + 1;

        }
        return buttons;
    }
    private Button parseButtons(String input) {
        String[] values = input.split(",");
        List<Integer> lights = new ArrayList<>();

        for(String value : values) {
            lights.add(Integer.parseInt(value));
        }
        return new Button(lights);
    }
}
