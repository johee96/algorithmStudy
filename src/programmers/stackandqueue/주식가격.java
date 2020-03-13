package programmers.stackandqueue;

public class 주식가격 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 2, 3};
        주식가격_Solution sol = new 주식가격_Solution();
        int[] result = sol.solution(data);
        for(int re : result){
            System.out.print(re+" ");

        }
    }
}
class 주식가격_Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            int target = prices[i];
            int cnt=0;
            for(int j=i+1;j<prices.length;j++){
                cnt++;
                if(prices[i]>prices[j])
                    break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}