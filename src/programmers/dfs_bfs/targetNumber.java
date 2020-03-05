package programmers.dfs_bfs;

public class targetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		targetNumberSolution sol = new targetNumberSolution();
		int numbers[] = {1,1,1,1,1};
		int re = sol.solution(numbers,3);
		System.out.println(re);
	}

}
class targetNumberSolution {
	static int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,target,0,0);
        answer = count;
        return answer;
    }
    
    private void dfs(int[] numbers, int target,int idx, int current) {
    	
    	if(idx == numbers.length) {
    		if(current == target)
    			count++;
    		return;
    	}
    	int v = numbers[idx];
    	dfs(numbers,target,idx+1,current + v);
    	dfs(numbers,target,idx+1,current + v*-1);    	
    	
    }

}

