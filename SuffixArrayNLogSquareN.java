import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

class Pair<K,V> {

	K first;
	V second;

	public void makePair(K first, V second){
		this.first = first;
		this.second = second;
	}

}

public class SuffixArrayNLogSquareN{

	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static List<Pair<Pair<Integer,Integer>,Integer>> pairList = new ArrayList<>();
	static int lastRow=0;

	public static void suffix(String S){
		int N = S.length();
		List<Integer> indexes = new ArrayList<>();
	    for(int i=0;i<N;i++) indexes.add((int)S.charAt(i));
	    list.add(indexes);
	    for (int skip=1,level=1;skip<N;skip*=2,level++){

		    indexes = new ArrayList<Integer>(N);
		    for(int i=0;i<N;i++) indexes.add(0);
		    list.add(level,indexes);
			 
		    for(int i=0;i<N;i++){
		    	Pair<Integer,Integer> iPair = new Pair<Integer,Integer>();
		    	int first = list.get(level-1).get(i);
		    	int second = i+skip<N ? list.get(level-1).get(i+skip):-1000;
		    	iPair.makePair(first,second);
		    	Pair<Pair<Integer,Integer>,Integer> pair = new Pair<Pair<Integer,Integer>,Integer>();
		    	pair.makePair(iPair,i);
		    	pairList.add(i,pair);
		    }		      	    	 
	  	Collections.sort(pairList.subList(0,N), new MyComparator());
  	    for(int i=0;i<N;i++){
	  	    	int index = pairList.get(i).second;
	  	    	int leveIndex = (i>0)?pairList.get(i-1).second:0;
	  	    	int val = (i>0 && isEqual(pairList.get(i).first,pairList.get(i-1).first))? list.get(level).get(leveIndex):i;
	  	    	if(i>0) list.get(level).set(index,val);
	   	    }
	   	    lastRow=level-1;
	    }
	    
	}

    public static boolean isEqual(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2){

 		if((p1.first==p2.first) && (p1.second==p2.second)) return true;
 		else return false;
    	
    }

	 static class MyComparator implements Comparator<Pair<Pair<Integer,Integer>,Integer>>{
	 	@Override
	 	public int compare(Pair<Pair<Integer,Integer>,Integer> p1,Pair<Pair<Integer,Integer>,Integer> p2){
	 		int a = p1.first.first.compareTo(p2.first.first);
	 		if(a==0) return p1.first.second.compareTo(p2.first.second);
			return a;
	 	}
	 }

	 public static void main(String[] args) {
	 	 //String S ="bobocel";
	 	//String S ="mississippi";
	 	String S ="alabala";
	 	suffix(S+""+S);
	 	show();
	 }

	 public static void show(){
	 	 System.out.println(list.get(lastRow));
	 }

	 public static int longest(int i, int j,int N){
	 	int len=0;
	 	if(i==j) return N-i;
	 	for(int k=lastRow;k>=0 && i<N && j<N;k--){
	 		if(list.get(k).get(i) == list.get(k).get(j)){
	 			i += 1<<k;
	 			j += 1<<k;
	 			len += 1<<k;
	 		}
	 	}
	 	return len;
	 }
 

}

