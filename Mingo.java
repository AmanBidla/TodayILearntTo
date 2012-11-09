/*
There is a game they termed as Mingo. A random generator (like a speaker standing in a group housie game calls out a number) generates out any number from 1 to 1000.
There is a 10X10 matrix. A random generator assigns values to each block of this matrix(within 1 to 1000 obviously).
Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers called out by the speaker, its called a 'Mingo'.
Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.



*/
import java.util.Random;
public class Mingo{

	public static int[][] matrix = new int[10][10];

 

	public static void main(String abc[]){
		
		
		Random rand = new Random();
		Random row = new Random();
		Random col = new Random();
		int count=0,countallrows=0,countallcols=0,countdiag=0,i,countMingo=0;
		
			for(i=0;i<10;i++)
				for(int j=0;j<10;j++)
					matrix[i][j]=-1;
		int rowi,rowj;
		while(count<100){
			rowi=row.nextInt(10);
			rowj=col.nextInt(10);
			if(matrix[rowi][rowj]!=-1){
				matrix[rowi][rowj]=rand.nextInt();
				count++;
				}
 			/* check if all rows are filled */
			for(i=0;i<10;i++){
				if(matrix[i][rowj]==-1) break;
				else countallcols++;
			}
			if(countallcols==10){
				countMingo++;
				System.out.println(countMingo+" Mingo ");
 			/*	for(i=0;i<10;i++){
 					System.out.print(matrix[i][rowj]);
 				}*/
					break;
 				}
		

			/* check if all columns are filled */
			for(i=0;i<10;i++){
				if(matrix[rowi][rowj]==-1) break;
				else countallrows++;
			}
		   if(countallrows==10){
			countMingo++;
			System.out.println(countMingo+" Mingo ");
 			/*for( i=0;i<10;i++){
 				System.out.print(matrix[rowi][i]);
 			}*/
				break;
 		   }
		/* check if all diagnals are filled */
		for(i=0;i<10;i++){
			if(matrix[i][i]==-1) break;
			else countdiag++;
		}
		if(countdiag==10){
			countMingo++;
			System.out.println(countMingo+" Mingo ");
 			/*for( i=0;i<10;i++){
 				System.out.print(matrix[i][i]);
 			}*/
 			break;
			}
		
		}
		
		for(i=0;i<100;i++){
			for(int j=0;j<10;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}

}