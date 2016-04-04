public class WildCard {


	private static void wildCards(char [] array, int index) {
        
        if(array ==null || array.length==0 || index>array.length){
            return;
        }
        
        if(index== array.length){
            System.out.println(new String(array));
            return;
        }
 
        char c = array[index];
        if(c=='?'){
            array[index]='0';
            wildCards(array, index+1);
            array[index]='1';
            wildCards(array, index+1);
            array[index]='?';
        }else{
            wildCards(array, index+1);
        }
    }

    public static void main(String[] args) {
    	
    	 String S = "1?0?";
        
    	wildCards(S.toCharArray(),0);
    }


}