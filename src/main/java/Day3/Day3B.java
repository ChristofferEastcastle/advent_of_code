package Day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day3B {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input3.txt"));
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }

        int oxygen = findResult(list, true);
        int co2 = findResult(list, false);

        System.out.println(oxygen * co2);
    }

    private static int findResult(List<String> list, boolean findingOxygen) {
        int[] i = {0};
        while (list.size() > 1) {
            long ones = list.stream().filter(s -> s.charAt(i[0]) == '1').count();
            long zeros = list.stream().filter(s -> s.charAt(i[0]) == '0').count();
            char c;
            if (findingOxygen) {
                if (ones >= zeros) c = '1';
                else c = '0';
            } else {
                if (zeros <= ones) c = '0';
                else c = '1';
            }
            list = list.stream().filter(s -> s.charAt(i[0]) == c).collect(Collectors.toList());
            i[0]++;
        }
        return getDecimalValue(list.get(0));
    }


    private static int getDecimalValue(String string) {
        int pow = string.length() - 1, result = 0;
        for (String bits : string.split("")) {
            result += Integer.parseInt(bits) * Math.pow(2, pow--);
        }
        return result;
    }
}
