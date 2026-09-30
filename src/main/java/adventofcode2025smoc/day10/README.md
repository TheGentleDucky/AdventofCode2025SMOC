# Day 10: Factory

Each machine contains a set of buttons. In Part 1 the buttons control lights, while Part 2 changes the problem to numerical joltage counters.

The input is parsed into `Machine` objects containing the target configuration, buttons and joltage requirements.

## Part 1

Each button can either be pressed or not pressed. The solution therefore explores every possible combination of button presses.

For each combination, `MachineSolver` builds the resulting light configuration by toggling the lights affected by the selected buttons. If the configuration matches the target, the number of presses is compared with the current minimum.

### Main components

- **Button** — Stores the positions affected by a button.
- **Machine** — Stores a machine's target, buttons and joltage requirements.
- **ButtonParser / JoltageParser** — Parse the different sections of the input.
- **MachineParser** — Builds the complete `Machine` objects.
- **MachineSolver** — Tests every button combination and finds the minimum number of presses.

## Part 2

The lights are replaced by joltage counters. Pressing a button now increments several counters, and the goal is to reach the exact required values.

A brute-force search over every possible sequence of button presses would be too expensive. The solution instead models the problem as a **system of linear equations**:

`A · x = b`

where each variable represents how many times a button is pressed.

### Solving the system

1. **GaussianEliminator** converts the system into reduced form and identifies the pivot columns.
2. The remaining columns are treated as **free variables**.
3. `IntegerSolutionFinder` explores possible integer values for those free variables.
4. The corresponding pivot variables are calculated from the reduced system.
5. Invalid solutions, negative values and non-integer results are discarded.
6. A small branch-and-bound optimisation stops searches that already require at least as many presses as the best solution found so far.
7. The minimum total number of button presses is returned.

### Main components

- **GaussianEliminator** — Performs Gaussian elimination and detects systems without a solution.
- **IntegerSolutionFinder** — Searches the integer solutions defined by the free variables and keeps the minimum.
- **JoltageSolver** — Connects the machine with the mathematical solver.
- **MachineParser** and the common parsers — Convert the input into the mathematical model.

This turns Part 2 from a state-space search into a constrained integer-solution problem.
