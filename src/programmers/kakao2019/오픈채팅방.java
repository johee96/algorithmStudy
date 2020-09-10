//package programmers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class 오픈채팅방 {
//    public static void main(String[] args) {
//
//    }
//
//    class Solution {
//        public String[] solution(String[] record) {
//            String[] answer = {};
//            ArrayList<String> ans = new ArrayList<>();
//            HashMap<String, String> data = new HashMap<>();
//
//            for (int i = 0; i < record.length; i++) {
//                String[] com = record[i].split(" ");
//                if (com[0].equals("Enter") || com[0].equals("Change")) {
//                    data.put(com[1], com[2]);
//                }
//            }
//
//            for (int i = 0; i < record.length; i++) {
//                String an = "";
//                String[] com = record[i].split(" ");
//                if (com[0].equals("Enter")) {
//                    an = data.get(com[1]) + "님이 들어왔습니다.";
//                } else if (com[0].equals("Leave")) {
//                    an = data.get(com[1]) + "님이 나갔습니다.";
//                } else
//                    continue;
//                ans.add(an);
//            }
//
//            answer = new String[ans.size()];
//            for (int i = 0; i < ans.size(); i++)
//                answer[i] = ans.get(i);
//
//            return answer;
//        }
//    }
//}
package programmers.kakao2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        for (String str : solution(record)) {
            System.out.println(str);
        }
    }

    static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>(); // 기록용
        for (int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            if (info[0].equals("Enter")) {
                map.put(info[1], info[2]);
                list.add(info[1] + "님이 들어왔습니다.");
            } else if (info[0].equals("Leave")) {
                list.add(map.get(info[1]) + "님이 나갔습니다.");
            } else { // change
                if (map.containsKey(info[1])) {
                    map.put(info[1], info[2]);
                }
            }
        }

//      System.out.println(list.size());
//
//      for(String str : list) {
//         System.out.println(str);
//      }
        String[] answer = new String[list.size()];

        int i = 0;
        for (String str : list) {
            int end = str.indexOf("님");
            String userId = str.substring(0, end);
            System.out.println(userId + " " + map.get(userId));
            answer[i++] = str.replace(userId, map.get(userId));
        }

        return answer;
    }
}