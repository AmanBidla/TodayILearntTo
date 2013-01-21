import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
public class AllPermutationsOfString{

public static Set <String> myset = new TreeSet<String>();
public static void perm(String prefix, String s){
	int n=s.length();
	if(n==0) myset.add(prefix);
	else
		for(int i=0;i<n;i++)
			perm(prefix+s.charAt(i),  s.substring(0,i)+s.substring(i+1,n) );
}

public static void main(String an[]){
	perm("","tree");
	Iterator it = myset.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}

	
}

}