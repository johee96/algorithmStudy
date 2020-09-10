package baekjoon.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(br.readLine());

        ArrayList<Integer> wList = new ArrayList<>();
        ArrayList<Integer> hList = new ArrayList<>();
        wList.add(0);
        wList.add(h);

        hList.add(0);
        hList.add(w);

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (id == 0) {
                wList.add(value);
            } else {
                hList.add(value);
            }
        }

        Collections.sort(wList);
        Collections.sort(hList);

        int wMax = 0;
        int hMax = 0;

        for (int i = 1; i < wList.size(); i++) {
            wMax = Math.max(wMax, wList.get(i) - wList.get(i - 1));
        }
        for (int i = 1; i < hList.size(); i++) {
            hMax = Math.max(hMax, hList.get(i) - hList.get(i - 1));
        }
        if (hMax == 0)
            hMax = h;
        if (wMax == 0)
            wMax = w;

        System.out.print(wMax * hMax);
    }
}
