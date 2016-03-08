import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LettersOfTelephone{

	public static void main(String[] args) {
		
		List<String> result = letterCombinations("23");
		System.out.println(Arrays.toString(result.toArray()));
	}
	

	static Map<Integer,char[]> map = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
    	char [] c2 = {'a','b','c'};
    	char [] c3 = {'d','e','f'};
    	char [] c4 = {'g','h','i'};
		char [] c5 = {'j','k','l'};
    	char [] c6 = {'m','n','o'};
    	char [] c7 = {'p','q','r','s'};
    	char [] c8 = {'t','u','v'};
    	char [] c9 = {'w','x','y','z'};

        map.put(2, c2);
        map.put(3, c3);
        map.put(4, c4);
        map.put(5, c5);
        map.put(6, c6);
        map.put(7, c7);
        map.put(8, c8);
        map.put(9, c9);

        List<String> result = new ArrayList<String>();
        permute(digits,0,"",result);
        return result;
                  
    }

    public static void permute(String S,int index, String path, List<String> result){

    	if(index == S.length()){
    		result.add(path);
    	}else{
    		String toInt = String.valueOf(S.charAt(index));
    		if(toInt.length()==0){
    			return;
    		}
    		char [] array = map.get(Integer.parseInt(toInt));
    		for(int i=0;i<array.length;i++){
    			path += String.valueOf(array[i]);
    			permute(S,index+1,path,result);
    			path = path.substring(0,path.length()-1);
    		}
    	}
    }


}