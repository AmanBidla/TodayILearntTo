import java.util.ArrayList;
import java.util.Arrays;

public class SubSetSum{


	static void sumUpRecursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sumUpRecursive(remaining,target,partial_rec);
       }
    }
    static void sumUp(ArrayList<Integer> numbers, int target) {
        sumUpRecursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        Integer[] numbers = {3,9,8,4,5,7,10};
        int target = 15;
        sumUp(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
}