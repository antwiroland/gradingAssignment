import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter student grades
        System.out.println("Please enter students grades (0-100), separated by spaces:");

        // Read the input line, trim whitespace, and split into an array of strings
        String[] input = scanner.nextLine().trim().split("\\s");

        // Create an integer array to store the parsed grades
        int[] scores = new int[input.length];

        // Convert each string grade to an integer
        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }

        // Get the number of grades entered
        int N = scores.length;

        // Handle case where no grades were entered
        if (N == 0) {
            System.out.println("No grades entered");
            scanner.close();
            return;
        }

        // Initialize variables to track max, min, and sum of grades
        int maxGrade = scores[0];
        int minGrade = scores[0];
        double sum = 0;

        // Calculate max, min, and sum of all grades
        for (int grade : scores) {
            if (grade > maxGrade) maxGrade = grade;
            if (grade < minGrade) minGrade = grade;
            sum += grade;
        }

        // Calculate the average grade
        double avgGrade = sum / N;

        // Print the statistics
        System.out.println("\nvalues");
        System.out.printf("The maximum grade is %d\n", maxGrade);
        System.out.printf("The minimum grade is %d\n", minGrade);
        System.out.printf("The average grade is %.6f\n", avgGrade);

        // Create an array to store counts of grades in different ranges
        // Index 0: 0-20, 1: 21-40, 2: 41-60, 3: 61-80, 4: 81-100
        int[] stats = new int[5];

        // Count how many grades fall into each range
        for (int grade : scores) {
            if (grade > 80) {
                stats[4]++;
            } else if (grade >= 61) {
                stats[3]++;
            } else if (grade >= 41) {
                stats[2]++;
            } else if (grade >= 21) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }

        // Print the graph header
        System.out.println("\nGraph: ");

        // Find the maximum count in any range (for scaling the graph)
        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) maxCount = count;
        }
        if (maxCount == 0) maxCount = 1; // Prevent division by zero if all counts are zero

        // Print the vertical bar graph
        for (int c = maxCount; c >= 1; c--) {
            System.out.print(c + " > \t"); // Print the scale on the left
            for (int stat : stats) {
                if (stat >= c) {
                    System.out.print("#######"); // Print a bar segment
                } else {
                    System.out.print("       "); // Print empty space
                }
                System.out.print("   "); // Space between bars
            }
            System.out.println(); // Move to next line
        }

        // Print the graph footer with range labels
        System.out.println("\t+-----------+---------+---------+---------+---------+");
        System.out.println("\tI   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}