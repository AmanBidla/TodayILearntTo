public class LeadSListRandom{

	public static void main(String abd[]){
		SListRandom st = new SListRandom();
		st.insertInFront(9);
		st.insertInFront(19);
		st.insertInFront(29);
		st.insertInFront(129);
		st.insertInFront(39);
		st.find(9).setRandom(st.find(129));
		st.find(19).setRandom(st.find(9));
		st.find(29).setRandom(st.find(39));
		st.find(129).setRandom(st.find(19));
		st.find(39).setRandom(st.find(129));
		st.printAll(st.clone());
		
	}
}