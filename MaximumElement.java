public class MaximumElement {

	public static void main(String[] args) {
		
		MaximumElement me = new MaximumElement();

		int [] array = {4, 2, 2, 3, 2, 4, 3, 2, 6, 4};
		int [] a={ 2,3,4,5,6,7,7,7,8,8};
		int [] b={ 8,8,2,3,8,5,8,8,8,6,7,8,7,1,2,8};

		me.findMaxElement(b);
	}

	public void findMaxElement(int [] array){

		if(array.length==0) return;

		int count=0;

		int max = array[0];

		for(int i=1;i<array.length;i++)
		{
			if(max==array[i]){
				count ++;
			}else
				count --;

		if(count==0)
		{
			count=1;
			max = array[i];
		}
			
		}
		System.out.println("max element is "+max);

	}


}