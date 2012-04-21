/* write a program in c# or java or c that prints saddle points in a N by N Matrix. 
Saddle point is matrix[i][j] such that matrix[i][j] min of rows and max of columns 
eg.  1,2,3
     4,5,6
     7,8,9  has saddle point as 7
*/

import java.io.*;
public class SaddlePoint{


	public static void main(String abc[])
	{
		String row,column,allnumbers;
		int rows,columns,count;
		int [][] matrix;
		System.out.println("Enter number of rows: ");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
		int maxrownum=0,mincolnum=0,colnum=0;;
          row= br.readLine();
		  rows = Integer.parseInt(row);
       	  System.out.println("Enter number of columns: ");
		  br = new BufferedReader(new InputStreamReader(System.in));
	 	  column= br.readLine();
		  columns = Integer.parseInt(column);
		  matrix = new int[rows][columns];
		for(int i=0;i<rows;i++){
			count=columns;
 			  System.out.println("Enter numbers for rows "+(i+1)+" as comma seperated values: ");		
 			  allnumbers= br.readLine();
			  String []allNums= allnumbers.split(",");
			System.out.println("length is "+allNums.length);
			
			  for(int j=0;j<columns;j++)
				matrix[i][j]=Integer.parseInt(allNums[j]);
		}
		System.out.println("*********************");
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					System.out.print(matrix[i][j]+"   ");
				}
				System.out.println("");
			}
		System.out.println("*********************");
		
		for(int i=0;i<rows;i++)
		{
				maxrownum=matrix[i][0];
			for(int j=0;j<columns;j++)
			{

			System.out.println("current maxrownum is "+maxrownum+" for a["+i+"]["+j+"]");
				if(maxrownum>=matrix[i][j])
					{
					maxrownum=matrix[i][j];
					colnum=j;
			//		System.out.println("maxrownum is "+maxrownum+" for a["+i+"]["+colnum+"]");
			
					}
			}
			System.out.println("maxrownum is "+maxrownum+" for a["+i+"]["+colnum+"]");
			mincolnum=maxrownum;
			for(int k=0;k<rows;k++){
				if(mincolnum<=matrix[k][colnum])
				{
					mincolnum=matrix[k][colnum];
				}
			}
			

			System.out.println("mincolnum is "+mincolnum);
			if(mincolnum==maxrownum){
 				System.out.println("saddle point is "+maxrownum);
			}
			
		}
		
		
 		
		} catch (IOException e) {
	         System.out.println("Error!");
	    }		
		


	
	}

}