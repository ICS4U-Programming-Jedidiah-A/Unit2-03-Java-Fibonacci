import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program calculates amount of mean median and mode.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-04-19
*/

public final class Fibonacci {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) {

        // Initialize variables
        String list1;
        final String err = "Err";
        try {
            // creating input and output file
            final File input = new File("input.txt");
            final FileWriter writer = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner = new Scanner(input);

                // ArrayList to hold the lines
                final ArrayList<String> lists = new ArrayList<>();

                // Getting the input from the first file
                while (scanner.hasNextLine()) {

                    // Get next line for the list
                    list1 = scanner.nextLine();
                    lists.add(list1);
                }

                // creating a new array to hold this data
                final int[] numbers = new int[lists.size()];

                // taking the data from the list and put it in new array
                for (String list2 : lists) {
                    try {
                        final int list3 = Integer.parseInt(list2);
                        if (list3 >= 0) {
                            final int solution = recFib(list3);
                            writer.write(
                                solution
                                + "\n"
                            );
                        } else {
                            writer.write("Err:User input cannot"
                                + "be a negative number.\n");
                        }
                    } catch (NumberFormatException error) {
                        writer.write("Err: " + list2 + " is not a valid"
                            + " number.\n");
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }

            // closes the writer
            writer.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method reverse the string.
    *
    * @param numStr This is the number used in the fibonacci sequence
    * @return sequence
    */

    public static int recFib(int numStr) {
        if (numStr <= 1) {
            return numStr;
        } else {
            return recFib(numStr - 1) + recFib(numStr - 2);
        }
    }
}
