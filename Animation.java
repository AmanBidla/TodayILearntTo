import java.util.ArrayList;

public class Animation{

	private String BLANK="";

	public String[] animate(int speed, String init){

		
		int N = init.length();
		ArrayList<String> answer = new ArrayList<String>();
		answer.add(init);
		int count =0;
		while(particlePresent(init)){
			ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
			//System.out.println("moving init "+init);
			count++;
			for(int i=0;i<N;i++){

				char c = init.charAt(i);

				if(c=='R'){
					StringBuilder sb = new StringBuilder(BLANK);
					if(i+speed<N)
						sb.setCharAt(i+speed,'R');
					//if(count==4)
						//System.out.println("movign right "+sb);
					list.add(sb);
				}else if(c=='L'){
					StringBuilder sb = new StringBuilder(BLANK);
					if(i-speed>=0)
						sb.setCharAt(i-speed,'L');
					//if(count==4)
						//System.out.println("movign left "+sb);
					list.add(sb);
				}else if(c=='A'){

					StringBuilder sb = new StringBuilder(BLANK);
					if(i+speed<N)
						sb.setCharAt(i+speed,'R');
					if(i-speed>=0)
						sb.setCharAt(i-speed,'L');
					//if(count==4)
						//System.out.println("both left and right "+sb);
					list.add(sb);
				}
			}
			
			StringBuilder f = new StringBuilder(BLANK);
			for(StringBuilder sb:list){
				//if(count==4)
					//System.out.println("trnasforming "+sb);
				for(int i=0;i<sb.length();i++){
					if(sb.charAt(i)=='L'){
						if(f.charAt(i)=='R')
							f.setCharAt(i,'A');
						else
							f.setCharAt(i,'L');
					}else if(sb.charAt(i)=='R'){
						if(f.charAt(i)=='L')
							f.setCharAt(i,'A');
						else
							f.setCharAt(i,'R');
					}
				}
			}

			init = f.toString();
			//System.out.println(init);
			answer.add(init);
		}

		return converToString(answer);

	}

	private String [] converToString(ArrayList<String> list){
		String [] answer = new String[list.size()];
		int index =0;
		for(String s:list){
			StringBuilder convert = new StringBuilder(s);
			for(int i=0;i<s.length();i++){
				if(convert.charAt(i)!='.'){
					convert.setCharAt(i,'X');
				}
			}
			answer[index]=convert.toString();
			//System.out.println(answer[index]);
			index++;

		}
		return answer;
	}

	private boolean particlePresent(String init){
		//System.out.println("finding if particle is present at "+init);
		for(int i=0;i<init.length();i++)
			if(init.charAt(i)!='.') return true;
		return false;
	}
	public static void main(String[] args) {
		Animation a = new Animation();
		String test ="RR..LRL";
		int speed =3;
		
		test="LRLR.LRLR";
		speed =2;

		test="RLRLRLRLRL";
		speed=10;

		test="...";
		speed=1;

		test="LRRL.LR.LRR.R.LRRL.";
		speed=1;

		int N = test.length();
		StringBuilder b =new StringBuilder("");
		for(int i=0;i<N;i++)
			b.append(".");
		a.BLANK= b.toString();
		String [] answer = a.animate(speed,test);
		//String [] answer = a.animate(2,"LRLR.LRLR");
		
		for(String s :answer){
			System.out.println(s);
		}
	}

}