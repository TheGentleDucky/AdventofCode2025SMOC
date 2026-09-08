package adventofcode2025smoc.day8.part1;

import adventofcode2025smoc.day8.common.JunctionBox;

import java.util.*;

public class CircuitManager {
    private final Map<JunctionBox, JunctionBox> parent;
    private final Map<JunctionBox, Integer> sizes;

    public CircuitManager(List<JunctionBox> junctionBoxes) {
        this.parent = new HashMap<>();
        this.sizes = new HashMap<>();

        for (JunctionBox box: junctionBoxes ) {
            parent.put(box, box);
            sizes.put(box, 1);
        }
    }
    public void connect(JunctionBox first, JunctionBox second) {
        JunctionBox firstRoot = find(first);
        JunctionBox secondRoot = find(second);

        if (firstRoot == secondRoot) {
            return;
        }
        if (sizes.get(firstRoot) < sizes.get(secondRoot)) {
            JunctionBox temp = firstRoot;
            firstRoot = secondRoot;
            secondRoot = temp;
        }
        parent.put(secondRoot, firstRoot);
        sizes.put(firstRoot, sizes.get(firstRoot) + sizes.get(secondRoot));

    }

    public List<Integer> getSizes() {
        List<Integer> circuitSizes = new ArrayList<>();

        for (JunctionBox box: parent.keySet()) {
            if (isRoot(box)) {
                circuitSizes.add(sizes.get(box));
            }
        }
        return circuitSizes;
    }

    private boolean isRoot(JunctionBox box) {
        return parent.get(box) == box;
    }


    private JunctionBox find(JunctionBox box) {
        JunctionBox currentBox = box;

        while (parent.get(currentBox) != (currentBox)) {
            currentBox = parent.get(currentBox);
        }
        return currentBox;
    }
}
