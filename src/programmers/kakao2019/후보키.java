package programmers.kakao2019;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {
    public static void main(String[] args) {
//        String[][] ss = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {
//                "400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
//        Solution s = new Solution();
//        System.out.println(s.solution(ss));
    }

    class Solution {

        ArrayList<HashSet<Integer>> candidates;

        public int solution(String[][] relation) {
            candidates = new ArrayList<>();
            for (int i = 0; i < relation[0].length; i++) {
                makeCandidates(0, i + 1, 0, new HashSet<Integer>(), relation);
            }

            return candidates.size();
        }

        public void makeCandidates(int index, int unit, int count, HashSet<Integer> set, String[][] relation) {
            if (count == unit) {
                if (!isUnique(set, relation)) {
                    return;
                }
                for (HashSet<Integer> key : candidates) {
                    if (set.containsAll(key))
                        return;
                }
                candidates.add(set);
                return;
            }

            //key 생성
            for (int i = index; i < relation[0].length; i++) {
                HashSet<Integer> tmpSet = new HashSet<Integer>(set);
                tmpSet.add(i);
                makeCandidates(i, unit, count + 1, tmpSet, relation);
            }

        }

        public boolean isUnique(HashSet<Integer> set, String[][] relation) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int index : set) {
                    sb.append(relation[i][index]);
                }
                if (list.contains(sb.toString()))
                    return false;
                list.add(sb.toString());
            }
            return true;
        }
    }
}


