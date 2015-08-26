import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
class Pair<K,V> {

	K k;
	V v;

	public void makePair(K k, V v){		
		this.k = k;
		this.v = v;
	}



}

public class CheckPair{

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
		    	 ////System.out.println("level "+level+" i "+i+" list.get("+(level-1)+").get("+i+") "+ (list.get(level-1).get(i)));
		    	int first = list.get(level-1).get(i);		    	
		    	int second = i+skip<N ? list.get(level-1).get(i+skip):-1000;
		    	 
		    	////System.out.print(" list.get("+(level-1)+").get("+i+") "+list.get(level-1).get(i));
		    	//if(i+skip<N)
		    		////System.out.println(" list.get("+(level-1)+").get("+(i+skip)+") "+list.get(level-1).get(i+skip));
		    	//else //System.out.println(" second =  -1000");
		    	////System.out.println("first "+first+" second "+second);
		    	iPair.makePair(first,second);
		    	////System.out.println("first "+first+" second "+second+" i+skip "+(i+skip));
		    	Pair<Pair<Integer,Integer>,Integer> pair = new Pair<Pair<Integer,Integer>,Integer>();
		    	pair.makePair(iPair,i);
		    	pairList.add(i,pair);	
		    }
		    
		    ////System.out.println();
  	    
  	    //System.out.println("before sorting");

  	    for(int i=0;i<N;i++){
  	    	//System.out.println(pairList.get(i).k.k+" "+pairList.get(i).k.v+" "+pairList.get(i).v);
  	    }
  	    	 
	  	    Collections.sort(pairList.subList(0,N), new MyComparator());	  	    

	  	    //System.out.println("after sorting");

	  	    for(int i=0;i<N;i++){
	  	    	//System.out.println(pairList.get(i).k.k+" "+pairList.get(i).k.v+" "+pairList.get(i).v);
	  	    }


	  	    //Integer [] arrayToAdd = new Integer[N];
	  	    //for(int i=0;i<N;i++) arrayToAdd[i]=0;	  	    
	  	    ////System.out.println("array size "+arrayToAdd.length);
	  	    for(int i=0;i<N;i++){
	  	    	int index = pairList.get(i).v;
	  	    	int leveIndex = (i>0)?pairList.get(i-1).v:0;
	  	    	int val = (i>0 && isEqual(pairList.get(i).k,pairList.get(i-1).k))? list.get(level).get(leveIndex):i;
	  	    	if(i>0) list.get(level).set(index,val);
	  	    	//if(i>0) arrayToAdd[index]=val;
	  	    	//System.out.println(" index "+index+" val "+val);
	  	    	////System.out.println(Arrays.toString(arrayToAdd));
 	  	    	////System.out.println("list.get("+level+").add("+index+","+val+")");
	  	    	////System.out.println(Arrays.toString(list.get(level).toArray()));
	  	    }
	  	    //list.add(level,Arrays.asList(arrayToAdd));
	  	    lastRow=level-1;
	  	    //System.out.println(Arrays.toString(list.get(level).toArray()));
  	    }
	    
	}
/*
 -- check
0 -1000 10
1 5 7
2 7 1
2 7 4
4 9 0
5 -1000 9
6 0 8
7 6 6
7 9 3
9 1 5
9 2 2

0 -1000 10
1 5 7
2 7 1
2 7 4
4 9 0
5 -1000 9
6 0 8
7 6 6
7 9 3
9 1 5
9 2 2

 --------

 

*/

    public static boolean isEqual(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2){

    	//System.out.print("p1.k "+p1.k+" p1.v "+p1.v);
 		//System.out.print(" p2.k "+p2.k+" p2.v "+p2.v);
 		//System.out.println();
 		if((p1.k==p2.k) && (p1.v==p2.v)) return true;
 		else return false;
    	
    }

 static class MyComparator implements Comparator<Pair<Pair<Integer,Integer>,Integer>>{

 	@Override
 	public int compare(Pair<Pair<Integer,Integer>,Integer> p1,Pair<Pair<Integer,Integer>,Integer> p2){
 		 
 		int a = p1.k.k.compareTo(p2.k.k);
 		if(a==0) return p1.k.v.compareTo(p2.k.v);
 		//if(a!=0) return a;
		//else return p1.v.compareTo(p2.v);
		return a;
 	}
 }

 public static void main(String[] args) {
 	 //String S ="bobocel";
 	String S ="bobocel";
 	 suffix(S);
 	   show();
 	   ////System.out.println(longest(0,2,S.length()));

 }

 public static void show(){
 	  	System.out.println("last row "+lastRow);
 	 	/*for(int i=0;i<list.size();i++){
 	 		//System.out.print(list.get(i));
 	 	}*/
 	 	System.out.println(list.get(lastRow));
 	 	//System.out.println();
   
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

