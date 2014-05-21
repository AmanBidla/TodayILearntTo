import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Main{


	private static List<String> allWords = new ArrayList<String>();
	private static HashSet []newdict = new HashSet[30];
	private static Stack<String>stack=new Stack<String>();
	private static HashSet<String>levenshteinDistance=new HashSet<String>();
	


	public static void main(String[] args) {
	
		for(int i=0;i<30;i++) newdict[i]=new HashSet<String>();


		read(args[0]);
		//show();
		find();

	}

	private static void find(){

		// /System.out.println(allWords.size()+" word is "+allWords.get(0));
		for(int i=0;i<allWords.size();i++){
			String word = allWords.get(i);
			stack.add(word);
			
			while(!stack.isEmpty()){

				String choosenOne = stack.pop();
				//System.out.println("searching for "+choosenOne);
				levenshteinDistance.add(choosenOne);
				find(choosenOne);
			}
			

				System.out.println(levenshteinDistance.size()-1);
				/*if(levenshteinDistance.size()==1){
					System.out.println(1);	
				}else{
					System.out.println(levenshteinDistance.size()-1);
				}*/
				

			levenshteinDistance =new HashSet<String>();

		}
	}



	public static void find(String word){
		int len=word.length();
		char z;
		StringBuffer sb;
		String b="";
		for(int i=0;i<len;i++){
			sb=new StringBuffer(word);
			sb=sb.deleteCharAt(i);b=sb.toString();
			//System.out.println("checking if "+b+" is present in delete");
			if(newdict[len-1].contains(b)){
				//System.out.println("adding word  by deleting "+b);
				stack.add(b);
				newdict[len-1].remove(b);			 
			}
		}

		for(int i=0;i<=len;i++){
			for(char j='a';j<='z';j++){
				sb=new StringBuffer(word);
				sb=sb.insert(i,j);
				b=sb.toString();
				if(newdict[len+1].contains(b)){
					//System.out.println("adding word by inserting "+b);
					stack.add(b);
					newdict[len+1].remove(b);
				}
			}
		}
		for(int i=0;i<len;i++){
			for(char j='a';j<='z';j++){
				sb=new StringBuffer(word);
				sb.setCharAt(i,j);
				b=sb.toString();
				if(newdict[len].contains(b)){
					//System.out.println("adding word by replacing "+b);
					stack.add(b);
					newdict[len].remove(b);
				}
			}
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
				//System.out.println(word);
				newdict[word.length()].add(word);
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