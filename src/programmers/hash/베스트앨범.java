package programmers.hash;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        베스트앨범_Solution sol = new 베스트앨범_Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 880, 2500};
        int[] re = sol.solution(genres, plays);
        for (int value : re) System.out.print(value + " ");
    }
}

class 베스트앨범_Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> tmpAns = new ArrayList<>();
        ArrayList<album> albums = new ArrayList<>();

        HashMap<String, Integer> hashMapGenresCnt = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            albums.add(new album(i, plays[i], genres[i]));
            String str = genres[i];
            if (!hashMapGenresCnt.containsKey(str))
                hashMapGenresCnt.put(str, plays[i]);
            else
                hashMapGenresCnt.put(str, hashMapGenresCnt.get(str) + plays[i]);
        }
        Collections.sort(albums);
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(albums.get(i).idx + " " + albums.get(i).plays + " " + albums.get(i).genre);
        }


        Iterator it = sortByValue(hashMapGenresCnt).iterator();
        while (it.hasNext()) {
            String genre = (String) it.next();  // 많이 재생 된 장르 찾기
            int cnt = 0;
            for (int i = 0; i < albums.size(); i++) {
                if (albums.get(i).genre.equals(genre) && cnt < 2) {
                    tmpAns.add(albums.get(i).idx);
                    cnt++;
                }
            }
        }

        answer = new int[tmpAns.size()];

        for (int i = 0; i < tmpAns.size(); i++) {
            answer[i] = tmpAns.get(i);
        }

        return answer;
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer v1 = (Integer) map.get(o1);
                Integer v2 = (Integer) map.get(o2);
                return v2 - v1;
            }
        });
        /*
          List<String> list = new ArrayList(map.keySet());
        Collections.sort(list, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });
         */
        return list;
    }

    class album implements Comparable<album> {
        int idx;
        int plays;
        String genre;

        album(int idx, int plays, String genre) {
            this.idx = idx;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(album o) {
            if (this.plays < o.plays) {
                return 1;
            } else if (this.plays == o.plays) {
                if (this.idx > o.idx) {
                    return 1;
                }
            }
            return -1;
        }
    }


}

