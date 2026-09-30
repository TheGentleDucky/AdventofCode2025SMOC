#Day 6: Trash Compactor

The input contains a worksheet with several mathematical problems. Each problem consists of a group of numbers and an operator (+ or *).

The main challenge of the day is not the arithmetic itself, but correctly identifying and interpreting the problems from the worksheet layout.

Part 1

In the first part, each problem is written horizontally. Empty columns are used to separate the different problems.

The WorksheetParser scans the worksheet column by column and detects the ranges that belong to each problem. Once a problem has been identified, its numbers and operator are extracted and stored in a Problem object.

The resulting problems are then passed to ProblemChecker, which performs the corresponding addition or multiplication.

The Main class coordinates the process:

Read the input using the common FileProcessor.
Parse the worksheet into a list of Problem objects.
Solve each problem using ProblemChecker.
Sum all the individual results.
Main components
Problem — Represents a mathematical problem, containing its numbers and operator.
WorksheetParser — Detects the individual problems in the worksheet and extracts their numbers and operators.
ProblemChecker — Evaluates a Problem using either addition or multiplication.
Main — Coordinates the parsing and calculation process.
Part 2

Part 2 keeps the same overall worksheet structure, but changes how the numbers inside each problem must be interpreted.

Instead of reading the numbers normally from each row, the digits have to be read vertically from right to left. Each column represents a number, with the digits from top to bottom forming that number.

For example, the parser processes the columns of each problem starting from the rightmost column and reconstructs the numbers from their individual digits.

The separation of responsibilities is slightly different from Part 1. WorksheetParser is still responsible for identifying the boundaries of each problem, but the actual interpretation of the contents is delegated to ProblemParser.

The flow is therefore:

Read the worksheet using FileProcessor.
WorksheetParser identifies the individual problem ranges.
ProblemParser reads each problem from right to left and reconstructs its numbers.
Each problem is represented using the common Problem class.
ProblemChecker performs the required operation.
The results of all problems are summed to obtain the final answer.
Main components
Problem — Common representation of a mathematical problem, shared by both parts.
ProblemChecker — Common calculation component that performs addition or multiplication.
WorksheetParser — Identifies the boundaries of each problem in the worksheet.
ProblemParser — Specific to Part 2. Reads the digits vertically and from right to left to reconstruct the numbers.
Main — Coordinates the complete Part 2 process.

The key difficulty in this part is therefore the parsing strategy rather than the arithmetic itself.
