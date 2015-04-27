import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Item implements Comparable<Item>{

	int item;
	int index;

	public Item(int index, int item){
		this.index=index;
		this.item=item;
	}

	public boolean equals(Object i){
		Item t =(Item) i;
		if(this.item==t.item) return true;
		else return false;
	}

	public int compareTo(Item otherItem){
		if(this.item<otherItem.item) return -1;
		else if(this.item>otherItem.item) return 1;
		else return 0;
	}

	public String toString(){
		return "array["+index+"]= "+item;
	}
}
public class CountIdenticalPairs{


	public static void main(String[] args) {
		
		int [] array = {3,5,6,3,3,5};
		//int [] array = {3,3,3,3,3,3};
		System.out.println( count(array));

	}

	public static int count(int[] array){

		int inversion=0;
		int N = array.length;
		Item [] itemArray = new Item[N];
		for(int i=0;i<N;i++){

			 Item item = new Item(i,array[i]);
			 itemArray[i]=item;
		}

		Arrays.sort(itemArray);
		
		for(int i=0;i<N;i++){
			Item target = itemArray[i];
			int j=i+1;
			while(j<N && itemArray[j].index>target.index && itemArray[j].item==target.item){
				inversion++;
				j++;
			}			 		 
		}		 

		return inversion;
	}

}