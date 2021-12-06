package aoc.Knowit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Dag1 {
    private HashMap<String, Integer> map = createMap();

    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("tall_test.txt"));
        char[] arr = sc.nextLine().toCharArray();
        StringBuilder buf = new StringBuilder();
        int total = 0, num, last = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 65533) c = 'å';
            if (map.containsKey(buf.toString())) {
                String temp = buf.toString();
                if (buf.toString().equals("tre")) {
                    if (i + 4 < arr.length) {
                        String s = read(arr, i, i + 4);
                        if ((temp + s).equals("tretten")) {
                            i += 4;
                            temp = "tretten";
                        }
                    }
                    String s = read(arr, i, i + 3);

                    if ((temp + s).equals("tretti")) {
                        i += 3;
                        temp = "tretti";
                    }
                } else if (temp.equals("fem")) {
                    if (i + 3 < arr.length) {
                        String s = read(arr, i, i + 3);
                        if ((temp + s).equals("femten")) {
                            i += 3;
                            temp = "femten";
                        }
                        s = read(arr, i, i + 2);
                        if ((temp + s).equals("femti")) {
                            i += 2;
                            temp = "femti";
                        }

                    }
                } else if (temp.equals("seks")) {
                    String s = read(arr, i, i + 3);
                    if ((temp + s).equals("seksten")) {
                        i += 3;
                        temp = "seksten";
                    }
                } else if (temp.equals("ni")) {
                    String s = read(arr, i, i + 4);
                    if ((temp + s).equals("nitten")) {
                        i += 4;
                        temp = "nitten";
                    }
                }
                num = map.get(temp);

                if (last != -1) {
                    total += last + num;
                    last = -1;
                } else {
                    switch (num) {
                        case 20, 30, 40 -> last = num;
                        default -> total += num;
                    }
                }
                buf.setLength(0);
            }
            buf.append( c);
        }
        if (buf.length() != 0) total += map.get(buf.toString());
        if (last != -1) total += last;
        System.out.println(total);
    }

    private String read(char[] bytes, int i, int n) {
        if (i > n) {
            throw new IllegalArgumentException("i cannot be larger than n");
        }
        StringBuilder buf = new StringBuilder();
        while (i < n) {
            buf.append(bytes[i++]);
        }
        return buf.toString();
    }


    HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("en", 1);
        map.put("to", 2);
        map.put("tre", 3);
        map.put("fire", 4);
        map.put("fem", 5);
        map.put("seks", 6);
        map.put("sju", 7);
        map.put("åtte", 8);
        map.put("ni", 9);
        map.put("ti", 10);
        map.put("elleve", 11);
        map.put("tolv", 12);
        map.put("tretten", 13);
        map.put("fjorten", 14);
        map.put("femten", 15);
        map.put("seksten", 16);
        map.put("sytten", 17);
        map.put("atten", 18);
        map.put("nitten", 19);
        map.put("tjue", 20);
        map.put("tjueen", 21);
        map.put("tjueto", 22);
        map.put("tjuetre", 23);
        map.put("tjuefire", 24);
        map.put("tjuefem", 25);
        map.put("tjueseks", 26);
        map.put("tjuesju", 27);
        map.put("tjueåtte", 28);
        map.put("tjueni", 29);
        map.put("tretti", 30);
        map.put("trettien", 31);
        map.put("trettito", 32);
        map.put("trettitre", 33);
        map.put("trettifire", 34);
        map.put("trettifem", 35);
        map.put("trettiseks", 36);
        map.put("trettisju", 37);
        map.put("trettiåtte", 38);
        map.put("trettini", 39);
        map.put("førti", 40);
        map.put("førtien", 41);
        map.put("førtito", 42);
        map.put("førtitre", 43);
        map.put("førtifire", 44);
        map.put("førtifem", 45);
        map.put("førtiseks", 46);
        map.put("førtisju", 47);
        map.put("førtiåtte", 48);
        map.put("førtini", 49);
        map.put("femti", 50);

        return map;
    }
}
