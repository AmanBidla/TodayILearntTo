public class FindElementIn2dArray{

	public static boolean find(int[][] array,int item){

		int i=0;
		int j=array.length-1;
		System.out.println("j is "+j);
		while(i<=array.length-1 && j>=0){
		 	if(array[i][j]==item) return true;
			if(array[i][j]<item) i++;
			else j--;

			System.out.println("inside loop");
		}

		return false;

	}

	public static void main(String[] args) {
			
			int [][] array ={{1,2,3,4,5,6,7,8},{2,3,4,5,6,7,8,9},{10,11,12,13,14,15,16,17}};
			int [][] a={{1,2,3},{2,3,4},{3,4,5}};
			System.out.println(" element 3 is present is "+find(a,3));

	}

}