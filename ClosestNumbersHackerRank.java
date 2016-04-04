import java.util.Arrays;

 public class ClosestNumbersHackerRank {


    public static void main(String[] args) {
        
        String s = "-20 -391 -457 737 -733 30 624 -646 266";
        System.out.println(closestNumbers(s.split("\\s").length, s));
    }

    static String closestNumbers(int len, String s) {
        String result = "";        
        if(s==null || s.length()==0){
            return result;
        }
        String [] sArray = s.split("\\s");
        System.out.println("sArray length "+sArray.length+" len "+len);
        int [] array = new int[len];
        for(int i=0;i<sArray.length;i++){
            array[i]=Integer.parseInt(sArray[i]);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int [] diff = new int[len-1];
        for(int i=1;i<len;i++){
            diff[i-1]=Math.abs(array[i]-array[i-1]);
        }
        System.out.println(Arrays.toString(diff));
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<len-1;i++){
            int currDiff = Math.abs(array[i+1]-array[i]);
            if(currDiff<minDiff){
                minDiff= currDiff;
                System.out.println(array[i]+" "+array[i+1]);
                result = array[i]+" "+array[i+1];
            }else if(currDiff==minDiff){
                result += " "+array[i]+" "+array[i+1];
            }
        }
        //System.out.println("min Diff "+minDiff);
        return result;
    }

 }    


