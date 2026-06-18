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

    public static String readText(Scanner keyboard, String message) {
        String text = "";

        while (text.length() == 0) {
            System.out.print(message);
            text = keyboard.nextLine().trim();

            if (text.length() == 0) {
                System.out.println("Input cannot be empty.");
            }
        }

        return text;
    }

    public static boolean readYesNo(Scanner keyboard, String message) {
        while (true) {
            System.out.print(message);
            String answer = keyboard.nextLine().trim().toLowerCase();

            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            else if (answer.equals("no") || answer.equals("n")) {
                return false;
            }
            else {
                System.out.println("Please enter yes or no.");
            }
        }
    }

    public static int readIntBetween(Scanner keyboard, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(keyboard.nextLine());

                if (value < min || value > max) {
                    System.out.println("Enter a number from " + min + " to " + max + ".");
                }
                else {
                    return value;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }

    public static String readOptionalText(Scanner keyboard, String message) {
        System.out.print(message);
        String text = keyboard.nextLine().trim();

        if (text.length() == 0) {
            return "No reason given";
        }

        return text;
    }
}
