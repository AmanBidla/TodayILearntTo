public class MaximumProductWordLength {


	public static int maxProductWordLength(String [] words) {

		int N = words.length;
		int[] array = new int[N];

		for(int i=0;i<N;i++){
			for(int j=0;j<words[i].length();j++){
				array[i] |= 1<<words[i].charAt(j)-'a';
			}
		}
		int result =0;

		for(int i=0;i<words.length;i++){
			for(int j=i+1;j<words.length;j++){
				if((array[i]&array[j]) == 0){
					result = Math.max(result, words[i].length() * words[j].length());
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		
		String [] a1 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProductWordLength(a1)); // 16

		String [] a2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		System.out.println(maxProductWordLength(a2)); // 4

		String [] a3 ={"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProductWordLength(a3)); // 0
	}
}