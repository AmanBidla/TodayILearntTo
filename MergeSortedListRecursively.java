public class MergeSortedListRecursively{


	public List<Node> merge(List<Node> l1,List<Node> l2){


		if(l1==null)
			return l1;
		if(l2==null)
			return l2;

		if(l1.data <=l2.data){
			l1.next=merge(l1.next,l2);
			return l1;
		}else{
			l2.next=merge(l2.next,l1);
			return l2;
		}
	}

}