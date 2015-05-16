import java.nio.file.Files;
import java.io.IOException;
import java.util.stream.Stream;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Arrays;

public class WordFrequencyFromFile{


	public static void main(String[] args) {
		
		String file = args[0];
		read(file);
	}

	static void read(String file){

		try (Stream<String> lines = Files.lines(Paths.get(file),Charset.defaultCharset())){

		Stream<String> words=	lines.flatMap(line -> Arrays.stream(line.split("\\s")));
		//System.out.println(words.mapToInt(e).sum());
		//words.forEach(System.out::println);
		//Stream<String> clean = words.filter(s -> s.length()>0);
		List<String> clean = words.filter(string -> !string.isEmpty())
									.map(String::toLowerCase)
									.collect(Collectors.toList());
		//List<String> onlyWords = new ArrayList<>();
		/*
		for(int i=0;i<clean.size();i++){
			String correctWord  =  clean.get(i);
			StringBuilder buf = new StringBuilder();
			char [] array = correctWord.toCharArray();

			for(char c:array){
				if(Character.isLetter(c)){
					buf.append(c);
				}
			}
			onlyWords.add(buf.toString());
		}*/

 


		//onlyWords.forEach(System.out::println);
		Map<String,Integer> map = clean.stream().collect(TreeMap::new, (m,c)->m.merge(c,1,Integer::sum),Map::putAll);
		map.forEach((letter,c) -> System.out.println(letter+"::"+c)); 
			

		}catch(IOException e){
			System.out.println(e);
		}
		/*
		try(final Stream<String> lines = Files.lines(Paths.get(file),Charset.defaultCharset() ) ){
				final Map<String,Integer> map = 
				lines.flatMap(line ->IntStream.range(0,line.length()).mapToObj(line::charAt))
				.filter(Character::isLetter)
				.map(Character::toLowerCase)
				.collect(TreeMap::new,(m,c)->m.merge(c,1,Integer::sum),Map::putAll);
				map.forEach((letter,c) -> System.out.println(letter+"::"+c));
		 
		}catch(IOException e){
			System.out.println(e);
		}
		*/
	}
}