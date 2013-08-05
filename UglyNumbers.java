 public class UglyNumbers{
 	

 	public static void main(String[] args) {
 		
 		int nextMultipleTwo =2;
 		int nextMultipleThree =3;
 		int nextMultipleFive =5;
 		int nextMultipleSeven =7;

 		int itwo=0,ithree=0,ifive=0,iseven=0;

 		int [] array = new int [20];

 		array[0]=1;

 		for(int i=1;i<20;i++){

 			int min = findMin(nextMultipleTwo,nextMultipleThree,nextMultipleFive,nextMultipleSeven);
 			array[i]=min;

 			if(min==nextMultipleTwo){
 				itwo ++;
 				System.out.println("i :"+i+" min:"+min+" nextMultipleTwo:"+nextMultipleTwo+" itwo:"+itwo);
 				nextMultipleTwo= array[itwo]*2;
 			}
 			else if (min ==nextMultipleThree){
 				ithree++;
 				System.out.println("i :"+i+" min:"+min+" nextMultipleThree:"+nextMultipleThree+" ithree:"+ithree);
 				nextMultipleThree=array[ithree]*3;
 			}
 			else if(min ==nextMultipleFive){
 				ifive++;
				System.out.println("i :"+i+" min:"+min+" nextMultipleThree:"+nextMultipleFive+" ifive:"+ifive);
 				nextMultipleFive=array[ifive]*5;
 			}
 			else if(min == nextMultipleSeven){
 				iseven++;
 				System.out.println("i :"+i+" min:"+min+" nextMultipleSeven:"+nextMultipleSeven+" iseven:"+iseven);
 				nextMultipleSeven= array[iseven]*7;
 			}

 		}

 		for(int i=0;i<20;i++){
 			System.out.print(array[i]+" ");
 		}
 	}

 	public static int findMin(int a, int b, int c, int d){
 		return minimum(a,minimum(b,minimum(c,d)));
 	}

 	public static int minimum(int a, int b){
 		if(a<b) return a;
 		else if(a>b) return b;
 		else return a;
 	}



 }