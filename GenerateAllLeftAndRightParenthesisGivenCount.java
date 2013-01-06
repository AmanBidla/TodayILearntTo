import java.util.ArrayList;
import java.util.Iterator;

public class GenerateAllLeftAndRightParenthesisGivenCount{

	public static void main(String abd[]){
		int count=3;
		ArrayList<String> ls = generateParenthesis(count);
		Iterator it = ls.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static ArrayList<String> generateParenthesis(int count){
		ArrayList<String> list = new ArrayList<String>();
		char [] st = new char[count*2];
		generateParenthesis(list,count,count,0,st);
		return list;
	}

	public static void generateParenthesis(ArrayList<String> list,int left, int right,int count, char[]st){
		if((left<0) || (left>right)){
			return ;
		}
		if((left==0) && (right==0)){
			String s = String.valueOf(st);
			list.add(s);
			return ;
		}else{
				if(left>0){
					st[count]='(';
					generateParenthesis(list,left-1,right,count+1,st);
				}
				if(right>left){
					st[count]=')';
					generateParenthesis(list,left,right-1,count+1,st);
				}
			}

	}

}