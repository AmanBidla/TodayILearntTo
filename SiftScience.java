import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
public class SiftScience{


	private static void read(String file){

		try{
			Scanner sc = new Scanner(new File(file));
			Map<Character, String> map = new LinkedHashMap<Character,String>();
			while(sc.hasNext()){
				String word = sc.next();
				map.contains(word.charAt(0)){
					map.put(word.charAt(0), word);
				}

			}
		}catch(FileNotFoundException e){
			System.out.println(e.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}