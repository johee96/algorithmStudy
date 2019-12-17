package algorithmJobs.level12;

import java.util.Scanner;

public class level12_1_2 {
   static long value[];

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();

      queue q = new queue(n);
      for (int i = 0; i < m; i++) {
         int a = sc.nextInt();
         if (a == 1) {
            int b = sc.nextInt();
            q.push(b);
         } else if (a == 2)
            q.pop();
         else
            q.front();
      }
   }

   static class queue {
      int size;
      int q[];
      int rear;
      int front;
      int count=0;
      queue(int size) {
         this.size = size;
         q = new int[size];
         rear = 0;
         front = 0;
      }

      void push(int v) {
           if (count==size)
            System.out.println("Overflow");
         else {
            rear++;
            if (rear == size)
               rear = 0;
            q[rear] = v;
            count++;

         }
         
      }

      void pop() {
         if (count==0) {
            System.out.println("Underflow");
         } else {
            front++;
            if (front == size)
               front = 0;
            count--;
         }
      }

      void front() {
         if (count==0)
            System.out.println("NULL");
         else {
        	  int tmp = front+1;
              if (tmp == size)
                 tmp = 0;
            System.out.println(q[tmp]);
         }
      }

   }
}
/*
4 15
1 1
1 2
1 3
3
2
2
3
1 4
1 5
3
2
2
1 6
2
3
*/