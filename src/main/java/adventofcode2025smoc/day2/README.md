# Day 2: Invalid ID's Sum

The input contains ranges of numerical product IDs. An ID is considered invalid when its digits follow a particular repeated pattern.

## Part 1

For every range, the solution examines each ID and checks whether its number can be divided into two identical halves.

The `InvalidIDFinder` performs the validation by converting the ID to a string, checking that it has an even number of digits and comparing both halves.

All invalid IDs are collected and then added together to obtain the final answer.

### Main components

- **InvalidIDFinder** — Reads the ranges and identifies invalid IDs.
- **InvalidIDSum** — Calculates the sum of the invalid IDs.
- **Main** — Loads the input, executes the finder and prints the result.

## Part 2

Part 2 generalizes the invalid pattern. An ID is now invalid when it consists of the **same sequence repeated multiple times**, rather than only exactly twice.

The solution checks possible chunk sizes and verifies that the complete ID is made exclusively from repetitions of the first chunk.

For example, a number such as `123123123` can be detected because the sequence `123` is repeated.

The overall flow remains the same: parse the ranges, test every ID, collect the invalid IDs and sum them.
