public class OuterClassLocalInnerClass{

	int outerVariable=100;
	static int staticOuterVariable=1000;
 	
 	private Object run(){

 		int localVariable =10;
 		final int finalLocalVariable=200;
 		class LocalClass{

 			int localInner =20; 			

 			private int getParamter(int paramter){
 				return paramter+localInner+finalLocalVariable+outerVariable+staticOuterVariable;
 			}
 		}
 		LocalClass localClass = new LocalClass();
 		System.out.println(localClass.getParamter(40));
 		return localClass;
 	}

	public static void main(String[] args) {
		
		OuterClassLocalInnerClass outer = new OuterClassLocalInnerClass();
		Object local = outer.run();
	}
 

}