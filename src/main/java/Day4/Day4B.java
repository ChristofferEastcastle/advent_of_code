package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4B {
    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input4.txt"));

        List<Spot> draw = Arrays.stream(sc.nextLine()
                        .split(","))
                .map(s -> new Spot(Integer.parseInt(s)))
                .collect(Collectors.toList());

        sc.nextLine(); // First Empty Line
        HashMap<Spot, List<Board>> map = new HashMap<>();
        List<String> buffer = new ArrayList<>();

        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            if (in.isEmpty()) {
                new Board(buffer, map);
                buffer.clear();
            } else {
                buffer.add(in);
            }
        }
        System.out.println(mark(map, draw));

    }

    private int mark(HashMap<Spot, List<Board>> map, List<Spot> draw) {
        int wins = 0;
        for (Spot spot : draw) {
            for (Board board : map.get(spot)) {
                if (board.hasWon) continue;
                List<List<Spot>> lists = board.board;
                for (List<Spot> spots : lists) {
                    for (Spot spot1 : spots) {
                        if (spot1.equals(spot)) {
                            spot1.setMarked(true);
                            if (board.hasBingo()) {
                                board.hasWon = true;
                                wins++;
                                if (wins == 100)
                                    return board.calculate(spot);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    class Board {
        private List<List<Spot>> board = new ArrayList<>();
        private boolean hasWon = false;

        public Board(List<String> list, HashMap<Spot, List<Board>> map) {
            for (String s : list) {
                s = s.strip();
                List<Spot> spots = Arrays.stream(s.split(" +"))
                        .map(num -> new Spot(Integer.parseInt(num)))
                        .collect(Collectors.toList());
                board.add(spots);
                addToMap(map, spots);
            }
        }

        private void addToMap(HashMap<Spot, List<Board>> map, List<Spot> spots) {
            spots.forEach(spot -> {
                if (map.containsKey(spot)) {
                    map.get(spot).add(this);
                } else {
                    map.put(spot, new ArrayList<>(List.of(this)));
                }
            });
        }

        public int calculate(Spot spot) {
            int result = 0;
            for (List<Spot> get : board) {
                result += get.stream().filter(spots -> !spots.isMarked()).mapToInt(spots -> spots.value).sum();
            }
            return result * spot.value;
        }

        public List<Spot> get(int index) {
            return board.get(index);
        }

        public boolean hasBingo() {
            for (int i = 0; i < 5; i++) {
                int rows = 0, cols = 0;
                for (int j = 0; j < 5; j++) {
                    if (get(i).get(j).isMarked()) rows++;
                    if (get(j).get(i).isMarked()) cols++;

                    if (rows == 5 || cols == 5) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Spot {
        private int value;
        private boolean marked = false;

        public Spot(int value) {
            this.value = value;
        }

        public boolean isMarked() {
            return marked;
        }

        public void setMarked(boolean marked) {
            this.marked = marked;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Spot)) return false;
            Spot spot = (Spot) o;
            return value == spot.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
