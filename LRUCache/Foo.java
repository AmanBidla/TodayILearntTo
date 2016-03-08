import java.util.*;

public class Foo {

    private static void flatten(List result, List toBeFlatten, List originalList) {
        if(toBeFlatten.isEmpty()) return;
        for(Object item : toBeFlatten) {
            if(item == originalList) {
                return;
            }
            else if (item instanceof List) {
                flatten(result, (List)item, originalList);
            } else {
                result.add(item);
            }
        }
    }

    public static List flatten(List list) {
        list.remove(list);
        List flattened = new ArrayList<>();
        flatten(flattened, list, list);
        return flattened;
    }

    public static void main(String[] args) {
        List list = new ArrayList<>(Arrays.asList(1, 2, 3, Arrays.asList(4, 5, Arrays.asList(6, 7, 8))));
        list.add(list);
        list.add(Arrays.asList(list));
        System.out.println(flatten(list));
    }
}