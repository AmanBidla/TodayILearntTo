 
import java.util.*;

public class UberSolution{


	// Say there  is a nested list of integers, A = [1, [[[[[[2]]]]]], [[3],4], [5] ]
// flatten(A) => [1, 2, 3, 4, 5]

// B = [1, [B], [[2], 3]]]
// flatten(B) => [1, 2, 3]

 
 
    
    static Map<List<?>,List<?>> freq = new HashMap<>();
     
    
    public static void main(String [] abc){
        
        //List<Object> nestedList = convertToList(1, convertToList(convertToList(2)), convertToList(convertToList(3),4), convertToList(5));
        // B = [1, [B], [[2], 3]]]
        List<Object> nestedList = convertToList(1, convertToList(convertToList(2),3));
        nestedList.add(convertToList(nestedList));
        //System.out.println(nestedList.hashCode());
        // add it first time
        //freq.put( nestedList ,   nestedList );
        List<Integer> flatendList = flatten( nestedList);
        //System.out.println(Arrays.toString(flatendList.toArray()));
        System.out.println(Arrays.toString(flatten(nestedList, new HashSet<Integer>()).toArray()));
        
    }
    
    public static ArrayList<Object> convertToList(Object ...objs){
        
        return new ArrayList<Object> ( Arrays.asList(objs) );
    }
    
    /**
     * @Param nested is a nested list of integers
     * @Return flatted list
     */
    public static  List<Integer> flatten(List<?> nested ){
       List<Integer> result = new ArrayList<Integer>();
       flattenRecurser(result,nested);
       return result;     
    }
    
    
    public static void flattenRecurser(List<Integer> result, List<?> nested){
        
        for(Object item : nested){
            
            //if(item instanceof List<?>  && !freq.containsKey( (List<?>) item ) ){
        	if(item instanceof List<?>  && (nested == ((List<?>) item))  ){
           
                flattenRecurser(result, (List<?>) item );
            }else if(item instanceof Integer) {
                result.add( (Integer) item );
            }
        }
        
    }

    public static List<Integer> flatten(List flatten, HashSet<Integer> ignore) {
    List<Integer> result = new LinkedList<>();
    ignore.add(System.identityHashCode(flatten));
    for (Object o : flatten) {
        if (o instanceof List) {
            if (! ignore.contains(System.identityHashCode(o))) {
                result.addAll(flatten((List) o, ignore));
            }
        } else {
            result.add((Integer)o);
        }
    }
    return result;
}
    
    

}