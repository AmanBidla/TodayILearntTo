/*
key pad question - you how your phone has letters on the number keys. 
for example, number 2 has ABC on it, number 3 has DEF, 4 number has GHI,... ,
and number 9 has WXYZ.  Write a program that will print out all of the possible 
combination of those letters depending on the users input.  For example, say a user 
presses 234, the output should be

ADG, ADH, ADI, AEG, AEH, AEI, AFG, AFH, AFI
BDG, BDH, BDI, BEG, BEH, BEI, BFG, BFH, BFI
CDG, CDH, CDI, CEG, CEH, CEI, CFG, CFH, CFI

*/

import java.util.*;
public class Telephone {

	/* 6782345679 */
	public static HashMap<Integer,String> inputKeys = new HashMap<Integer,String>();
	public static void main(String abc[]){
		inputKeys.put(1,"");
		inputKeys.put(2,"ABC");		
		inputKeys.put(3,"DEF");		
		inputKeys.put(4,"GHI");		
		inputKeys.put(5,"JKL");		
		inputKeys.put(6,"MNO");		
		inputKeys.put(7,"PQR");		
		inputKeys.put(8,"STU");		
		inputKeys.put(9,"VWXZ");
		inputKeys.put(0,"");						
	
 		Scanner scan = new Scanner(System.in);
		System.out.println("enter number");
		int inp;
		try{
			inp= scan.nextInt();
			getall("",inp);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	

	}
	
	public static void getall(String s, int i){
		
		String input =i+"";
		if(input.length()==1){
			String temp = inputKeys.get(Integer.parseInt(""+input.charAt(0)));
			if(temp.length()==0) 
			{
				System.out.println(s);
			}else{
				for(int k=0;k<temp.length();k++) System.out.println(s+temp.charAt(k));
			}
		}else{
			String temp = inputKeys.get(Integer.parseInt(""+input.charAt(0)));
			if(temp.length()==0){
				 getall(s,Integer.parseInt(input.substring(1)));
			}	
			else{
				for(int j=0;j<temp.length();j++){
					getall(s+temp.charAt(j),Integer.parseInt(input.substring(1)));
				}
			}		
		}
		
	}


}