import java.util.ArrayList;

public class OpenGardenSolution {
 

    private static void subsetRecursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial){
        int N = numbers.size();
        int s =0;
        for(int x:partial) 
            s+=x;
        if(s>target) return;
        if(s==target){
             for(int i=0;i<partial.size();i++){
                System.out.println((i+1)+" \t"+partial.get(i));
            }
        }else{
            for(int i=0;i<N;i++){
                ArrayList<Integer> remaining = new ArrayList<Integer>();
                int n = numbers.get(i);
                for(int j=i+1;j<N;j++){
                    remaining.add(numbers.get(j));
                }
                ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
                partial_rec.add(n);
                subsetRecursive(remaining,target,partial_rec);
            }
        }
    }


    public static void main(String[] args) {
        int [] array = {18897109, 12828837, 9461105, 6371773, 5965343, 5946800, 5582170, 5564635, 5268860, 4552402, 4335391, 4296250, 4224851, 4192887, 3439809, 3279833, 3095313, 2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 2149127, 2142508, 2134411};
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int x:array){
            numbers.add(x);
        }
        subsetRecursive(numbers,100000000,new ArrayList<Integer>());
    }

}