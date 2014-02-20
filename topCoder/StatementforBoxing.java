import java.util.Arrays;
import java.util.Comparator;

public class StatementforBoxing{

	private static int [][] array;

	public static void main(String[] args) {
		StatementforBoxing s =new StatementforBoxing();
		int [] a ={100,200,300,1200,6000};
		int [] b={};
 		int [] c={900,902,1200,4000,5000,6001};
		int [] d={0,2000,6002};
		int [] e={1,2,3,4,5,6,7,8};



		 
		 
		 
 		System.out.println("p is "+s.maxCredit(a,b,c,d,e));
 
	}




 	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e){
 		 
 		 int [][] hits = new int[5] [];
 		 int [] pos = new int[5];
 		 int [] mr = new int [5];
 		 int res=0;

 		 for(int i=0;i<5;i++){
 		 	pos[i]=0;
 		 	mr[i]=-1;
 		 }

 		 hits[0]=a;
 		 hits[1]=b;
 		 hits[2]=c;
 		 hits[3]=d;
 		 hits[4]=e;


 		 for(int i=0;i<200000;i++){

 		 	for(int j=0;j<5;j++){
 		 		if(hits[j].length<=pos[j]) continue;
 		 		if(hits[j][pos[j]]<=i){
 		 			mr[j]=hits[j][pos[j]];
 		 			pos[j]++;
 		 		}
 		 	}
 		 	int count=0;
 		 	for(int j=0;j<5;j++){
 		 		if(mr[j]==-1) continue;
 		 		if((mr[j]-i)<=1000){
 		 			count++;
 		 		}
 		 	}

 		 	if(count>=3){
 		 		res++;
 		 		for(int j=0;j<5;j++)
 		 			mr[j]=-1;
 		 	}
 		 }

 		 return res;



 	}

 	 

}