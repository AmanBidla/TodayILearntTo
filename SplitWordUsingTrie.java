

//o(n) time
public List<String> stringToWords(String sentence, Trie<String> dict){

	int N = sentence.length();
	List<String> words = new ArrayList<String>();
	int i=0;
	while(i<N){

		String prefix ="";
		Node node = dict.getPrefix(prefix+sentence.charAt(i));

		while(node!=null && !node.isWord()){

			prefix+=sentence.charAt(i++);
			node = dict.getPrefix(prefix+sentence.charAt(i));
		}

		if(node!=null && node.isWord()){
			words.add(node.getValue());
		}

		i++;
	}

	return words;

}