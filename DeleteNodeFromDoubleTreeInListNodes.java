import java.util.List;
import java.util.ArrayList;

class Node{

    boolean visited;
    int parent;
    boolean valid;
    int val;

    public Node(int parent, boolean valid, int val){
        this.parent = parent;
        this.valid = valid;
        this.val =val;
    }

    @Override
    public String toString(){
        return "[parent= "+parent+ ", val= "+val +", visited= "+visited+", valid= "+valid+"]";
    }
}

public class DeleteNodeFromDoubleTreeInListNodes {

    public static void deleteNode(List<Node> nodes, int index) {

        if(index==-1){
            return;
        }

        nodes.get(index).valid=false;
        nodes.get(index).visited=true;

        for(int i=0;i<nodes.size();i++) {
            if(nodes.get(i).visited) {
                continue;
            }
            dfs(nodes,i);
        }
    }


    private static boolean dfs(List<Node> nodes, int index) {

        Node toDelete = nodes.get(index);
        if(toDelete.parent==-1 || toDelete.visited){
            toDelete.visited = true;
            return toDelete.valid;
        }

        toDelete.visited=true;
        toDelete.valid = dfs(nodes, toDelete.parent);
        return toDelete.valid;
    }

    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();
        int [] array = {-1,-1,1,0,2,4,3,4,6,7};
        for(int i=0;i<array.length;i++){
            nodes.add(new Node(array[i],true,i));
        }
        int indexToDelete = 4;
        System.out.println("delete node at index "+indexToDelete);
        deleteNode(nodes,indexToDelete);

        for(int i=0;i<nodes.size();i++){
            System.out.println(nodes.get(i).toString());
        }
    }


}