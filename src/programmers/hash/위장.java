package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class 위장 {
    public static void main(String[] args) {
        위장_Solution sol = new 위장_Solution();
        String[][] data = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.print(sol.solution(data));
    }
}

class 위장_Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if (!hashMap.containsKey(key))
                hashMap.put(key, 1);
            else
                hashMap.put(key, hashMap.get(key) + 1);
        }
        answer = 1;
        for (int value : hashMap.values()) {
            answer*=(value+1);
        }
        answer-=1;
        return answer;
    }
}
/*
(A종류 옷 가지수 + 1)*(B종류 옷 가지수 + 1)...-1(-1은 아무것도 선택하지 않은 경우)
 */