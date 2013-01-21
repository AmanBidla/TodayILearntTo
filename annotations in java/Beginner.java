public class Beginner {
	
	@MyAnno(value="use this default value",holdItem=244,myComment="Sree")
	
	public static void main(String ab[]){
		@SuppressWarnings("unused")
		int dog=899;
	}

    @Deprecated 
	public  void bark(){
		String bark="bark bark";
	}

	public static class MyDog extends Beginner {
		@Override
		public  void bark(){
			String bark="bow bow";
		}
	}
}