package adventofcode2025smoc.day1.part1;

public class Main {

    public static void main(String[] args) {
      PasswordSolver solver = new PasswordSolver();

        try {
            int password = solver.solve("D1_Input.txt");
            System.out.println("The password is: " + password);
        } catch (Exception e) {
            System.err.println("Failed to compute password: " + e.getMessage());
        }
    }
}