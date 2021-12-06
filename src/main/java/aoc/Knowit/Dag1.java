package aoc.Knowit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Dag1 {
    public void solve() throws IOException {
        FileInputStream stream = new FileInputStream("tall_test.txt");

        var map = createMap();

        StringBuilder buf = new StringBuilder();

        int total = 0, temp, last = -1;
        byte[] bytes = stream.readAllBytes();
        for (int i = bytes.length - 1; i >= 0; i--) {
            byte b = bytes[i];
            buf.insert(0, (char) b);
            if (map.containsKey(buf.toString())) {
                int num = map.get(buf.toString());
                if (last != -1) {
                    total += num;
                    buf.setLength(0);
                } else {
                    last = num;
                }
            }
        }

        System.out.println(total);

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
