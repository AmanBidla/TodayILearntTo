package Google.TodayILearntTo;

public class Hcount {

	
	public void change(String input){
		int N=input.length();
		for(int i=N-1;i>0;){
			if(input.charAt(i)=='h'){
				int curentIndex= i-1;
				
				while(curentIndex>=0){
					if(input.charAt(curentIndex)=='t'){
						input = swap(input,i,curentIndex);
						i=curentIndex;
						break;
					}else{
						curentIndex--;
					}
				}
			}else{
				i--;
			}
		}
		System.out.println(input);
		 
		
	}
	public void newchange(String input){
		int N=input.length();
		for(int i=N-1;i>0;){
			if(input.charAt(i)=='h'){
			int currentIndex= i-1;
				if(input.charAt(currentIndex)=='t'){
					input=swap(input, i,currentIndex);
					int next= i+1;
					int temp=i;
					while(next<N&&input.charAt(next)=='h'){
						input=swap(input,next,temp);
						next++;
						temp++;
					}
					i=currentIndex;
					
				}else{
					i--;
				}
			}else{
				i--;
			}
		}
		System.out.println(input);
		 
		
	}
	
	private String swap(String input, int a, int curentIndex) {
		char[]array =  input.toCharArray();
		array[a]='t';
		array[curentIndex]='h';
		String s=new String(array);
		System.out.println(s);
		return s;
		
	}

	public void showh(int[] array){
		for(int i:array){
			if(i!=0){
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		Hcount h = new Hcount();
		//h.newchange("ttth");
		
		//h.newchange("theater");
		//h.newchange("the author of the book");
		h.newchange("ththth");
	}
}
