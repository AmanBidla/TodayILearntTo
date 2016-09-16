import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class AllPhoneNumbers {


	public static List<List<String>> allPhone(String S) {

		Map<Integer, String> map = new HashMap<Integer,String>();

		map.put(2,"abc");
		map.put(3,"def");
		map.put(4,"ghi");
		map.put(5,"jkl");
		map.put(6,"mno");
		map.put(7,"pqrs");
		map.put(8,"tuv");
		map.put(9,"wxyz");
		map.put(0,"");

		List<String> item = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		int start=0;
		int len = S.length();

		dfs(S,item,result,map, len,start);

		return result;
	}

	private static void dfs(String S, List<String> item, List<List<String>> result, Map<Integer,String> map, int len, int start) {

		// base case
		if(item.size() > len){
			return;
		}	


		// final case
		if(item.size()==len) {
			result.add(new ArrayList<String>(item));
			return;
		}
  
		// iterate through all possible sol starting from start
		for(int i=start;i<len;i++) {

			int a = (int) S.charAt(i)-'0';

			if(map.containsKey(a)){
				String temp = map.get(a);
				for(int j=0;j<temp.length();j++){
					item.add(String.valueOf(temp.charAt(j)));
					dfs(S,item,result,map,len,i+1);
					item.remove(item.size()-1);
				}
			}

		}

	}

	public static void main(String[] args) {
		
		String S ="23";
		List<List<String>> result = allPhone(S);
		for(List<String> r : result){
			System.out.println(Arrays.toString(r.toArray()));
		}
	}

}