package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test.txt"));
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[10][10]; // 989
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" -> ");
            int x1 = Integer.parseInt(split[0].split(",")[0]);
            int y1 = Integer.parseInt(split[0].split(",")[1]);
            int x2 = Integer.parseInt(split[1].split(",")[0]);
            int y2 = Integer.parseInt(split[1].split(",")[1]);
            if (x1 != x2 && y1 != y2) {
                System.out.printf("%d,%d -> %d,%d\n", x1, y1, x2, y2);
                for (int i = x1 - 1; i < y2; i++) {
                    arr[i + 1][i + 1]++;
                }
                for (int i = x2 + 1; i > y1 + 1; i--) {
                    arr[i][i - 1]++;
                }
                continue;
            }
            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2 ; j++) {
                    arr[i][j]++;
                }
            }
            for (int i = y2; i <= y1; i++) {
                for (int j = x2; j <= x1 ; j++) {
                    arr[i][j]++;
                }
            }
        }

        int counter = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] >= 2) {
                    counter++;
                }
                if (ints[j] == 0) {
                    System.out.print(".\t");
                } else {
                    System.out.print(ints[j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println(counter);
    }
}
