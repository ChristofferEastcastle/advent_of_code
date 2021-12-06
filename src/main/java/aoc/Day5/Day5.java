package aoc.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input5.txt"));
        int[][] arr = new int[1000][1000];
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" -> ");
            int x1 = Integer.parseInt(split[0].split(",")[0]);
            int y1 = Integer.parseInt(split[0].split(",")[1]);
            int x2 = Integer.parseInt(split[1].split(",")[0]);
            int y2 = Integer.parseInt(split[1].split(",")[1]);
            // Means we go diagonally
            if (x1 != x2 && y1 != y2) {
                int temp;
                // Swapping so traversal logic is easier
                if (y1 > y2) {
                    temp = y1;
                    y1 = y2;
                    y2 = temp;
                    temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                while (y1 <= y2) {
                    if (x1 <= x2) {
                        arr[y1++][x1++]++;
                    } else {
                        arr[y1++][x1--]++;
                    }

                }
            } else {
                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        arr[i][j]++;
                    }
                }
                for (int i = y2; i <= y1; i++) {
                    for (int j = x2; j <= x1; j++) {
                        arr[i][j]++;
                    }
                }
            }
        }
        int counter = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] >= 2) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
