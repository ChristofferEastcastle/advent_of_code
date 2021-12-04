package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            sum.add(sc.nextInt());
        }

        int prev = sum.stream().mapToInt(s -> s).sum();
        int increasing = 0;
        while (sc.hasNextInt()) {
            sum.remove(0);
            sum.add(sc.nextInt());
            int nextSum = sum.stream().mapToInt(s -> s).sum();
            if (nextSum > prev) {
                increasing++;
            }
            prev = nextSum;
        }
        System.out.println(increasing);
    }
}
