package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day3B {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner sc = new Scanner(new File("input3.txt"));
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        int[] answer = {0};
        Thread thread = new Thread(() -> findOxygenRating(list, answer));
        thread.start();

        int co2Rating = findCO2Rating(list);

        thread.join();
        System.out.println(answer[0] * co2Rating);
    }

    private static int findOxygenRating(ArrayList<String> list, int[] answer) {
        //int[] answer = {0};
        find(list, 0, answer, true);

        return answer[0];
    }

    private static int findCO2Rating(ArrayList<String> list) {
        int[] answer = {0};
        find(list, 0, answer, false);

        return answer[0];
    }

    private static void find(List<String> list, int i, int[] answer, boolean findingOxygen) {
        if (list.size() == 1) {
            String s = list.get(0);
            int pow = s.length() - 1;
            for (String bits : s.split("")) {
                answer[0] += Integer.parseInt(bits) * Math.pow(2, pow--);
            }
            return;
        }

        var mapBits = mapBits(list);

        var listMap = mapBits.get(i++);
        int ones = listMap.get(1).size();
        int zeros = listMap.get(0).size();

        if (findingOxygen) {
            if (zeros > ones) {
                find(listMap.get(0), i, answer, findingOxygen);
            } else {
                find(listMap.get(1), i, answer, findingOxygen);
            }
        } else {
            if (zeros <= ones) {
                find(listMap.get(0), i, answer, findingOxygen);
            } else {
                find(listMap.get(1), i, answer, findingOxygen);
            }
        }
    }

    private static HashMap<Integer, HashMap<Integer, List<String>>> mapBits(List<String> list) {
        HashMap<Integer, HashMap<Integer, List<String>>> map = new HashMap<>();

        for (String in : list) {
            for (int i = 0; i < in.length(); i++) {
                int bit = Character.getNumericValue(in.charAt(i));
                if (map.containsKey(i)) {
                    HashMap<Integer, List<String>> innerMap = map.get(i);
                    if (innerMap.containsKey(bit)) {
                        innerMap.get(bit).add(in);
                    } else {
                        innerMap.put(bit, new ArrayList<>(List.of(in)));
                    }
                } else {
                    HashMap<Integer, List<String>> hashMap = new HashMap<>();
                    hashMap.put(bit, new ArrayList<>(List.of(in)));
                    map.put(i, hashMap);
                }
            }
        }
        return map;
    }

}
