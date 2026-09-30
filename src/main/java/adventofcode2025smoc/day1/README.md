# Day 1: Secret Entrance Password

The puzzle simulates a circular dial with positions from `0` to `99`. The input is a sequence of rotations, each indicating a direction (`L` or `R`) and a number of clicks.

## Part 1

The solution starts the dial at position `50` and processes every rotation in order.

For each rotation, the `Dial` updates its position using modular arithmetic. After each complete rotation, the new position is checked. Every time the dial finishes on position `0`, the counter is increased.

### Main components

- **Dial** — Maintains the current position and performs left/right rotations.
- **Rotation** — Represents a direction and number of clicks.
- **RotationParser** — Converts an input line into a `Rotation`.
- **RotationProcessor** — Applies the rotations and counts how many times the dial ends on `0`.
- **PasswordSolver** — Loads and prepares the rotations before running the processor.
- **Main** — Starts the solution and prints the password.

## Part 2

The important change is that reaching `0` **during** a rotation now matters, not only the final position.

The `RotationProcessor` therefore performs every click individually. After each single click, it checks whether the dial is at `0` and immediately increments the counter when necessary.

The `Dial`, `Rotation` and `RotationParser` components are reused; only the processing strategy changes between the two parts.
