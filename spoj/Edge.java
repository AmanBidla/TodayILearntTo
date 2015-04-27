import java.util.NoSuchElementException;

public class Edge implements Comparable<Edge>{
	
	private double weight;
	private int v;
	private int w;

	public int compareTo(Edge that){
		if(this.weight<that.weight) return -1;
		if(this.weight>that.weight) return 1;
		else return 0;
	}


	public double getWeight(){
		return weight;
	}

	public int either(){
		return v;
	}

	public int other(int u){
		if(u==v) return w;
		else if(u==w) return v;
		else throw new NoSuchElementException(" No such vertex ");
	}

	public String toString(){
		return String.format("%d-%d %.2f",w,v,weight);
	}


}