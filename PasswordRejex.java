/* Verify if the given password is valid/invalid;
1. must be 5-12 characters long
2. must contain atleast one number and one lowercase character
3. a sequence must not be followed by the same sequence (like 123123qs is invalid, 123qs123 is valid)
*/

import java.util.regex.*;

public class PasswordRejex{


	public static void main(String abc[])

	{
	
		String password="123qs123";
 		char [] pass = password.toCharArray();
		char checkChar;
 		boolean check;
		int indexOfRepeat=0;

		String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{5,12})";
			Pattern p = Pattern.compile(PASSWORD_PATTERN);
		    Matcher m = p.matcher(password);
			//System.out.println(m.matches());
			check=m.matches();
		if(m.matches()){
			
		for(int i=0;i<pass.length;i++)
		{
		 checkChar= pass[i];
		 indexOfRepeat=password.indexOf(password.substring(i,i+1),i+1);
 		if(indexOfRepeat>=0)
			{
				
				String patternOne = password.substring(i,indexOfRepeat);
				//System.out.print(patternOne+" and ");
				String patternTwo = password.substring(indexOfRepeat);
				//System.out.print(patternTwo+"\n");
				if(patternOne.length()==patternTwo.length())
					{
					check=false;
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


