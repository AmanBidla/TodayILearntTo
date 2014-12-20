/**
*  Function that accept String as input and shows number of times a word appears in text sorted
* in descending order
* Assumption : input String has words separated by a single space  
* 			 : input String contains only English characters 
*			 : 'A' and 'a' are treated different 
*/

import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Set;

public class NumberOfWords{

	public static void main(String[] args) {
		
		String word ="A function and any dependent functions you may need that takes string as input and produces list of words and and the number of times the word appears in the text sorted in descending order";
		frequency(word);
	}


	public static void frequency(String words){

		String[] array = words.split(" ");
		SortedMap<String,Integer> map = new TreeMap<String,Integer>();
		for(String word:array){

			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}else{
				map.put(word,1);
			}
		}

		Set<String> keys = map.keySet();
		for(String key:keys){
			System.out.println(key+" \t "+map.get(key));
		}		

	}


	


}