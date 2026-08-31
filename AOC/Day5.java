package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File("/Users/sbunar/Documents/computer-science-a/AOC/day5.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line.trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }

        // PART 1

        // split into ranges and ingredient IDs

        // find the index of the blank line
        int blankIndex = lines.indexOf("");
        // lines before blank line (ranges)
        ArrayList<String> rangeLines = new ArrayList<>(lines.subList(0, blankIndex));
        // lines after blank line (ingredient IDs)
        ArrayList<String> idLines = new ArrayList<>(lines.subList(blankIndex + 1, lines.size()));

        // stores the start and end of each range in an array of 2 integers
        ArrayList<long[]> ranges = new ArrayList<>();
        ArrayList<long[]> points = new ArrayList<>();

        for (String line : rangeLines) {
            line = line.trim();

            // split the line into two parts using the -
            String[] parts = line.split("-");

            // parse the two parts into integers (start and end of range)
            long a = Long.parseLong(parts[0]);
            long b = Long.parseLong(parts[1]);

            // add the range to the list of ranges
            ranges.add(new long[]{a, b});

            // 0 represents the start of a range, 1 represents the end of a range
            points.add(new long[]{a, 1}); // start of range
            points.add(new long[]{b, -1}); // end of range
        }

        // sort points based on the first element of the array (the point value)
        // this will sort the list using a custom comparator for long arrays
        // returns a negative number if p1 < p2, 0 if p1 == p2, and a positive number if p1 > p2
        Collections.sort(points, new Comparator<long[]>() {
            // long[] stores the start and end range values
            public int compare(long[] p1, long[] p2) {
                return Long.compare(p1[0], p2[0]);
            }
        });

        // count fresh IDs
        long freshCount = 0;
        for (String line : idLines) {
            // checks if x is in any of the ranges
            long x = Long.parseLong(line.trim());
            for (long[] range : ranges) {
                if (x >= range[0] && x <= range[1]) {
                    freshCount++;
                    break;
                }
            }
        }
        System.out.println("Part 1: " + freshCount);
        // 652
    }


}
