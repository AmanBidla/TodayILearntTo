import java.util.Arrays;
import java.util.Random;

class Bolts extends Parts{
	
	private int size;
	private String name;

	public Bolts(int size,String name){
		super(size);
		this.name = name;
	}
 
	public String getName(){
		return name;
	}
}

class Nuts extends Parts{

	private int size;
	private String name;

	public Nuts(int size,String name){
		super(size);
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}	

class Parts implements Comparable<Parts>{
	int width;
	public Parts(int width){
		this.width=width;
	}

	@Override
	public int compareTo(Parts p){
		return width-p.width;
	}

	public int getSize(){
		return width;
	}
}
	
 
public class NutsAndBolts{

	public static void main(String[] args) {

		Comparable [] nuts = fillNuts();
		Comparable [] bolts = fillBolts();
		match(nuts,bolts,0,bolts.length-1);
	}

	private static void match(Comparable[] nuts,Comparable [] bolts,int lo, int hi){

		if(hi<lo) return;
 		int r = randomNut(lo,hi);
 		int j = partition(bolts,lo,hi,nuts[r]);
		int k = partition(nuts,lo,hi,bolts[j]);
 		showSelected(nuts[k],bolts[j]);
		match(nuts,bolts,lo,j-1);
		match(nuts,bolts,j+1,hi);
	}

	private static void  showSelected(Comparable n, Comparable b){
		System.out.println((((Nuts)n).getName())+" - "+ (((Bolts)b).getName()));
	}

	private static int randomNut(int lo, int hi){
		Random r = new Random();
		if(lo==hi) return lo;
		return r.nextInt(hi-lo)+lo;
	}

 
	private static int partition(Comparable [] a, int lo, int hi, Comparable check){

 	 	 int i,j;
 	 	 for( i=j=lo;j<hi;j++){
 	 	 	int cmp = compare(a[j],check);
 	 	 	if(cmp==-1){
 	 	 		swap(a,i,j);
 	 	 		i++;
 	 	 	}else if(cmp==0){
 	 	 		swap(a,j,hi);
 	 	 		j--;
 	 	 	}
		}
		swap(a,hi,i);
		return i;
	}

	private static int compare(Comparable a, Comparable b){

		if((a instanceof Bolts) && (b instanceof Nuts)){
			return (((Bolts)a).getSize()-((Nuts)b).getSize());
		}else{
			return (((Nuts)a).getSize()-((Bolts)b).getSize());
		}
	}

	private static void  swap(Comparable []a, int i , int j){
		
		Comparable swap = a[i];
		a[i]=a[j];
		a[j]=swap;
	}

	private static Comparable [] fillBolts(){

		Comparable [] bolts = new Bolts[4];
		bolts[0] = new Bolts(2,"twoB");
		bolts[1] = new Bolts(4,"fourB");
		bolts[2] = new Bolts(3,"threeB");
		bolts[3] = new Bolts(6,"sixN");

		return bolts;
	}

	private static Comparable [] fillNuts(){

		Comparable [] nuts = new Nuts[4];
		nuts[0] = new Nuts(2,"twoN");
		nuts[1] = new Nuts(4,"fourN");
		nuts[2] = new Nuts(3,"threeN");
		nuts[3] = new Nuts(6,"sixN");

		return nuts;
	}

	private static void show(Comparable[] nuts){
	
		for(Comparable n: nuts){
			if(n instanceof Nuts)
				System.out.print(((Nuts)n).getSize()+" ");
			else 
				System.out.print(((Bolts)n).getSize()+" ");
		}
		System.out.println("\n*******");
	}
}