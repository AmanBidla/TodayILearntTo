public class GeneticEnggRockethon{

	private static int find(String s){

		char c = s.charAt(0);
		int count=1,ans=0;;

		char [] array = s.toCharArray();
		for(int i=1;i<array.length;i++){
 			if(c!=array[i]){
				if(count%2==0) ans++;
				count=1;
				c = array[i];
  			}else{
 				count++;
 			} 
		}
		return ans;
	}

	public static void main(String[] args) {
		String s ="AACCAACCAAAAC";
		int ans = find(s);
		System.out.println(s);
		System.out.println("ans is "+ans);
	}
}