public class Majority {

	public static int majority(int []array){

		int currentElement=0,curentCount=0,maxElement=0,maxCount=0;

		for(int i=0;i<array.length;i++){
			int n=array[i];
			if(currentElement==n){ curentCount++; }
			else{

				if(curentCount>maxCount){
					maxElement=currentElement;
					maxCount  =curentCount;
				}
			}
			currentElement=n;
			curentCount=0;
		}
		return maxElement;
	}

	public static void main(String[] args) {
		
		int [] a={ 2,3,4,5,6,7,7,7,8,8};
		System.out.println(majority(a));
		assert(majority(a)==7);
	}
}