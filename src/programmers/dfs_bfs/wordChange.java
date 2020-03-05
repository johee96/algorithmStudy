package programmers.dfs_bfs;

import java.util.Arrays;

public class wordChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordChangeSolution sol = new wordChangeSolution();
		int numbers[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		int re = sol.solution("hit", "cog", words);
		System.out.println(re);
	}

}

class wordChangeSolution {
	static boolean visited[];
	static int result = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		visited = new boolean[words.length];

		// target이 words안에 없을 경우 0 return
		if (!Arrays.asList(words).contains(target))
			return 0;
		
		dfs(begin, target, words, 0);
		answer = result;
		return answer;
	}

	private void dfs(String begin, String target, String[] words, int count) {
		if (begin.equals(target)) {
			if (result > count)
				result = count;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if(visited[i])
				continue;
			int cnt = 0;
			for (int j = 0; j < begin.length(); j++)
				if (begin.charAt(j) != words[i].charAt(j))
					cnt++;
			if (cnt == 1 && !visited[i]) {
				visited[i] = true;
				System.out.println("[1] words[i] : "+words[i] +" begin: "+begin);
				dfs(words[i], target, words, count + 1);
				
				System.out.println("[2] words[i] : "+words[i] +" begin: "+begin);
				dfs(begin, target, words, count);

			}

		}
	}
}