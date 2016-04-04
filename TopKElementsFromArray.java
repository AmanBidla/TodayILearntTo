import java.util.*;
public class TopKElementsFromArray{

	static int[] topK(int[] iStream, int iK) {

       Queue<Integer> maxQueue = new PriorityQueue<Integer>(iK,new Comparator<Integer>(){

			@Override
			public int compare(Integer v1, Integer v2){
				if(v1<v2) return 1;
				else if(v1>v2) return -1;
				else return 0;
			}
		});        
         
        for(int i=0;i<iStream.length;i++){
            maxQueue.add(iStream[i]);
        }   
        System.out.println("max queue size "+maxQueue.size());
        int []topK = new int[iK]; 
        for(int j=0;j<topK.length;j++) {
            topK[j] = maxQueue.poll();
            System.out.println("topK["+j+"] "+topK[j]);
        }         
        return topK;            
    }

    public static void main(String[] args) {
    	
    	int [] array = {7,1,23,12,9,30,2,50,2};
    	System.out.println("input "+Arrays.toString(array));
    	int [] result = topK(array,2);
    	System.out.println(Arrays.toString(result));
    }

}