
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.ArrayList;

public class Recursion
{
    public static List<Integer> hasSum( int [ ] arr, int k )
    {
        return hasSum( arr, 0, arr.length - 1, k );
    }
    
    private static List<Integer> hasSum( int [ ] arr, int low, int high, int k )
    {
        if( k == 0 )
            return new ArrayList<Integer>( );
            
        if( low > high )
            return null;
        
        List<Integer> result;
        result = hasSum( arr, low + 1, high, k );
        if( result != null )
            return result;
        
        result = hasSum( arr, low + 1, high, k - arr[ low ] );    
        if( result != null )
        {
            result.add( arr[ low ] );
            return result;
        }
            
        return null;        
    }
    
    
    public static void main( String [ ] args )
    {
        int [ ] arr1 = { 2, 5, 6, 9, 13, 19, 25 };
        
        System.out.println( hasSum( arr1, 40 ) );
        System.out.println( hasSum( arr1, 38 ) );
        System.out.println( hasSum( arr1, 53 ) );
        System.out.println( hasSum( arr1, 10 ) );
        
    }
}