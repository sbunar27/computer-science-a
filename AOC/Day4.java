package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) {
        // creates a 2D ArrayList to store the grid
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();

        try {
            File file = new File("/Users/sbunar/Documents/computer-science-a/AOC/day4.txt");
            Scanner scanner = new Scanner(file);

            // reads each line from the file
            // converts it to a char array and adds each character to a row
            // row is then added to the grid
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Character> row = new ArrayList<>();
                for (char c : line.trim().toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return;
        }

        int H = grid.size(); // number of rows
        int W = grid.get(0).size(); // number of columns

        // PART 1

        int ans = 0;

        // loops through each row and column in the grid
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                // checks if the cell contains @
                if (grid.get(r).get(c) == '@') {
                    int n = 0;

                    // count the 8 neighbors
                    if (r > 0 && grid.get(r - 1).get(c) != '.') {
                        n++; // up
                    }
                    if (r < H - 1 && grid.get(r + 1).get(c) != '.') {
                        n++; // down
                    }
                    if (c > 0 && grid.get(r).get(c - 1) != '.') {
                        n++; // left
                    }
                    if (c < W - 1 && grid.get(r).get(c + 1) != '.') {
                        n++; // right
                    }
                    if (r > 0 && c > 0 && grid.get(r - 1).get(c - 1) != '.') {
                        n++; // up-left
                    }
                    if (r > 0 && c < W - 1 && grid.get(r - 1).get(c + 1) != '.') {
                        n++; // up-right
                    }
                    if (r < H - 1 && c > 0 && grid.get(r + 1).get(c - 1) != '.') {
                        n++; // down-left
                    }
                    if (r < H - 1 && c < W - 1 && grid.get(r + 1).get(c + 1) != '.') {
                        n++; // down-right
                    }

                    // if the number of neighbors is less than 4, add 1 to the answer
                    if (n < 4) {
                        ans++;
                    }
                }
            }
        }

        System.out.println("Part 1: " + ans);
        // 1445
    }

}