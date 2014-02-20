 import java.util.LinkedList;
 import java.util.List;
 import java.util.ArrayList;
 import java.util.Iterator;

 public class TextAlign{

 	private static int [][] S;	
 	private static int [] T;
 	private static int [] B;
 	private static int L;
 	private static int [] cumilativeSum;


 	public static void fillSlack(List<String> words ){
 		int N = words.size();
 		S = new int[N][N];
 		for(int i=1;i<N;i++){
 			for(int j=i+1;j<N;j++){
 				if(j==(N-1))
 					S[i][j]=0;
				if(L< (j-i+(cumilativeSum[j]-cumilativeSum[i-1])) ){
 					S[i][j] = Integer.MAX_VALUE;
 				}else{
 					int k =L-j+i-(cumilativeSum[j]-cumilativeSum[i-1]);
 					System.out.println(i+" "+j+" "+N);
 					S[i][j]=k * k * k;
 				}
 			}	
 		}

 		for(int i=0;i<N;i++){
 			for(int j=0;j<N;j++){
 				System.out.print(S[i][j]+" ");
 			}
 			System.out.println();
 		}	 
 		 
 	}

 	public static List<Integer> fillTable(List<String> words){
 		int N = words.size();
 		
 		T = new int[N];
 		B = new int[N];
 		S = new int[N][N];

 		fillSlack(words);

 		T[0]=0;
 		B[0]=0;

 		for(int i=1;i<N;i++){
 			T[i]= Integer.MAX_VALUE;
 		}	

 		for(int j=1;j<N;j++){
 			for(int i=1 ;i<=j;i++){
 				if(S[j][i]>=0){
 					T[j]=Math.min(T[j], (S[j][i]*S[j][i])+T[i-1]);
 					B[j]=i;
 				}
 			}
 		}

 		for(int i=0;i<N;i++){
 			System.out.print(T[i]+ " ");
 		}
 		System.out.println();
 		for(int i=0;i<N;i++){
 			System.out.print(B[i]+" ");
 		}
 		System.out.println();

 		LinkedList<Integer> OPT = new LinkedList<Integer>();
 		int j=N-1;
 		while(j>0){
 			System.out.println("adding "+j);
 			OPT.addLast(j);
 			System.out.println("B["+j+"] "+B[j]);
 			j=B[j]-1;

 		}
 		return OPT;
 	}

 	public static void main(String[] args) {
 		List<String> words = fillWords();
 		L=16;
 		fillSlack(words);
 		//List<Integer> indexes = fillTable(words);
 		//showSolution(indexes,words);
 	}

 	public static void showSolution(List<Integer> indexes,List<String>words){

 		Iterator<Integer> it = indexes.iterator();
 		while(it.hasNext()){
 			System.out.println(words.get(it.next()));
 		}
 	}

 	public static List<String> fillWords(){
 		List<String> words = new ArrayList<String>();
 		String sentence = "This is a test of code. It has many small words to let the code try lots of cases";
 		String [] array = sentence.split(" ");
 		int i=1;
 		cumilativeSum = new int [array.length];
 		cumilativeSum[0]=0;

 		for(String word:array){
 			words.add(word);
 			System.out.println("adding word "+word);
 			cumilativeSum[i+1]=word.length();
 		}
 		return words;
 	}

 }