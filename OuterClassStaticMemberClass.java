public class OuterClassStaticMemberClass{

	int outerVariable=100;
	static int staticOuterVariable=1000;

	static class Member{

		int innerVariable=10;

		private int getParamter(int parameter){

			return innerVariable+parameter+staticOuterVariable;
		}
	}

	public static void main(String[] args) {
		
		OuterClassStaticMemberClass outer = new OuterClassStaticMemberClass();
		//Member inner = new Member();
		OuterClassStaticMemberClass.Member inner = new OuterClassStaticMemberClass.Member();
		System.out.println( inner.getParamter(20));
		outer.run();
	}

	private void run(){
		Member inner = new Member();
		System.out.println(inner.getParamter(40));
	}

}