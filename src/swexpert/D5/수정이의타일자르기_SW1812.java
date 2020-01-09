package swexpert.D5;

import java.util.*;

public class 수정이의타일자르기_SW1812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> tiles = new ArrayList<>();           //입력받은 n개의 타일들
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                tiles.add((int) Math.pow(2, v));
            }
            tiles.sort(Comparator.reverseOrder());

            System.out.println("#" + t + " " + getTiles(n, m, tiles));

        }
    }

    private static int getTiles(int n, int m, ArrayList<Integer> tiles) {
        int result = 1;
        ArrayList<Rect> rects = new ArrayList<>();
        rects.add(new Rect(m, m));

        for (int i = 0; i < n; i++) {
            int targetTile = tiles.get(i);
            boolean addTile = true;
            int size = rects.size();
            for (int j = 0; j < size; j++) {
                Rect tmp = rects.get(j);
                if (tmp.w - targetTile >= 0 && tmp.h - targetTile >= 0) {
                    //타일 사용할 수 있음
                    addTile = false;
                    if (tmp.h - targetTile > 0 && targetTile > 0)
                        rects.add(new Rect(targetTile, tmp.h - targetTile));
                    if (tmp.h > 0 && tmp.w - targetTile > 0)
                        rects.add(new Rect(tmp.w - targetTile, tmp.h));
                    rects.remove(j);
                    break;
                }
            }
            if (addTile) {
                result++;
                rects.add(new Rect(targetTile, m - targetTile));
                rects.add(new Rect(m - targetTile, m));

            }

        }
        return result;
    }

    static class Rect {
        int w, h;
        public Rect(int w, int h) {
            this.w = w;
            this.h = h;
        }

    }

}
