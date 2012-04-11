public class FindSeedNumber{


	public static void main(String arg[]){
		
		int num = Integer.parseInt(arg[0]);
		int y,count;
		for(int i=1;i<=num;i++){
			count=1;
			y=i;
			count=count*y;
			while(y>0){
				count=count*(y%10);
				y=y/10;
			}
			if(count==num)
				System.out.println("seed number is "+i);
			
		}
		
	}
}