package com.lgalanzovskaia.dkfz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*******************************
 * IOHelper reads input from the file
 *
 * Methods:
 *      public List<String> read() - reads tokens from the file into the list
 *
 * @author Larisa Galanzovskaia
 * @version 0.1 2023-12-10
 */
public class IOHelper {

    public IOHelper() {  }

    /*********
     * Reads the input file into a list since we don't know initially
     * how many elements the file contain. Therefore, a List is an
     * appropriate structure to store the input data.
     */
    public List<String> read(String inputFile) {
        // Check whether the file exists
        if(!Files.exists(Paths.get(inputFile)))
        {
            System.out.println("IOHelper.read: Please make sure that the input file exists: " + inputFile);
            System.exit(1);
        }

        var inputData = new ArrayList<String>();
        try {
            var reader = new BufferedReader(new FileReader(inputFile));
            var currentLine = "";
            while((currentLine = reader.readLine()) != null) {
                inputData.add(currentLine);
            }
            reader.close();
            
            if(inputData.isEmpty()) {
                System.out.println("IOHelper.read: Please ensure that the input file is not empty: " + inputFile);
                System.exit(1);
            }
        } catch (IOException exception) {
            System.out.println("IOHelper.read Error: " + exception);
            System.exit(1);
        }
        return inputData;
    }

    /**
     * printToFile prints the report of the red and green counts at each position
     * in a collection of nucleotide sequences.
     * @param redSignalCounts
     * @param greenSignalCounts
     */
    public void printToFile(List<Integer> redSignalCounts, List<Integer> greenSignalCounts) {
        if (redSignalCounts == null || greenSignalCounts == null) {
            System.out.println("IOHelper.printToFile Error: parameters are null.");
            System.exit(1);
        }

        try {
            // var outputPath = System.getProperty("user.dir") + "/output/";
            var outputPath = "../../../output/";
            var printWriter = new PrintWriter(new FileWriter(outputPath + "report.txt", false));
            printWriter.print("r | g\n");
            printWriter.print("_____\n");

            // The sizes of both arrays will be equal by design
            for (var i = 0; i < redSignalCounts.size(); i++) {
                printWriter.printf("%d | %d\n", redSignalCounts.get(i), greenSignalCounts.get(i));
            }

            printWriter.close();
        } catch (IOException e) {
            System.out.println("IOHelper.printToFile Error: " + e);
            System.exit(1);
        }
    }
}
