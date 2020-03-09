package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        완주하지못한선수_Solution solution = new 완주하지못한선수_Solution();
        String[] data1 = {"leo", "kiki", "eden"};
        String[] data2 = {"eden", "kiki"};
        System.out.print(solution.solution(data1, data2));
    }
}


class 완주하지못한선수_Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String str = participant[i];
            if (!hashMap.containsKey(str))
                hashMap.put(str, 1);
            else
                hashMap.put(str, hashMap.get(str) + 1);
        }
        for (String com : completion) {
            if (hashMap.get(com) > 1) {
                hashMap.put(com, hashMap.get(com) - 1);
            } else {
                hashMap.remove(com);
            }
        }

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            answer = key;
        }
        return answer;
    }
}
