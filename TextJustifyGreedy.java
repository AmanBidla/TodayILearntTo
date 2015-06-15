import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TextJustifyGreedy{


	private static List<String> greedy(List<String> words, int L ){

		List<String> result = new ArrayList<>();
		if(words==null || words.size()==0) return result;
		int start=0, end=-1,totalLength=0;

		for(int i=0;i<words.size();){

			String word = words.get(i);
			int N = word.length();
			if(N>L) return result;
			int newLine = totalLength + (end-start+1) + N;
			if(newLine<=L){			
				end=i;
				totalLength+=N;
				i++;
			}else{
				//String line = createLine(words,L,start,end,totalLength);
				String line = createLine(words,L,start,end,totalLength,false);
				//System.out.println("line "+line);
				result.add(line);
				start=i;
				end=i-1;
				totalLength=0;
			}

		}

		//String lastLine = createLastLine(words,L,start,end,totalLength);
		String lastLine = createLine(words,L,start,end,totalLength,true);
		result.add(lastLine);
		return result;
	}
 

	private static String createLine(List<String> words, int L, int start, int end, int totalLength, boolean isLast){

		StringBuilder buf = new StringBuilder();
		if(start<0 || end>=words.size() || start>end) return buf.toString();
		buf.append(words.get(start));
		int N = end-start+1;
		char freeSpace=' ';
		if(N==1 || isLast){
			for(int i=start+1;i<=end;i++){
				buf.append(" "+words.get(i));
			}
			int j = L-totalLength-(N-1);			 
			while(j>0){
				buf.append(freeSpace);
				j--;
			}
		}else{

			int K = (L-totalLength)/(N-1);
			int M = (L-totalLength)%(N-1);

			for(int i=start+1;i<=end;i++){
				int space = (i-start)<=M?(K+1):K;				
				//buf.insert(space," ");
				while(space>0){
					buf.append(freeSpace);
					space--;
				}
				buf.append(words.get(i));
			}
		}
		return buf.toString();

	}

	public static void main(String[] args) {

		String [] array = {"This", "is", "an", "example", "of", "text", "justification."};		
		//String [] array = {"This", "is", "an"};
		//String [] array = {"This", "is", "an","good", "example", "of", "text"};
		int L=16;
		List<String> lines = greedy(Arrays.asList(array),L);
		for(String line:lines){
			System.out.println(line);	
			//System.out.println("16-line length ="+(16-line.length()));
		}
		
	}
}