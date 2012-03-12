import java.util.*;
public class ReadMinStackInConstantTime {
private Stack <Integer> s = new Stack<Integer> ();
private Stack <Integer> readMin = new Stack<Integer> ();

public static void main (String abc[]){
 ReadMinStackInConstantTime rsc = new ReadMinStackInConstantTime ();
 rsc.push(new Integer(2));
 rsc.push(new Integer(6));
 rsc.push(new Integer(4)); 
 rsc.push(new Integer(1));
 rsc.push(new Integer(5));
 System.out.println(" Min value : "+rsc.readMin());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Min value : "+rsc.readMin());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Min value : "+rsc.readMin());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Pop value : "+rsc.pop());
 System.out.println(" Min value : "+rsc.readMin());
}


public void push(Integer element){
	
	if(readMin.size()==0) 
	{
			readMin.push(element);
			s.push(element);
	}else{
		
		if(readMin.peek()>element){
			readMin.push(element);
		}
		s.push(element);
	}
 
}


public Integer pop(){
	
  if(s.size()>0)
	{	
		if(readMin.peek()==s.peek()) readMin.pop();
		return s.pop();
	}
	else{
		System.out.println(" No more elements in stack ");
		return 0;
	}	 
}
 
	

	
public Integer readMin(){
	if(readMin.size()>0)
		return readMin.peek();
	else{
		System.out.println(" No more elements in stack ");
		return 0;
	}
}





}