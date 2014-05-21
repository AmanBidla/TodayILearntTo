import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
public class LevenshteinDistance{


	private static List<String> allWords = new ArrayList<String>();
	private static List<String> dict = new ArrayList<String>();

	public static void main(String[] args) {
		
		read(args[0]);
		//show();
		find();

	}


	private static void find(){

		int count =0,single =0;

		for(int i=0;i<allWords.size();i++){
			String word = allWords.get(i);
			for(int j=0;j<dict.size();j++){
				String second = dict.get(j);
				int dist = dynamic(word,second);
				//System.out.println("dist for "+second+" is "+dist);
				if(dist==1){
					count++;
					//System.out.println(second+" count is "+count);
				}else if(dist==0){
					//System.out.println("dist =0 ");
					//System.out.println(second);
					single++;
					//System.out.println(second+" * count is "+single);
				}

			}
			if(count==0)
				//System.out.println("count for "+word+" is "+single);
				System.out.println(single);
			else 
				//System.out.println("count for "+word+" is "+count);
				System.out.println(count);
			count=0;
			single=0;
		}

	}


	private static void show(){

		System.out.println("---- words are ----- ");

		for(int i=0;i<allWords.size();i++){
			System.out.println(allWords.get(i));
		}

		System.out.println("---- dictionary are----- ");

		for(int i=0;i<dict.size();i++){
			System.out.println(dict.get(i));
		}

	}

	private static void read(String file){

		try{


			Scanner sc = new Scanner(new File(file));
			String word=null;;
			while(sc.hasNextLine()){

				 word = sc.nextLine();
				if(!word.equals("END OF INPUT")){
					allWords.add(word);
				}else{
					break;
				}
			}

			//dict.add(word);

			while(sc.hasNextLine()){
				word = sc.nextLine();
				dict.add(word);
			}

		}catch(FileNotFoundException e){
			System.out.println(e.toString());
		}

	}

	private static int dynamic(String X, String Y){

		int M = X.length();
		int N = Y.length();

		int [][] dp = new int[M][N];

		for(int i=0;i<M;i++){
			dp[i][0]=i;
		}

		for(int i=0;i<N;i++){
			dp[0][i]=i;
		}

		for(int i=1;i<M;i++){
			for(int j=1;j<N;j++){

				int option1 = dp[i-1][j]+1;
				int option2 = dp[i][j-1]+1;
				int option3 = dp[i-1][j-1]+ ((X.charAt(i)== Y.charAt(j))?0:1);
				dp[i][j]= Math.min( Math.min(option1,option2),option3);
			}
		}
		return dp[M-1][N-1];

	}

}