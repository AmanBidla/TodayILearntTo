public class Singleton{
	
	/* METHOD ONE  */
  /*private static Singleton _instance=null;
	private Singleton();
	public static synchronized Singleton getInstance(){
		if(_instance==null)
			_instance= new Singleton();
		return _instance;
	} */
	
	
	
	/* METHOD TWO */
	
	private Singleton();
	public static Singleton getInstance(){
		return SingletonClass.instance;
	}
	private static class SingletonClass{
		public static final Singleton instance = new Singleton();
	}
	
}