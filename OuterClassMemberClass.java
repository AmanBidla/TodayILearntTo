public class OuterClassMemberClass{

	int outerVariable=100;
	static int staticOuterVariable=1000;

	class Member{

		int innerVariable=10;

		private int getParamter(int parameter){

			return innerVariable+parameter+outerVariable+staticOuterVariable;
		}
	}

	public static void main(String[] args) {
		
		OuterClassMemberClass outer = new OuterClassMemberClass();
		OuterClassMemberClass.Member inner = outer.new Member();
		System.out.println( inner.getParamter(20));
		outer.run();
	}

	private void run(){
		Member inner = new Member();
		System.out.println(inner.getParamter(40));
	}

}