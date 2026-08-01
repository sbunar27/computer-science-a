package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File("/Users/sbunar/Documents/csa-summer-work/AOC/day2.txt");
            Scanner scanner = new Scanner(file);
            
            String fullText = "";
            while (scanner.hasNextLine()) {
                fullText += scanner.nextLine();
            }
            scanner.close();

            String[] tempArray = fullText.split(",");
            for (String item : tempArray) {
                lines.add(item.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found.");
            e.printStackTrace();
            return;
        }

        // PART 1
        // instead of using int, use long to avoid overflow for big numbers because java has a limit
        long total1 = 0;

        for (String line : lines) {
            if (line.isEmpty()) continue;

            // split by '-' to get start and end of range
            String[] parts = line.split("-");
            long start = Long.parseLong(parts[0].trim());
            long end = Long.parseLong(parts[1].trim());

            for (long num = start; num <= end; num++) {
                String numStr = String.valueOf(num);
                int lenNum = numStr.length();
                int halfNum = lenNum / 2;

                String firstHalf = numStr.substring(0, halfNum);
                String secondHalf = numStr.substring(halfNum);

                // check if first half is equal to second half using .equals() instead of a ==
                if (firstHalf.equals(secondHalf)) {
                    total1 += num;
                }
            }
        }

        System.out.println("part 1: " + total1);

        // PART 2
        long total2 = 0;

        for (String line : lines) {
            if (line.isEmpty()) continue;

            String[] parts = line.split("-");
            long start = Long.parseLong(parts[0].trim());
            long end = Long.parseLong(parts[1].trim());

            for (long num = start; num <= end; num++) {
                String numStr = String.valueOf(num);
                int lenNum = numStr.length();

                for (int l = 1; l < lenNum; l++) {
                    if (lenNum % l == 0) {

                        boolean allMatch = true;
                        String firstChunk = numStr.substring(0, l);

                        // check the remaining chunks
                        for (int i = l; i < lenNum; i += l) {
                            String newChunk = numStr.substring(i, i + l);
                            if (!newChunk.equals(firstChunk)) {
                                allMatch = false;
                                break;
                            }
                        }

                        if (allMatch) {
                            total2 += num;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("part 2: " + total2);
    }
}