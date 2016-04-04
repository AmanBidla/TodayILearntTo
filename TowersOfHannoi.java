public class TowersOfHannoi {


	 private static void towersOfHannoi(int N,String from, String other,String to){
        if(N==0){
            return;
        }else{
            towersOfHannoi(N-1,from,to,other);
            System.out.println("move top disk from "+from+" to "+to);
            towersOfHannoi(N-1,other,from,to);
        }
    }

    public static void main(String[] args) {
    	
    	int N = 3;
        String rod1="rod1", rod2="rod2", rod3="rod3";
        towersOfHannoi(N,rod1,rod2,rod3);
    }

}