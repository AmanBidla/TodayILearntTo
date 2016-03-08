import java.util.*;

public class AnotherUberSolution {

	private static void flatten(List result, Collection toBeFlatten) {
        if(toBeFlatten.isEmpty()) return;
        for(Object item : toBeFlatten) {
            if (item instanceof Collection) {
                flatten(result, (Collection)item);
            } else {
                result.add(item);
            }
        }
    }

    public static List flatten(List list) {
        list.remove(list);
        List flattened = new ArrayList<>();
        flatten(flattened, list);
        return flattened;
    }

    public static void main(String[] args) {
        List<?> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.add(list);
        System.out.println(list);
        System.out.println(flatten(list));
    }
}