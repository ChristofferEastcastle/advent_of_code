package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input2.txt"));
        int depth = 0, horizontal = 0, aim = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            int val = Integer.parseInt(s[1]);
            String str = s[0];
            if (str.equals("forward")) {
                horizontal += val;
                depth += val * aim;
            } else if (str.equals("down")) {
                aim += val;
            } else {
                aim -= val;
            }
        }
        System.out.println(depth * horizontal);
    }
}
