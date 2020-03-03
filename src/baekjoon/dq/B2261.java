package baekjoon.dq;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//@Todo 한 번 더 풀기
public class B2261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        ArrayList<Point> data = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data.add(new Point(a, b));
        }

        Collections.sort(data);
        System.out.println(solve(data, 0, n - 1));

    }

    static int solve(ArrayList<Point> data, int start, int end) {
        if (end - start + 1 <= 3)
            return searchMin(data, start, end);
        int mid = (start + end) / 2;
        int left = solve(data, start, mid);
        int right = solve(data, mid + 1, end);
        int min = Math.min(left, right);

        ArrayList<Point> tmp = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int v = data.get(i).x - data.get(mid).x;
            if (v * v < min)
                tmp.add(data.get(i));
        }

        Collections.sort(tmp, Comparator.comparingInt(o -> o.y));

        int tmpSize = tmp.size();
        for (int i = 0; i < tmpSize - 1; i++) {
            for (int j =  i+1; j < tmpSize; j++) {
                int v = tmp.get(i).y - tmp.get(j).y;
                if (v * v < min) {
                    int dist = getDist(tmp.get(i), tmp.get(j));
                    if (dist < min)
                        min = dist;
                } else {
                    break;
                }
            }
        }
        return min;
    }

    static int searchMin(ArrayList<Point> data, int start, int end) {
        int result = Integer.MAX_VALUE;
        for (int i = start; i <= end - 1; i++) {
            for (int j = i + 1; j <= end; j++) {
                int v = getDist(data.get(i), data.get(j));
                if (result > v)
                    result = v;
            }
        }
        return result;
    }

    static int getDist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;
        }
    }


}