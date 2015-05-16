public class PascalTriangleCopy{

	public static void pascal(int rows){

		for(int i=0;i<rows;i++){

			System.out.format("%"+(rows-i)*2+"s","");
			int number=1;
			for(int j=0;j<=i;j++){
				System.out.format("%4d",number);
				number=number*(i-j)/(j+1);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		pascal(8);
	}
}