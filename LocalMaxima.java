package com.sreeprasad.algorithms.localmaxima;

import java.util.ArrayList;
import java.util.List;
 
public class LocalMaxima {



    public static List<Integer> allPeaks(int[] array) {


        boolean asc=false;
        boolean desc = false;
        int N = array.length;
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<N-1;i++) {
            int first = array[i]-array[i+1];
            if(first>0) asc = true;
            if(first<0) desc = true;

            if(asc==true && desc==true) {
                System.out.println(array[i]);
                asc = false;
                desc = false;
                result.add(i);
            }


        }

        return result;


    }


}
