import java.util.*;

public class IsSusblist{


	public static void main(String[] args) {
		
		// create two array list objects       
   List<String> arrlistsrc = new ArrayList<String>();
   List<String> arrlisttarget = new ArrayList<String>();
      
   // populate two lists
   arrlistsrc.add("A");
   arrlistsrc.add("B");
   arrlistsrc.add("C");
   arrlistsrc.add("D");
   arrlistsrc.add("E"); 
      
   arrlisttarget.add("C");
   arrlisttarget.add("D");
   arrlisttarget.add("F");
           
   // check target list in source list
   int index = Collections.indexOfSubList(arrlistsrc, arrlisttarget);
      
   System.out.println("Target list starts at index: "+index); 
	}
}