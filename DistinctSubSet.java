import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class DistinctSubSet {

	public estatic ArrayList<ArrayList<Integer>> getallSubSet(ArrayList<Integer>set,int index){

		ArrayList<ArrayList<Integer>> allSubSets;
		if(set.size()==index){
			allSubSets= new ArrayList<ArrayList<Integer>>();
			allSubSets.add(new ArrayList<Integer>());
			return allSubSets;
		}else{
			allSubSets=getallSubSet(set,index+1);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			int item=set.get(index);
			for(ArrayList<Integer>subset:allSubSets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allSubSets.addAll(moresubsets);
			return allSubSets;
		}

	}

  public static void read(){
      try{

         
        Scanner sc = new Scanner(System.in);
        int numberOfTests = new Integer (sc.nextLine());
        //System.out.println("number of test case "+numberOfTests);
        for(int i=0;i<(numberOfTests);i++){
          //System.out.println("test case "+i);
          Integer [] numbers = new Integer[new Integer(sc.nextLine())];
          //System.out.println("length of first array "+numbers.length);
          String [] line=sc.nextLine().split(" ");
          for(int j=0;j<numbers.length;j++)
             numbers[j]=new Integer(line[j]); 
           
          ArrayList<ArrayList<Integer>> allsubsets= getallSubSet(new ArrayList<Integer>(Arrays.asList(numbers)),0);
            
           show(allsubsets);
          
          
           
        }


      }catch(Exception e){
        System.out.println(e.toString());
      }

    }

    public static void show(ArrayList<ArrayList<Integer>> allsubsets){
    Set<Integer> uniqueSum = new HashSet<Integer>();
      for(ArrayList<Integer>mysubset:allsubsets){
    Iterator it =mysubset.iterator();
    int s=0;
    while(it.hasNext()){
      s+=(Integer)it.next();
    }
    uniqueSum.add(s);
    s=0;
   // System.out.println();
  }
  System.out.println(uniqueSum.size());
  uniqueSum = null;
    }
public static void main(String ad[]){
  

	 read();
	
}

}