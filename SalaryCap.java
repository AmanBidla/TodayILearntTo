public class SalaryCap{

	private static int findCap(int [] sal, int cap){

		int sum =0;

		for(int i=0;i<sal.length;i++){
			sum+=sal[i];
		}

		int begin =0,end=sum;

		while(begin <end){

			int mid = begin + (end-begin)/2;
			int total =0;
			for(int i=0;i<sal.length;i++){
				if(sal[i]<mid)
					total+=sal[i];
				else
					total+=mid;
			}
			System.out.println("current begin "+begin+" middle "+mid +" end "+end+" total "+total);
			if(total>cap){
				end = mid-1;
			}else if( total< cap){
				begin = mid+1;
			}else
				return mid;
		}

		return -1;

	}

	public static void main(String[] args) {
		
		int [] sal ={90,30,100,40,20};
		int cap=210;
		int ans = findCap(sal,cap);
		System.out.println("ans "+ans);
	}

}