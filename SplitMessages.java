import java.util.List;
import java.util.ArrayList;
	
public class SplitMessages {

	public static List<String> splitString(String str, int len){
		List<String> res = new ArrayList<>();
		if(str == null || str.length() == 0) return res;
		int start = 0, step = len - 6;
		int i = step;
		while(start < str.length()){
			int end = findSplitPoint(str, start, i);
			if(end == -1) return null;
			res.add(str.substring(start, end+1));
			start = end+1;
			i = start + step;
		}
		return res;
	}

	private static int findSplitPoint(String str, int start, int end){
		while(end > start){
			if(end >= str.length() || str.charAt(end) == ' ') return Math.min(str.length()-1, end);
			end--;
		}
		return -1;
	}

	private static void printMessages(List<String> messages){
		if(messages == null || messages.size() == 0) return;
		int size = messages.size(), count = 1;
		while(count <= size){
			System.out.println(messages.get(count-1) + "(" + count + "/" + size + ")");
			count++;
		}
	}

	public static void main(String[] args) {
		
		String S = "this is a string";
		int len = 15;
		List<String> result = splitString(S,len);
		//printMessages(result);
		displayTextMessage(S,len);

	}


	public static void displayTextMessage(final String sentence, final int lineLimit) {
	    final String[] words = sentence.split("\\s");
	    final StringBuilder builder = new StringBuilder();
	    final int pages = sentence.length() / lineLimit + 1;

	    int currentPage = 0;
	    int currentWordIndex = 0;
	    int totalCharCount = 0;

	    while(currentWordIndex < words.length) {
	        int potentialWordLength = words[currentWordIndex].length() + 1;
	        if(totalCharCount + potentialWordLength < lineLimit) {
	            builder.append(words[currentWordIndex]);
	            builder.append(" ");
	            totalCharCount = builder.length() - (lineLimit * currentPage - 1);
	            currentWordIndex++;
	        } else {
	            builder.replace(builder.length() - 1, builder.length(), String.format("(%d/%d)", (currentPage+1), pages));
	            builder.append("\n");
	            currentPage++;
	            totalCharCount = 0;
	        }
	    }
	    builder.replace(builder.length() - 1, builder.length(), String.format("(%d/%d)", (currentPage+1), pages));
	    System.out.println(builder);
	}

}