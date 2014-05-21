public class RecusivelyRemoveAjacentCharacters{
	

	private static StringBuilder remove( StringBuilder st, int pos){
		
		if(st==null) return null;
		int N = st.length();
		if(pos==st.length()) {
 			return st;
		}
		int index = pos;
		while(index<N && st.charAt(index)== st.charAt(pos)){
			index++;
		}
		if((index-pos)> 1){
			st.delete(pos,index-pos);
 			return remove(st, Math.max(pos-1,0));
		}else{
			return  remove(st,pos+1);
		}
	}

	public static void main(String[] args) {
		
		StringBuilder st = new StringBuilder();
		st.append("AAB");

		StringBuilder result = remove(st,0);
		assert( result.toString().equals("B"));
	}

}