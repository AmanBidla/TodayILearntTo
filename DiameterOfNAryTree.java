import java.util.List;
import java.util.ArrayList;

class Node{
	int val;
	List<Node> children = new ArrayList<Node>();

	public Node(int val){
		this.val = val;
	}

	public void addChild(Node child){
		children.add(child);
	}

}

class HD{
	int diam,height;
	public HD(int height,int diam){
		this.diam = diam;
		this.height = height;
	}
}

public class DiameterOfNAryTree {

	public static int maxDiameter(Node root){

		if(root==null || root.children.size()==0){
			return 0;
		}
		HD hd = maxDiameterHelper(root);
		return hd.diam; 
	}

	public static HD maxDiameterHelper(Node root){
		if(root == null){
			return new HD(0,0);
		}

		if(root.children.size()==0){
			return new HD(root.val,0);
		}

		List<HD> hdChildren = new ArrayList<HD>();

		int maxDiameter =0;
		int maxHeight =0;
		int secondMaxHeight =0;

		for(Node child : root.children){

			HD childHD = maxDiameterHelper(child);

			if(childHD.height > maxHeight){
				secondMaxHeight = maxHeight;
				maxHeight = childHD.height;
			}

			if(childHD.height > secondMaxHeight){
				secondMaxHeight = childHD.height;
			}
		}

			int diameter = secondMaxHeight + maxHeight;
			if(diameter > maxDiameter){
				return new HD(maxHeight+root.val, diameter);
			}else{
				return new HD(maxHeight+root.val,maxDiameter);
			}

		
	}

	public static void main(String[] args) {
		
		Node root = new Node(0);

		int [] firstLevelChildren = {1,1,2,2,2,1};
		addChildren(firstLevelChildren,root);

		Node firstChild = root.children.get(0);
		int [] levelTwoFirstChildren  = {1,1,2};
		addChildren(levelTwoFirstChildren,firstChild);

		Node firstGrantChild = firstChild.children.get(0);
		int[] firstGrantChildChildren = {1,3};
		addChildren(firstGrantChildChildren,firstGrantChild);

		Node fourthChild = root.children.get(3);
		int [] fourthChildChildren = {1,1};
		addChildren(fourthChildChildren,fourthChild);

		Node firtChildOfFourthChild = fourthChild.children.get(0);
		int [] firtChildOfFourthChildChilren = {2};
		addChildren(firtChildOfFourthChildChilren,firtChildOfFourthChild);

		Node secondChildOfFourthChild = fourthChild.children.get(1);
		int [] seconChildOfFourthChildChilren = {1};
		addChildren(seconChildOfFourthChildChilren,secondChildOfFourthChild);		

		Node lastChildOfRoot = root.children.get(5);
		int [] lastChildOfRootChilren = {3};
		addChildren(lastChildOfRootChilren,lastChildOfRoot);				

		System.out.println("Max Diamter "+maxDiameter(root));

	}

	public static void addChildren(int [] array,Node root){
		for(int i=0;i<array.length;i++){
			Node node = new Node(array[i]);
			root.addChild(node);
		}
	}


}