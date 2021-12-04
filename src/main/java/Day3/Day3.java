package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input3.txt"));
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        HashMap<Integer, int[]> map = countBits(list);

        int gamma = 0, epsilon = 0, pow = map.size() - 1;

        for (int i = 0; i < map.size(); i++) {
            int[] ints = map.get(i);

            if (ints[0] > ints[1]) {
                epsilon += Math.pow(2, pow--);
            } else {
                gamma += Math.pow(2, pow--);
            }
        }
        System.out.println(gamma * epsilon);
    }

    protected static HashMap<Integer, int[]> countBits(List<String> list) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for (String in : list) {
            for (int i = 0; i < in.length(); i++) {
                int bit = Character.getNumericValue(in.charAt(i));
                if (map.containsKey(i)) {
                    map.get(i)[bit] += 1;
                } else {
                    int[] arr = new int[] {0, 0};
                    arr[bit] = 1;
                    map.put(i, arr);
                }
            }
        }
        return map;
    }
}
