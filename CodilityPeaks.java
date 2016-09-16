import java.util.List;
import java.util.ArrayList;

public class CodilityPeaks {


	public static int peaks(int [] array) {

		int N = array.length;
		List<Integer> peaks = new ArrayList<Integer>();
		for(int i=1;i<N-1;i++){
			if(array[i] > array[i-1] && array[i] > array[i+1]) {
				peaks.add(i);
			}
		}

		for(int size=1;size<=N;size++) {

			if (N%size != 0){
				continue;
			}

			int found =0;
			int groups = N/size;
			boolean ok = true;

			for(int peakIdx : peaks) {
				if (peakIdx/size > found) {
					ok = false;
					break;
				}

				if(peakIdx/size == found) {
					System.out.println("peakIdx : "+peakIdx);
					found++;
				}
			}
  
			if(groups == found  && ok) {
				return groups;
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		
		//int [] array = {1,2,3,4,3,4,1,2,3,4,6,2};
		int [] array = {0, 0, 1, 2, 3, 2, 1, 1, 2, 2, 2, 1, 1, 0, 0, 0};

		System.out.println(peaks(array));

	}
}