import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayDeque;

public class Main {
	
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);

 		int tests = Integer.parseInt(sc.nextLine());
 		String [] testQueue = new String[2*tests];
 		int t=0;

 		for(int i=0;i<tests;i++){

 			String firstLine = sc.nextLine();
 			String secondLine = sc.nextLine();
 			testQueue[t]=firstLine;
 			t++;
 			testQueue[t]=secondLine;
 			t++;
 		}
 		t=0; 		
 		for(int i=0;i<tests;i++){

 			String firstLine = testQueue[t];
 			t++;
 			String secondLine = testQueue[t];
 			t++;
 			System.out.println("Case "+(i+1)+": "+ process(firstLine,secondLine)); 			
 		}
 		

 	}


	public static int process(String firstLine,String secondLine){

 		int fileNum = Integer.parseInt(firstLine.split(" ")[0]);
 		int merge = Integer.parseInt(firstLine.split(" ")[1]);
 		PriorityQueue<Integer> q = new PriorityQueue<Integer>();


 		String array [] = secondLine.split(" ");

 		for(String s:array){
 			q.add(Integer.parseInt(s));
 		}

 		int cost=0;
 		int i=0;
 		int v=0;
 		while(q.size()> merge){ 			
 			while(i<merge){
 				v+=q.poll();
 				i++;
 			}
 			cost+=v;
 			q.add(v);
 			v=0;
 			i=0;
 		}
  
 		while(i<merge&& q.size()>0){
 			v+=q.poll();
 			i++;
 		}
 		cost+=v;
 		return cost;
 	}

 

}