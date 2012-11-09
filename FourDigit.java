

/*Generate all possible unique 4 digit numbers such that 
no two adjacent numbers are the same and any number starting 
with 4 should end with a 4 . eg 1234 , 1232 are both correct but 1223 is not .*/

public class FourDigit {


public static void main(String abc[]){
	int count=0;
	for(int i=1000;i<=9999;i++){
		int number = i;
		int firstdigit = number/1000;
		int seconddigit = (number-(firstdigit*1000))/100;
		int thirddigit = (number-(firstdigit*1000)-(seconddigit*100))/10;
		int fourthdigit = (number-(firstdigit*1000)-(seconddigit*100)-(thirddigit*10))%10;
			if((firstdigit==4)&&(fourthdigit==4)){
				if((firstdigit!=seconddigit) && (seconddigit!=thirddigit) && (thirddigit!=fourthdigit))
					System.out.println(i);
					count++;
					}
			else{
					if((firstdigit!=seconddigit) && (seconddigit!=thirddigit) && (thirddigit!=fourthdigit))
						System.out.println(i);
								count++;
			}


	}
				System.out.println("count is "+count);
}


}