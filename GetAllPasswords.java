/*Find all the possible passwords, given the length of the password and 
that it is a well ordered number (159 is well-ordered as 1<5<9) */

import java.util.Scanner;
public class GetAllPasswords{



	public static void main(String abc[]){
		
		Scanner scan = new Scanner(System.in);
		int length;
		try{
			System.out.println("Enter Length");
			length=scan.nextInt();
			int []array = new int[length];
			for(int i=0;i<length;i++){
				array[i]=i;
			}
 
		 
			int temp=0,pointer=length-2;;
			System.out.println();
			int start=0,last=length-1,index=1;;
			int count=0;
			while(array[start]<=(10-length)){
 					if(array[last]==9){
						System.out.println("pointer is "+ pointer +" array[pointer] "+array[pointer]+" and 10-pointer-1 "+(10- pointer-1));
//			 			if(array[pointer]<(10-pointer-1)){

			 			if(array[pointer]<(10-(length-pointer))){
							temp=0;
							while(temp<length){
								System.out.print(array[temp]);
								temp++;
							}
							System.out.println("\n");
							System.out.println("incrementing pointer");
							array[pointer]++;
							temp=1;
							index=pointer;
							System.out.println("index is "+index);
							while(index<length-1){
								array[index+temp]=array[index]+1;
								index++;
							}
							temp=0;
							while(temp<length){
								System.out.print(array[temp]);
								temp++;
							}
							System.out.println("\n");
						} 
							 	
						
						else{
						 
						System.out.println("pointer is "+pointer);	
							if((pointer-1)>=0){
								pointer--;
								array[pointer]++;
								temp=1;
								index=pointer;
								while(index<length-1){
									array[index+temp]=array[index]+1;
									index++;
								}
							}else{
								
								System.out.println("breaking");
								break;
							}
							
						}
 						
							
 
					}else{
						temp=0;
						while(temp<length){
							System.out.print(array[temp]);
							temp++;
						}
						System.out.println("\n");
						System.out.println("last is "+last);

						array[last]++;
					}
			}
			System.out.println("total count is "+count);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}