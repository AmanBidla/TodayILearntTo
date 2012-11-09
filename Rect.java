/*
Given a 2 dimensional point of a rectangle and its area, find permutations of 
all the other 3 points of the rectangle in 2-D space.

Ex:- Given X=(0,0) and A=1
(0,1),(1,0),(1,1)
(0,-1),(-1,0),(-1,-1)

*/
 public class Rect

{	

	public static void main(String abc[]){
		
	int area =4,x=0,y=0;
	for(int i=0;i<=area;i++){
		for(int j=area;j>=1;j--){
			if(i*j==area)
{			System.out.println("("+x+","+y+"),("+(x+i)+","+y+"),("+x+","+(y+j)+"),("+(x+i)+","+(y+j)+")");
			System.out.println("("+x+","+y+"),("+(x-i)+","+y+"),("+x+","+(y+j)+"),("+(x-i)+","+(y+j)+")");
			System.out.println("("+x+","+y+"),("+(x-i)+","+y+"),("+x+","+(y-j)+"),("+(x-i)+","+(y-j)+")");
			System.out.println("("+x+","+y+"),("+(x+i)+","+y+"),("+x+","+(y-j)+"),("+(x+i)+","+(y-j)+")");
}		}
	}
	
	}


}
