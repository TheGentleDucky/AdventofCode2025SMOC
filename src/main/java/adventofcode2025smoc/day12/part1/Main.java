package adventofcode2025smoc.day12.part1;

import adventofcode2025smoc.FileProcessor;
import adventofcode2025smoc.day12.common.Region;
import adventofcode2025smoc.day12.common.TreeArea;

public class Main {
    static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        TreeAreaParser treeAreaParser = new TreeAreaParser();
        ShapeChanger shapeChanger = new ShapeChanger();
        PlacementGenerator placementGenerator = new PlacementGenerator(shapeChanger);
        TreeAreaSolver treeAreaSolver = new TreeAreaSolver(placementGenerator);

        TreeArea tree = treeAreaParser.parseTree(fileProcessor.readLines("D12_Input.txt"));

        int fittingRegions = 0;

        for(Region region : tree.regions()){
            if (treeAreaSolver.canFit(region, tree.shapes())){
                fittingRegions++;
            }
        }
        System.out.println("Fitting regions: " + fittingRegions);

    }
}
