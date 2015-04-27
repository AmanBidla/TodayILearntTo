import java.util.Arrays;

public class RotateArray{

	public static int [] rotate(int [] array, int d){

		int N = array.length;
		int gcd = getGCD(N,d);
		int temp,j,k;
		for(int i=0;i<gcd;i++){
			temp= array[i];
			j=i;
			while(true){
				k=j+d;
				/*if(k>=N){
					k=k-N;
				}*/
				k=k%N;
				if(k==i){
					break;
				}
				array[j]=array[k];
				j=k;
			}
			array[j]=temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int [] array={1,2,3,4,5,6,7,8,9,10,11,12};
		array = rotate(array,3);
		System.out.println(Arrays.toString(array));
	}

	public static int getGCD(int a, int b){
		if(b==0){
			return a;
		}else{
			return getGCD(b,a%b);
		}
	}
}