# Day 5: Cafeteria

The input describes ranges of fresh ingredient IDs followed by individual ingredient IDs.

## Part 1

The solution parses the input into two collections:

- Ranges containing fresh IDs.
- Individual ingredient IDs that need to be checked.

Each ingredient is tested against the available ranges. If it belongs to at least one range, it is considered fresh.

`FreshCounter` counts all ingredients that pass the check.

### Main components

- **Ranges** — Represents an inclusive range of IDs.
- **Inventory** — Groups the ranges and ingredient IDs.
- **InventoryStock** — Parses the input into an `Inventory`.
- **IngredientChecker** — Determines whether an individual ingredient belongs to a fresh range.
- **FreshCounter** — Counts fresh ingredients.

## Part 2

Part 2 no longer asks about individual ingredients. Instead, the solution must count **all IDs covered by the fresh ranges**.

Checking every possible ID would be inefficient because the ranges can be very large. The solution therefore sorts the ranges by their starting value and merges overlapping ranges.

The merged ranges can then be counted directly using:

`max - min + 1`

This ensures that IDs covered by several overlapping ranges are only counted once.
