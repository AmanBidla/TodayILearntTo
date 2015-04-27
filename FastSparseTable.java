import java.util.Arrays;


public class FastSparseTable{

	int [] array;
	int [] logTable;
	int [][] tree;


	public static void main(String[] args) {
		
		FastSparseTable ft = new FastSparseTable();
		int [] array ={2,4,3,6,7,8,9,0,7}; 
		ft.create(array);

	}

	public void create (int [] array){

		this.array=array;
		int N = array.length;
		populateLog(N); 


	}


	public  void populateLog(int N){

		logTable = new int[N+1];
		int counter = 0;
        int log = 0;
        int num = 1;
        
        logTable[0] = 0;
        
        for (int i = 1; i < logTable.length; i++) {
            counter++;
            logTable[i] = log;
            if (counter == num) {
                log++;
                num *= 2;
                counter = 0;
            }
        }

		System.out.println(Arrays.toString(logTable));

	}


}