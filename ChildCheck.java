public class ChildCheck extends CheckStatic{


	static void call(){
		System.out.println("calling child");
	}

	public static void main(String[] args) {
		
		call();

		//ChildCheck c  = new CheckStatic();
		CheckStatic c = new ChildCheck();
		c.call();
	}


	

}