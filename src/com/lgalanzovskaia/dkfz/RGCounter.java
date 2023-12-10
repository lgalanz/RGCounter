package com.lgalanzovskaia.dkfz;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Provides the driver program for counting the red-laser signals and green-laser signals
 * in the course of sequencing a collection of DNA strings.
 *
 * @author Larisa Galanzovskaia
 * @version 0.1 2023-12-10
 */
public class RGCounter {
    //private static final String INPUT_PATH = System.getProperty("user.dir") + "/input/";
    private static final String INPUT_PATH = "../../../input/";

    public static void main(String[] args) {
        // Check if the input file was provided
        if (args.length == 0) {
            System.out.println("main: Missing arguments: please enter the names of the input file.");
            System.exit(1);
        }

        var ioHelper = new IOHelper();
        var data = ioHelper.read(INPUT_PATH + args[0]);

        var redSignalCounts = new ArrayList<Integer>();
        var greenSignalCounts = new ArrayList<Integer>();
        data.forEach(s -> {
            var i = new AtomicInteger();
            s.chars().forEach(c -> {
                if (i.get() >= redSignalCounts.size()) {
                    redSignalCounts.add(i.get(), 0);
                }
                if (i.get() >= greenSignalCounts.size()) {
                    greenSignalCounts.add(i.get(), 0);
                }

                switch (c) {
                    case 'A' -> {
                        redSignalCounts.set(i.get(), redSignalCounts.get(i.get()) + 1);
                        greenSignalCounts.set(i.get(), greenSignalCounts.get(i.get()) + 1);
                    }
                    case 'C' -> redSignalCounts.set(i.get(), redSignalCounts.get(i.get()) + 1);
                    case 'T' -> greenSignalCounts.set(i.get(), greenSignalCounts.get(i.get()) + 1);
                    // G nt does not add to any signal
                }
                i.getAndIncrement();
            });
        });

        ioHelper.printToFile(redSignalCounts, greenSignalCounts);

    }
}
