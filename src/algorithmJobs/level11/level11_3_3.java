package algorithmJobs.level11;

import java.util.Scanner;

public class level11_3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				sum++;
			else
				sum--;
			if(sum<0)
				break;
		}
		if(sum==0)
			System.out.println("YES");
		else
			System.out.println("NO");
		

	}

}

//“(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다