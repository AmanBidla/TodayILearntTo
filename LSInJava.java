import java.util.List;
import java.util.ArrayList;

public class LSInJava{

	private class Node{
		//ls a/b/c/*/e/*/f/*/*/g

		//ls a/b/c/*/*/o

		public List<Node> children= new ArrayList<Node>();
		public String value;
		public Node(String value){
			this.value = value;
		}

		public void addSubDirectory(Node child){
			children.add(child);
		}

	}

	public Node createDirectory(){

		Node root = new Node("current");
		root.addSubDirectory(new Node("a"));
		root.addSubDirectory(new Node("x"));

		Node firstSub = root.children.get(0);
		firstSub.addSubDirectory(new Node("b"));
		firstSub.addSubDirectory(new Node("y"));

		Node secondSub = firstSub.children.get(0);
		secondSub.addSubDirectory(new Node("c"));
		secondSub.addSubDirectory(new Node("z"));

		Node thirdSub = secondSub.children.get(0);
		thirdSub.addSubDirectory(new Node("m"));
		thirdSub.addSubDirectory(new Node("n"));
		thirdSub.addSubDirectory(new Node("o"));

		Node fourthSub = thirdSub.children.get(1);
		fourthSub.addSubDirectory(new Node("e"));
		fourthSub.addSubDirectory(new Node("p"));

		Node fifthSub = fourthSub.children.get(0);
		fifthSub.addSubDirectory(new Node("o"));
		fifthSub.addSubDirectory(new Node("q"));
		fifthSub.addSubDirectory(new Node("r"));

		Node sixthSub = fifthSub.children.get(0);
		sixthSub.addSubDirectory(new Node("f"));
		sixthSub.addSubDirectory(new Node("s"));

		Node sevenSub = sixthSub.children.get(0);
		sevenSub.addSubDirectory(new Node("t"));
		sevenSub.addSubDirectory(new Node("u"));

		Node eightSub = sevenSub.children.get(0);
		eightSub.addSubDirectory(new Node("v"));
		eightSub.addSubDirectory(new Node("w"));

		Node nineSub = eightSub.children.get(0);
		nineSub.addSubDirectory(new Node("g"));
		nineSub.addSubDirectory(new Node("k"));

		Node tenSub = nineSub.children.get(0);
		tenSub.addSubDirectory(new Node("fb"));

		return root;
	}

	public static void main(String[] args) {
		
		LSInJava lj = new LSInJava();
		Node root = lj.createDirectory();
		//lj.preOrder(root);
		//lj.showCommand(root,"ls a/b/c/*/e/*/f/*");
		lj.showCommand(root,"ls a/b/*");
	}

	public void preOrder(Node root){

		if(root ==null) return;
		System.out.println();
		visit(root);
		
		for(Node child : root.children){
			preOrder(child);
			System.out.println();
		}
	}

	public void visit(Node root){
		System.out.print(root.value);
	}

	public void showCommand(Node root, String command){

		String argument = command.substring(3);
		System.out.println("command is ls "+argument);
		show(root,argument);

	}

	 

	private void show(Node root, String cmd){

		int N = cmd.length();
		//System.out.println(cmd +" and root is  "+root.value);
		if(N==0){

			for(Node child:root.children){
				System.out.println(child.value);
			}
		}else{
			char c = cmd.charAt(0);
			//System.out.println(cmd +" and c is "+c);
			if((c!='*') && (c!='/')){
				//System.out.println("searching for children ");
				for(Node child:root.children){
					//System.out.println("child of "+root.value+" is "+child.value);
					//System.out.println("comparing "+child.value+" with "+String.valueOf(c)+" is "+(child.value.equals(String.valueOf(c))));
					if(child.value.equals(String.valueOf(c))){
						show(child,cmd.substring(1));
					}
				}

				return;
			}else if(c=='*'){  
				if(N==1){
					System.out.println(root.value);
					preOrderTraversal(root);
				}
				for(Node child:root.children){
					show(child,cmd.substring(1));
				}
				return;
			}else if(c=='/'){
				show(root,cmd.substring(1));
				return;
			}

		}
	}


	public void preOrderTraversal(Node root){

		for(Node child:root.children){
			System.out.println(child.value);
			preOrderTraversal(child);
		}


	}
	public void preOrder(Node root, String cmd){
		System.out.println("cmd is "+cmd);	
		 int N = cmd.length();
		 if(N!=0){
		 	char c = cmd.charAt(0);

		 	if(cmd==root.value){
		 		show(root,cmd.substring(1));
		 	}
		 }else{
		 	System.out.println(root.value);
		 	for(Node child:root.children){
		 		preOrder(child,cmd);
		 	}

		 }
	}

}