public class LeadSListForMerge{

	public static void main(String abd[]){
		SListForMerge st = new SListForMerge();
		SListForMerge nt = new SListForMerge();
		st.insertFront(12);
		st.insertFront(90);
		st.insertFront(78);
		st.insertFront(128);
		st.insertFront(782);
		nt.insertBack(90);
		nt.insertBack(20);
		nt.insertBack(45);
		nt.insertBack(670);
		nt.find(670).setNext(st.find(78));
		System.out.println(" intersection point is "+nt.intersection(nt,st).getItem());
	}
}