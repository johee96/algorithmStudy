package swexpert.SWtest;

import java.util.*;

public class 보물상자비밀번호_SWTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String tmp = sc.next();
            StringBuffer data = new StringBuffer(tmp);
            ArrayList<String> nums = makePwd(data, n);

            System.out.println("#" + t + " " + changeTo10(nums.get(k - 1)));


        }
    }

    private static ArrayList<String> makePwd(StringBuffer data, int n) {
        int rotationCnt = n / 4;
        ArrayList<String> nums = new ArrayList<String>();
        for (int i = 0; i < rotationCnt; i++) {
            //data 잘라서 암호 만들기 (nums에 넣기)
            for (int j = 0; j < n; j += rotationCnt) {
                String str = data.substring(j, j + rotationCnt);
                if (!nums.contains(str))
                    nums.add(str);
            }
            //마지막 글자 앞으로 이동하기
            String del = data.substring(data.length() - 1, data.length());
            data.insert(0, del);
            data.deleteCharAt(data.length() - 1);
        }
        Collections.sort(nums, Collections.reverseOrder());
        return nums;
    }

    private static int changeTo10(String str) {
        //16진수 10진수로 바꾸기
        return Integer.valueOf(str, 16);
    }
}
