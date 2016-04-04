import java.io.*;
import java.util.Arrays;

public class NutsAndBoltsHackerRank {


	 public static void main(String args[] ) throws Exception {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	    String nuts[] = buf.readLine().split(",");
	    String bolts[] = buf.readLine().split(",");
	    
	    if(nuts==null || bolts ==null){
	        return;
	    }
	    
	    if(nuts.length>0 && bolts.length>0){
	        for(int i=0;i<bolts.length;i++){
	            String nut = kThSmallest(i,nuts);
	            String bolt = kThSmallest(i,bolts);
	            System.out.println(nut+bolt);
	        }    
	    }
	    
	   
	}
    
    private static String kThSmallest(int k, String[]nuts){
    	
        int lo=0;
        int hi=nuts.length-1;
        System.out.println(Arrays.toString(nuts)+" and k "+k+" lo "+lo+"  hi "+hi);
        while(lo<hi){
            int i= partition(nuts,lo,hi);
            System.out.println("i "+i);
            if(i<k) lo=i+1;
            else if(i>k) hi=i-1;
            else return nuts[i];
        }
        System.out.println("returning lo");
        return nuts[lo];
    }
    
    private static int partition(String[]nuts,int lo, int hi){
        int i=0;
        int j=hi+1;
        int v=Integer.parseInt(nuts[lo].charAt(1)+"");
        System.out.println("i "+i+" j "+j+" v "+ v);
        while(true){
            
            while(less(nuts[++i],v))
                if(i==hi) 
                    break;
            
            while(less(v,nuts[--j]))
                if(j==lo)
                    break;
                
            if(i>=j) break;
                
             swap(nuts,i,j);             
        }
        swap(nuts,j,lo);
        return j;
    }
    
    private static boolean less(String nut,int b){
        int a=Integer.parseInt(nut.charAt(1)+"");
        System.out.println("comparing "+a+" with "+b);
        return a<b;        
    }
    
    private static boolean less(int a, String nut){
        int b=Integer.parseInt(nut.charAt(1)+"");
        System.out.println("comparing "+a+" with "+b);
        return a<b;
    }
    
    private static void swap(String[]nuts,int i, int j){
        String temp = nuts[i];
        nuts[i] = nuts[j];
        nuts[j]= temp;
    }


}