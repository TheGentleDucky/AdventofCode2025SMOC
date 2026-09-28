package adventofcode2025smoc.day10.part2;

import adventofcode2025smoc.day10.common.Button;
import adventofcode2025smoc.day10.common.Machine;

//Intenté BFS como la parte 1: 40 millones de estados, se queda sin memoria
//Intenté DFS con poda + aproximación: Bucle de 8 horas para sacarme un resultado incorrecto.
//Obviamente, la clave no está en los gráfos. Y se me occure tremenda fumada. El input parece una Matriz... Y si no lo es, la fuerzo!!!
//El código, este entorno, hasta el propio lenguaje es maleable. Y YO SOY EL MAESTRO DE ESTA REALIDAD!
//Solución propuesta: Gauss-Jordan para sacar todas la soluciones, se reducen aquellas que no sean resultados enteros y se busca entre esa pequeña remesa de varables libres con DFS!!!
//Si es que soy un loco!!! Un genio de la abstracción. O quizá sean las 4 de la noche y me veo que voy a estar dos horas más.
//Bah.
public class MatrixBuilder {
    public LinearSystem build(Machine machine) {
        int counterCount = machine.joltageRequirements().size();
        int buttonCount = machine.buttons().size();

        int[][] coefficients = new int[counterCount][buttonCount];

        for (int buttonIndex = 0; buttonIndex < counterCount; buttonIndex++) {
            Button button = machine.buttons().get(buttonIndex);

            for (int counter : button.lights()){
                coefficients[counter][buttonIndex] = 1;
            }
        }
        int[] target = new int[counterCount];
        for (int i = 0; i < counterCount; i++) {
            target[i] = machine.joltageRequirements().get(i);
        }
        return new LinearSystem(coefficients, target);
    }
}
