public class SendMessagesAsChunksWithCharLimit {



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


	public static void main(String[] args) {
		
		String S = "Hi Sivasrinivas, your Uber is arriving now!";
		int limit = 25;
		limit = limit - 5; // to accomodate (X/Y) characters at the end of each message chunk
		displayTextMessage(S,limit);

		String S1 ="your Uber is arriving(2/3)";
		System.out.println(S1.length()+" "+S1);
	}
}