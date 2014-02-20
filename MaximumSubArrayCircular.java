public class MaximumSubArrayCircular{

	public static void main(String[] args) {
			
		// int [] array = {904,40,523,12,-355,-385,-124,481,-31}; //  answer 1929
		//int [] array ={8, -8, 9, -9, 10, -11, 12}; // answer : 22
		//int [] array = {10, -3, -4, 7, 6, 5, -4, -1} ; // answer : 23
		int [] array =  {-3, 6, 2, 1, 7, -8, 13, 0};; // answer : 26
		System.out.println(find(array));
	}


	public static int findUsingCompare(int []array,boolean max){

		int till=0,overAll=0;
		for(int a:array){
			till = compare(a, a+till,max);
			overAll = compare(overAll,till,max);
		}
		return overAll;

	}

	public static int compare(int a, int b, boolean max){
		if(max){
			return Math.max(a,b);
		}else{
			return Math.min(a,b);
		}
	}

	public static int find(int [] array){

		 int max=findUsingCompare(array,true);
		 int accumalate = 0;
		 for(int i=0;i<array.length;i++){
		 	accumalate+=array[i];
		 }
		 int min=findUsingCompare(array,false);
		 return Math.max(max, accumalate-min);

	}

}