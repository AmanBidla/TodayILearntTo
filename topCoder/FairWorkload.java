public class FairWorkload{


	public static void main(String[] args) {
		
		/*int [] array ={ 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int numberOfWorkers=3;
		*/

		/*int [] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int numberOfWorkers=5;*/

		/*int [] array ={ 568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782 };
		int numberOfWorkers=4;*/

		int [] array ={ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000 };
		int numberOfWorkers=2;



		FairWorkload f = new FairWorkload();
		System.out.println(f.divideWork(numberOfWorkers,array));


	}


	public int divideWork(int numberOfWorkers, int [] folders){

		int N= folders.length;
		int low = getMaxFolderSizeInCabinet(folders);
		int high = getSumOfAllFoldersInCabinet(folders);

		while(low<high){

			int required=1,workLoad=0;
			int x=low+(high-low)/2;


			for(int i=0;i<N;i++){

				if(workLoad+folders[i]<=x){
					workLoad+=folders[i];
				}else{
					workLoad=folders[i];
					required++;
				}				
			}

			if(required<=numberOfWorkers){
				high =x;		
			}else{
				low=x+1;
			}
		}

		return low;
	}

	public int getMaxFolderSizeInCabinet(int []folders){
		int max=0;
		for(int i=0;i<folders.length;i++)
			if(max<folders[i]) max = folders[i];
		return max;
	}

	public int getSumOfAllFoldersInCabinet(int [] folders){
		int sum=0;
		for(int i=0;i<folders.length;i++)
			sum+=folders[i];
		return sum;
	}
}