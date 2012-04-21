/* Verify if the given password is valid/invalid;
1. must be 5-12 characters long
2. must contain atleast one number and one lowercase character
3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)
*/

import java.util.regex.*;

public class PasswordRejex{


	public static void main(String abc[])

	{
	
		String password="123l123q";
 	//	char [] pass = password.toCharArray();
		char checkChar;
 		boolean check;
		int indexOfRepeat=0;

		String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{5,12})";
			Pattern p = Pattern.compile(PASSWORD_PATTERN);
		    Matcher m = p.matcher(password);
//			System.out.println(m.matches());
			check=m.matches();
		if(m.matches()){
			
		for(int i=0;i<password.length();i++)
		{

		 indexOfRepeat=password.indexOf(password.substring(i,i+1),i+1);
 		if(indexOfRepeat>=0)
			{
				
				String patternOne = password.substring(i,indexOfRepeat);
				char[] p1 =patternOne.toCharArray();
//				System.out.print(patternOne+" and ");
				String patternTwo = password.substring(indexOfRepeat);
				char[] p2 =patternTwo.toCharArray();
//				System.out.print(patternTwo+"\n");
//				System.out.println("compare for length = "+patternOne.length());
 				for(int k=0;k<patternOne.length();k++){
						if(p1[k]==p2[k])
							{
//							System.out.println("comparing "+p1[k]+" and "+p2[k]);
							check=false;
								
							}
							
						else
							{
//							System.out.println("comparing "+p1[k]+" and "+p2[k]+" which obviousy does not match");
							check=true;
							break;								
							}

				}
				
				

		}
			if(!check) break;
			
		}
 	}
	
			if(check)
		 		System.out.println(" password "+password+" is valid");
			else
				System.out.println(" password "+password+" is invalid");
	
	}
	
}


