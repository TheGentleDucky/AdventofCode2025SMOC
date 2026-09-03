package adventofcode2025smoc.day5.part1;

import adventofcode2025smoc.FileProcessor;

public class Main {
    static void main() {
        FileProcessor fp = new FileProcessor();
        InventoryStock inventoryStock  = new InventoryStock();

        Inventory inventory = inventoryStock.parse(fp.readLines("D5_Input.txt").toList());
        IngredientChecker checker = new IngredientChecker(inventory.ranges());

        FreshCounter freshCounter = new FreshCounter();
        long freshCount = freshCounter.countFresh(inventory.ingredients(), checker);

        System.out.println("Número de ingredientes frescos: " + freshCount);
    }
}
