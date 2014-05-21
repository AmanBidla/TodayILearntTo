public class Learn{

	private static int find(String s){

		char c = s.charAt(0);
		int count=1,ans=0;;

		char [] array = s.toCharArray();
		for(int i=1;i<array.length;i++){
			System.out.println("count "+count+ " char is "+array[i]+" i "+i);
			if(c!=array[i]){
				if(count%2==0) ans++;
				count=1;
				c = array[i];
				System.out.println("updated");
 			}{
 				count++;
 				System.out.println(" inside count "+count+ " char is "+array[i]+" i "+i);
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