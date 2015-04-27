import java.util.List;
import java.util.ArrayList;
public class AllValidParenthesis{

    public static void main(String[] args) {
        
        int n =3;
        List<String> list = generateParenthesis(n);
        for(String s:list){
            System.out.println(s);
        }

    }
	public static List<String> generateParenthesis(int n) {
     List<String> list = new ArrayList<String>();
     char [] str = new char[2*n];
     add(list,n,n,str,0);
     return list;
    }
    
    public static void add(List<String> list,int left, int right, char[] str, int i){
        if(left<0 || right<left){
            return ;
        }
        if(left==0 && right==0){
            list.add(String.copyValueOf(str));
        }else{
            if(left>0){
                str[i]='(';
                add(list,left-1,right,str,i+1);
            }
            if(right>left){
                str[i]=')';
                add(list,left, right-1,str,i+1);
            }
        }
    }
}