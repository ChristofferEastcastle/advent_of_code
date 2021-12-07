package aoc.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6 {
    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input6.txt"));

        List<Integer> list = Arrays.stream(sc.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        int days = 80;
        for (int i = 0; i < days; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                if (list.get(j) == 0) {
                    list.set(j, 6);
                    list.add(8);
                } else {
                    list.set(j, list.get(j) - 1);
                }
            }
        }
        System.out.println(list.size());

    }
}
