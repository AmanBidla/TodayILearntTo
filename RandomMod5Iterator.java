import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;


class Mod5Iterator implements Iterator<Integer> {

	private Iterator<Integer> randIt;
	private int val;

	public Mod5Iterator(Iterator<Integer> randIt) {
		this.randIt = randIt;
	}

	public boolean hasNext() {

		while(randIt.hasNext()){
			val = randIt.next();
			if(val%5==0) {
				return true;
			}
		}

		return false;
	}

	public Integer next(){

		if(!hasNext()) {
			throw new NoSuchElementException("No element in iterator");
		}
		return val;
	}

	public void remove(){
		 
	}
 	
}

class RandomIterator implements Iterator<Integer> {

	public boolean hasNext() {
		return true;		
	}

	public Integer next(){
		return new Random().nextInt();
	}

	public void remove(){
		 
	}



}

public class RandomMod5Iterator {

	public static void main(String[] args) {
		
		Mod5Iterator mod5Iterator = new  Mod5Iterator(new RandomIterator());
		
		System.out.println(mod5Iterator.next());
		System.out.println(mod5Iterator.next());
		System.out.println(mod5Iterator.next());
		System.out.println(mod5Iterator.next());
	}


}