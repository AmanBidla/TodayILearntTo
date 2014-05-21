 import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class TearBookAndCombine {

    public static void main(String[] args) {
        
        readFile(args[0]);
     }

    private static void readFile(String file){


        try{

            Scanner sc = new Scanner(new File(file));
            while(sc.hasNextLine()){

                String st = sc.nextLine();
                System.out.println(findCommon(st.split(";")));
            }

        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }

    private static String findCommon(String[] fragments){

          
        List<String> list = new ArrayList<String>(Arrays.asList(fragments));

         sort(list);

        String text = list.get(0);
        list.remove(0);

         for (int i = list.size() - 1; i >= 0; i--) {
            int maxValue = 0,start = 0,match = 0,textLength = 0;
            for (int j = list.size() - 1; j >= 0; j--) {
                String findMe = list.get(j);
                textLength = text.length();
                int findLength = findMe.length();
                for (int bclength = 1 - findMe.length(); bclength < text.length(); bclength++) {
                    if (bclength < 0) { 
                        int lengthClosestMatch = findLength + bclength;
                        if (text.regionMatches(0, findMe, -bclength, lengthClosestMatch)) {
                            if (lengthClosestMatch > maxValue) {
                                start = bclength;
                                maxValue = lengthClosestMatch;
                                match = j;
                            }
                        }
                    } else { 
                        int lengthClosestMatch=0;                        
                        
                        lengthClosestMatch = closestMatch(textLength,findLength, bclength);
                        
                        if (text.regionMatches(bclength, findMe, 0, lengthClosestMatch)) {
                            if (lengthClosestMatch > maxValue) {
                                start = bclength;
                                maxValue = lengthClosestMatch;
                                match = j;
                            }
                        }
                    }
                }
            }

            if (start < 0) { 
                text = list.get(match).substring(0, -start) + text;
            } else if (start > textLength - list.get(match).length()) { 
                text = text + list.get(match).substring(textLength - start);
            }
            list.remove(match);
        }
        return text;
    }

    private static void sort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
    }

    private static int closestMatch(int textLength, int findLength, int bclength) {
        int lengthClosestMatch;
        if((bclength + findLength) <=textLength){
            lengthClosestMatch=findLength;
        }else{
            lengthClosestMatch=textLength - bclength;
        }
        return lengthClosestMatch;
    }


}
