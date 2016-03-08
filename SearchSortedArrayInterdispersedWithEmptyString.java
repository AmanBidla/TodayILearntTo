public class SearchSortedArrayInterdispersedWithEmptyString{

	static final String EMPTY_STRING = "";
	private static int find(final String [] array, final String target){

		if ((array == null) || (array.length == 0) || (target == null)){
			return -1;
		}

		int  left =0, right = array.length; int N = array.length;
		int nextNonEmptyStringIndex;
		while(left < right) {

			int mid = left + (right-left)/2;
			if(array[mid].equals(EMPTY_STRING)){				
				 nextNonEmptyStringIndex = indexOfNextNonEmptyStringGreaterThanIndex(array, mid);
				if(array[nextNonEmptyStringIndex].equals(target)){
					return nextNonEmptyStringIndex;
				}
				if(nextNonEmptyStringIndex == N) {
					right = mid;
				} else if(array[nextNonEmptyStringIndex].compareTo(target) > 0) {

					nextNonEmptyStringIndex = indexOfNextNonEmptyStringLessThanIndex(array,mid);
					if(array[nextNonEmptyStringIndex].equals(target)){
						return nextNonEmptyStringIndex;
					}
					right = nextNonEmptyStringIndex;
				} else {					
					left = mid+1;			
				}
			} else if(array[mid].compareTo(target) == 0){
				return mid;
			}else if (array[mid].compareTo(target) > 0){
				right = mid;
			} else {
				left = mid+1;
			}
		}

		return -1;
	}

	private static int indexOfNextNonEmptyStringLessThanIndex(String[] array, int index){

		while(index>=0){
			if(!array[index].equals(EMPTY_STRING)){
				break;
			}
			index--;
		}
		return index;
	}

	private static int indexOfNextNonEmptyStringGreaterThanIndex(String [] array, int index){

		while(index < array.length){
			if(!array[index].equals(EMPTY_STRING)){
				break;
			}
			index++;
		}
		return index;
	}

	public static void main(String[] args) {
		
		String [] array ={"at","","","","ball","","","car","","","dad","","","elephant",""};
		String s ="elephant";
		System.out.println(find(array,s));
		s ="at";
		System.out.println(find(array,s));
		s ="ball";
		System.out.println(find(array,s));
		s ="dad";
		System.out.println(find(array,s));
		s ="car";
		System.out.println(find(array,s));
	}
}