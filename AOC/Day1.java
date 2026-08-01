package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(); // creates an ArrayList (resizable array) to store lines from the file

        try {
            File file = new File("/Users/sbunar/Documents/csa-summer-work/AOC/day1.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                lines.add(data); // builds list of lines from file
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found.");
            e.printStackTrace();
            return;
        }

        int count = 0;
        int total = 50;

        // PART 1
        for (String line : lines) {
            if (line.isEmpty()) continue;

            // gets direction
            char direction = line.charAt(0);

            // gets number and converts it from string to int
            int number = Integer.parseInt(line.substring(1).trim());

            System.out.println("Direction: " + direction);
            System.out.println("Number: " + number);

            // java uses single quotes for characters
            if (direction == 'L') {
                number *= -1; // if direction is left, make number opposite sign
            }
            
            total += number; // add number to total

            if (total % 100 == 0) {
                count++;
            }

            System.out.println(total % 100);  
        }

        // PART 2
        count = 0;
        int position = 50;

        for (String line : lines) {
            if (line.isEmpty()) continue;

            // gets direction
            char direction = line.charAt(0);

            // gets number and converts it from string to int
            int number = Integer.parseInt(line.substring(1).trim());

            // java automatically does integer division :)
            if (direction == 'R') {
                count += ((position + number) / 100);
                position = position + number;
            } else {
                if (position == 0) {
                    count += ((position + number) / 100);
                } else {
                    count += ((100 - position + number) / 100);
                }

                position += 100 - (number % 100);
            }
            position = position % 100;
        }

        System.out.println(count);
    }
}