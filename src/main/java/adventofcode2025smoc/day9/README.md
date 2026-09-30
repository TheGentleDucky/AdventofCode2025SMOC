# Day 9: Movie Theater

The input contains red tiles positioned on a two-dimensional grid. Pairs of red tiles can act as opposite corners of a rectangle.

## Part 1

The solution considers every pair of red tiles and treats them as opposite corners.

The width and height are calculated from their coordinates, including both boundary tiles. The area of every possible rectangle is compared and the largest one is returned.

### Main components

- **RedTile** — Represents the coordinates of a red tile.
- **TileParser** — Converts the input into red tiles.
- **RectangleCalculator** — Evaluates all possible pairs and finds the largest rectangle.
- **Main** — Loads the input and starts the calculation.

## Part 2

Part 2 adds an important restriction: the rectangle must remain completely inside the polygon defined by the red tiles.

The solution still considers every pair of red tiles, but before calculating the area it validates the candidate rectangle.

The validation has two stages:

1. Check whether any polygon edge crosses the interior of the candidate rectangle.
2. Check whether the rectangle's centre lies inside the polygon using a point-in-polygon test.

Only rectangles that satisfy these conditions are considered valid. The largest valid area is then returned.

This keeps the same pair-based approach from Part 1 while adding the geometric validation required by Part 2.
