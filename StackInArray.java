import java.util.NoSuchElementException;
 public class StackInArray {
 	
	int c1,c2;
	int []a;
	int n=0;

public StackInArray(int n){
	this.n=n;
	a=new int[n];
	c1=n/2;
	c2=n-1;
	
}
 	public void push (int n,int stacknumber){
	pushToArray(n,stacknumber,a);
	}

	public void pushToArray (int n,int stacknumber, int[]a){
		
		if(stacknumber%2==1){
			if(c1!=0){
 
				a[c1]=n;
				c1=c1-1;
				System.out.println("adding "+a[c1+1]+" to stack a. Value of c1 "+c1);
			}else{
				throw new NoSuchElementException();
			}
		}else{
			if(c2!=0){
				a[c2]=n;
				c2=c2-1;
				System.out.println("adding "+a[c2+1]+" to stack b. Value of c2 "+c2);
			}else{
				throw new NoSuchElementException();
			}
		}
	}
	
	
	public int pop(int stacknumber){
		return popfromarray(stacknumber,a);
	}
	
	public int popfromarray (int stacknumber,int []a){
		if(stacknumber%2==1){
			if(c1!=n/2){
				c1=c1+1;
				System.out.println("value of c1 is "+c1);
				System.out.println("poping out stack a. return  "+a[c1]);
				return a[c1];
			}else 	throw new NoSuchElementException();
		}else{
			if(c2!=n-1){
				c2=c2+1;
				System.out.println("value of c1 is "+c1);
				System.out.println("poping out stack b. return  "+a[c2]);
				return a[c2];
			}else 	throw new NoSuchElementException();
 
		}
	}
	
	public static void main(String abd[]){
		StackInArray sa = new StackInArray(10);
		sa.push(1,1);
 		sa.push(2,1);
		sa.push(3,2);
		sa.push(12,2);
		sa.push(6,2);
		sa.push(7,2);		
 		System.out.println(sa.pop(2));
		System.out.println(sa.pop(2));		
	}
	
}