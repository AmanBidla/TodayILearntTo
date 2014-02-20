public class Decompose{

	public void printall(int []values, int index){
		for(int i=0;i<index;i++){
			System.out.print(values[i]+" ");
		}
		System.out.println("");
	}
	public void deco(int[]values, int x, int index){


		if(x==0){
			printall(values,index);
			return;
		}

		for(int i=1;i<x;i++){
			values[index]=i;
			deco(values,x-i,index+1);
		}

		if(index>0){
			values[index]=x;
			deco(values,0,index+1);
		}

	}

	public void deco(int x){
		int [] values = new int[x];
		deco(values,x,0);
	}

	public static void main(String[] args) {
		Decompose d = new Decompose();
		d.deco(5);
	}

}