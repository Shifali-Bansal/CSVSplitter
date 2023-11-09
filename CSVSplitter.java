package com.newgen.app;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVSplitter {
    public static void main(String[] args) {
        // Input CSV file with values separated by |
        String inputFilePath = "input.csv";

        // Output CSV file with values in different columns
        String outputFilePath = "output.csv";

        try {
            // Create Scanner object for reading the input CSV
            Scanner scanner = new Scanner(new File(inputFilePath));

            // Create PrintWriter object for writing to the output CSV
            PrintWriter writer = new PrintWriter(new File(outputFilePath));

            // Iterate through each line in the input CSV
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line using |
                String[] values = line.split("\\|");

                // Write the values to the output CSV
                for (String value : values) {
                    writer.print(value);
                    // Add a comma between values for CSV format
                    writer.print(",");
                }

                // Move to the next line in the output CSV
                writer.println();
            }

            // Close resources
            scanner.close();
            writer.close();

            System.out.println("CSV split and values placed in different columns successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

