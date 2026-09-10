package adventofcode2025smoc.day9.common;

import java.util.ArrayList;
import java.util.List;

public class TileParser {
    public List<RedTile> parse(List<String> input) {
        List<RedTile> tiles = new ArrayList<>();
        for (String line : input) {
            tiles.add(parseTile(line));
        }
        return tiles;
    }

    public RedTile parseTile(String tile) {
        String[] coords = tile.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);

        return new RedTile(x, y);
    }
}
