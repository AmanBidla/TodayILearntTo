public class SubsetsOfAnArray{


	public static void recursive(String sofar, String rest){

		if(rest.length()==0){
			System.out.println(sofar);
		}else{
			for(int i=0;i<rest.length();i++){
				String next=rest.charAt(i)+sofar;
				String remaining=rest.substring(0,i)+rest.substring(i+1);
				recursive(next,remaining);
			}
		}
	}


	public static void recursive(int[]sofar,int pointerOfsofar,int[]rest,int pointerOfRest){
		if(pointerOfRest==rest.length-1){
			printAll(sofar);
		}else{
			for(int i=0;i<rest.length;i++){
				   int []next=new int[sofar.length];
				   next[0]=rest[i];
					for(int j=1;j<next.length;j++){
						next[j]=sofar[j];
					}
					for(int j)


			}



		}



	}


}