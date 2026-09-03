package adventofcode2025smoc.day5.part2;

import adventofcode2025smoc.FileProcessor;

import java.util.List;

public class Main {
    static void main() {
        FileProcessor fp = new FileProcessor();
        InventoryStock inventoryStock = new InventoryStock();

        Inventory inventory = inventoryStock.parse(fp.readLines("D5_Input.txt").toList());
        FreshCounter freshCounter = new FreshCounter();

        long freshCount = freshCounter.freshInRange(inventory.ranges());


        System.out.println("Número de Ingredientes Frescos en Todos los Rangos: " + freshCount);
    }
}
