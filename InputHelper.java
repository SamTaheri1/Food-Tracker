import java.util.Scanner;

class InputHelper {
    public static int readInt(Scanner keyboard) {
        while (true) {
            try {
                int value = Integer.parseInt(keyboard.nextLine());
                if (value < 0) {
                    throw new NumberFormatException();
                }
                return value;
            }
            catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    public static double readDouble(Scanner keyboard) {
        while (true) {
            try {
                double value = Double.parseDouble(keyboard.nextLine());
                if (value < 0) {
                    throw new NumberFormatException();
                }
                return value;
            }
            catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}