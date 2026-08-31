package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(); // creates an ArrayList (resizable array) to store lines from the file

        try {
            File file = new File("/Users/sbunar/Documents/computer-science-a/AOC/day3.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line.trim()); // builds list of lines from file
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
            return;
        }

        // PART 1

        long total = 0;

        for (String line: lines) {
            line = line.trim();
            String num = "";
            int numNums = 12;
            int index = -1;

            for (int j = 1; j <= numNums; j++) {
                int maxNumNumNums = 0;
                for (int i = index + 1; i <= line.length() - numNums + j - 1; i++) {
                    int numNumNum = Character.getNumericValue(line.charAt(i));
                    if (numNumNum > maxNumNumNums) {
                        maxNumNumNums = numNumNum;
                        index = i;
                    }
                }
                num += String.valueOf(maxNumNumNums);
            }
            total += Long.parseLong(num);
        }
        System.out.println("Total: " + total);
        // 172167155440541
    }
}
