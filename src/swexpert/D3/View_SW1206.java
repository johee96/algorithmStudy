package swexpert.D3;
import java.util.Scanner;

public class View_SW1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      Scanner sc = new Scanner(System.in);

	      for (int TC = 1; TC <= 10; TC++) {
	         int count = 0;
	         int num = sc.nextInt();
	         int building[] = new int[num];
	         for (int i = 0; i < num; i++)
	            building[i] = sc.nextInt();
	         
	         for(int i=2;i<num-2;i++) {
	            int left = -1;
	            int right = -1;
	            int result = -1;
	            
	            left = Math.max(building[i-1],building[i-2]);
	            right = Math.max(building[i+1],building[i+2]);
	            result = Math.max(left, right);
	            
	            result = building[i]-result;
	            if(result>0)
	               count+=result;
	            
	         }
	      System.out.println("#"+TC+" "+count);
	      }

	}

}
