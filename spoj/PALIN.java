import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class PALIN{

	public static void main(String[] args) {
		
		try{

			read();

		}catch(IOException e){

		}

	}

	public static void read() throws IOException{

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt( buf.readLine());
		String [] result = new String[test];
		for(int t=0;t<test;t++){

			String line = buf.readLine();
			//int input = Integer.parseInt( line);
				if(line.equals("9")) {
				result[t]="11";
				continue;
			}
			char[] array = String.valueOf(line).toCharArray();
			char [] copy = String.valueOf(line).toCharArray();
			int i=0;
			int N=array.length;
			System.out.println("N is "+N);
			int j=N-1;
			System.out.println("debugging ...");
			
			while(i<=j){

				int m1= Character.getNumericValue(array[i]);
				int n1= Character.getNumericValue(array[j]);

				if(m1==n1 && i!=j){

					i++;j--;
					continue;
				}
					

				if(i==j){
					System.out.println("i "+ m1+" "+(isSame(copy,array))+" array "+new String(array)+" and "+line);					
					if(isSame(copy,array)){					
						m1=m1+1;
						m1=m1%10;					 
						array[i]=Character.forDigit(m1, 10);					
						System.out.println("i==j and array["+i+"] "+array[i]);	
					}

					

				}else{

					array[j]=Character.forDigit(m1, 10);
					System.out.println(" array["+i+"] "+array[i] +" and  array["+j+"] "+array[j]);


				}
				i++;
				j--;
			}

			System.out.println("after copying "+Arrays.toString(array));
			i--;
			j++;
			char [] newarray=null;
			System.out.println("i  after "+i+" j after "+j+ " "+(array[i]=='0'));
			 if(i==j && array[i]=='0'){
			 	i--;j++;
			 	int carry=0;
			 	while(i>=0 && j<=N-1){

			 		int a1 = Character.getNumericValue(array[i]);
			 		int b1 = Character.getNumericValue(array[j]);

			 		a1=a1+1+carry;
			 		b1=b1+1+carry;

			 		carry = a1/10;

			 		a1=a1%10;
			 		b1=b1%10;
			 		System.out.println("a1 "+a1+" b1 "+b1);
			 		array[i]=Character.forDigit(a1, 10);
			 		array[j]=Character.forDigit(b1, 10);

			 		i--;
			 		j++;

			 	}


			 	if(carry==1){

			 		newarray = new char[N+1];
			 		for(int k=0;k<(N+1);k++){

			 			if(k==0 || k==(N)){
			 				newarray[k]='1';
			 			}else{
			 				System.out.println("k-1 "+(k-1));
			 				newarray[k]=array[k-1];
			 			}
			 		}
			 	}else{
			 		newarray=array;
			 	}			 	

			 }else{
			 		newarray=array;
			 }

			 //int answer = Integer.parseInt(new String(newarray));

			 if(isGreater(line.toCharArray(),newarray) || isSame(line.toCharArray(),newarray)){			 	
			 	result[t]=new String(reformatAnwer(newarray));
			 }else{
			 	System.out.println(newarray);
			 	result[t]=new String(newarray);
			 }

		}

		for(int t=0;t<test;t++){
			System.out.println(result[t]);
		}
	}

	private static char[] reformatAnwer(char[] array){
		System.out.println("modyfying input "+new String(array));		 
		int i;
		int N=array.length;
		System.out.println("N is "+N);
		int j;

		if(N%2!=0){
			i=N/2;
			j=i;
		}else{
			j=N/2;
			i=j-1;
		}

		char [] newarray=null;
			 	
			 	System.out.println("i "+i+" j "+j);
			  
			 	int carry=0;
			 	while(i>=0 && j<=N-1){

			 		int a1 = Character.getNumericValue(array[i]);
			 		int b1 = Character.getNumericValue(array[j]);

			 		a1=a1+1;
			 		b1=b1+1;

			 		carry = a1/10;

			 		a1=a1%10;
			 		b1=b1%10;

			 		System.out.println("array["+i+"] "+array[i]+" and array["+j+"] "+array[j]);

			 		array[i]=Character.forDigit(a1, 10);
			 		array[j]=Character.forDigit(b1, 10);
			 		System.out.println("after changing");
			 		System.out.println("array["+i+"] "+array[i]+" and array["+j+"] "+array[j]);
			 		i--;
			 		j++;

			 		if(carry==0) break;

			 	}


			 	if(carry==1){

			 		newarray = new char[N+1];
			 		for(int k=0;k<(N+1);k++){

			 			if(k==0 || k==(N)){
			 				newarray[k]='1';
			 			}else{
			 				System.out.println("k-1 "+(k-1));
			 				newarray[k]=array[k-1];
			 			}
			 		}
			 	}else{
			 		newarray=array;
			 	}			 	

			 

			 //int answer = Integer.parseInt(new String(newarray));

			 System.out.println(newarray);
			 return newarray;




	}

	private static boolean isGreater(char [] a1, char[] a2){

		 int N1 = a1.length;
		 int N2 = a2.length;
		 System.out.println("finding greate");
		 if(N1>N2) return true;

		 if(N1==N2){

		 	for(int i=0;i<N1;i++){

		 		int v1 = Character.getNumericValue(a1[i]);
		 		int v2 = Character.getNumericValue(a2[i]);
		 		System.out.println("comapring "+v1+" with "+v2);
		 		if(v1==v2) continue;
		 		if(v1>v2) return true;
		 		else if(v1<v2) return false;

		 	}

		 }

		 return false;

	}

	private static boolean isSame(char [] a, char [] b){

		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]) return false;
		}
		return true;
	}

}