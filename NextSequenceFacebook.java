public class NextSequenceFacebook{


	private static void nextSequence(int N){

		int i=1;

		StringBuffer current = new StringBuffer();
		StringBuffer last = new StringBuffer();

		System.out.println("1");
		current.append(1);
		current.append(1);

		while(i<=N){

			int begin=1,start=0,count=1,j=1;
			while(j<current.length()){

				if(current.charAt(begin)==current.charAt(start)){					
					count++;					 
				}else{
					last.append(count);
					last.append(current.charAt(start));
					start=begin;
					count=1;
				}

				begin++;
				j++;
 			}

			last.append(count);
			last.append(current.charAt(start));
			System.out.println(last);
			current=last;
			last = new StringBuffer();
			i++;
 		}
	}

	public static void main(String[] args) {
		
		nextSequence(5);
	}
}