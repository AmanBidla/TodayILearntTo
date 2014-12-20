import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class KnuthMorrisPratt {


	public static void main(String[] args) {
			
			KnuthMorrisPratt kmp = new KnuthMorrisPratt();
			String word ="world abra";
			String sentence ="hello this is hello. Hello lives in helloworld abra abracad abracadabra ";
			final List<Integer> match = kmp.search(word,sentence);
			final int wordLength = word.length();
			kmp.showMatch(match,sentence,wordLength);
    
	}

 	public void showMatch(final List<Integer>match,String sentence,int wordLength){

 			for (int i=0;i<match.size();i++){
				System.out.println("found word at position "+match.get(i) +" = "+ sentence.substring(match.get(i),match.get(i)+wordLength));
	 		}
 	}


	public List<Integer> search(final String word,final String sentence){

		if(sentence==null || sentence.length()==0) return Collections.<Integer>emptyList();

		final List<Integer> match = new ArrayList<Integer>();
		final List<Integer> partial = partial(word);
		final int sentenceLength = sentence.length();
		final int wordLength = word.length();
		int begin=0,id=0;
		
		while(begin+id<sentenceLength){

			if(word.charAt(id)==sentence.charAt(id+begin)){
				if(id==wordLength-1){
					match.add(begin);
					begin = begin +id-partial.get(id);
					if(partial.get(id)>-1)
						id=partial.get(id);
					else
						id=0;
				}else{
					id++;
				}
			}else{
				begin = begin +id -partial.get(id);
				if(partial.get(id)>-1)
					id = partial.get(id);
				else
					id=0;
			}
		}

		return Collections.unmodifiableList(match);

	}




	public List<Integer> partial(final String word){

		if(word==null || word.length()==0) return Collections.<Integer>emptyList();

		List<Integer> partial = new ArrayList<Integer>(word.length()+1);
		final int wordLength = word.length();
		final char first = word.charAt(0);
		partial.add(-1);
		partial.add(0);
		for(int i=1;i<wordLength;i++){
			final int preval = partial.get(i);
			if(preval==0){

				if(word.charAt(i)==first){
					partial.add(1);
				}else{
					partial.add(0);
				}

			}else if(word.charAt(i)==word.charAt(preval)){
					partial.add(preval+1);
			}else{
				partial.add(0);	
			}

		}

		return Collections.unmodifiableList(partial);

	}



}