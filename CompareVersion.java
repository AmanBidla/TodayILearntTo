public class CompareVersion{


	public static void main(String[] args) {
		
		String v1="0.1";
		String v2="1.1";
		//System.out.println(compare(v1,v2));

		v1="1.2.2";
		v2="1.2.3";
		System.out.println(compare(v1,v2));


		v1="12.2";
		v2="13.2";
		//System.out.println(compare(v1,v2));



		v1="12.2";
		v2="12.2";
		System.out.println(compare(v1,v2));
	}

	public static int compare(String v1, String v2){

		String []arr1 = v1.split("\\.");
		String []arr2 = v2.split("\\.");

		int N1 =arr1.length;
		int N2 =arr2.length;

		int i=0;
		int va, vb;

		while(i<N1 || i<N2){

			if(i<N1 && i<N2){
				System.out.println("arr1["+i+"] "+arr1[i]+" and "+"arr2["+i+"] "+arr2[i]);
				va =Integer.parseInt(arr1[i]);
				vb =Integer.parseInt(arr2[i]);
				compare(va,vb);
				if(va>vb) return 1;
				else if(va<vb) return -1;
			}

			else if(i<N1){				
				va = Integer.parseInt(arr1[i]);
				compare(va,-1);
				if(va!=0) return 1;
			}

			else if(i<N2){

				vb = Integer.parseInt(arr2[i]);
				compare(-1,vb);
				if(vb!=0) return -1;
			}

			i++;
		}

		return 0;

	}

	private static void compare(int v1, int v2){

		if(v1==-1) System.out.println(v2);
		else if(v2==-1) System.out.println(v1);
		else System.out.println(v1+" and "+v2);
	}
}