import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;

public class EZDIJKST{


	private static class Edge extends ArrayList<Edge>  {

		private int from;
		private int to;
		private int weight;

		public Edge(int from, int to, int weight){
			this.from=from;
			this.to=to;
			this.weight=weight;
		}

		public int compareTo(Edge that){
			System.out.println("comparing "+this.weight+" with "+that.weight);
			if(this.weight<that.weight) return 1;
			if(this.weight>that.weight) return -1;
			else return 0;
		}

		public String toString(){
			return String.format("%d->%d %d",from,to,weight);
		}
		
       @Override
		public boolean equals(Object other){
			Edge o = (Edge) other;
			if(this.from==o.from){
				if(this.to==o.to){
					if(this.weight==o.weight){
						return true;
					}
				}
			}
			return false;
		}

       @Override
		public int hashCode(){
			 
			String s = (from*to)* Math.random()+""+weight;
			return s.hashCode();
		}

	}
 	
 	
 	public static void main(String[] args) {
 		try{
 			readInput();	
 		}catch(IOException e){

 		}
 		
 	}

 	static int MIN=0; 	 


 	private static void readInput() throws IOException {

 		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
 		String line;
 		 

 			int test = Integer.parseInt(buf.readLine());
 			String [] result = new String[test];
 			for(int t=0;t<test;t++){

 				line = buf.readLine();
 				int vertices = Integer.parseInt(line.split(" ")[0]);
 				int edges = Integer.parseInt(line.split(" ")[1]);
 				

 				//System.out.println("vertices "+vertices);
 				//System.out.println("edges "+edges);

 				
 				int maxV=Integer.MIN_VALUE;
 				String [] array = new String[edges];
 				for(int i=0;i<edges;i++){	
 					line = buf.readLine();
 					int from = Integer.parseInt( line.split(" ")[0]);
 					int to = Integer.parseInt( line.split(" ")[1]);
 					int weight = Integer.parseInt( line.split(" ")[2]);
 					if(maxV < from){
 						maxV=from;
 					} 
 					if(maxV<to){
 						maxV=to;
 					}
 					array[i]=from+" "+to+" "+weight;
 				}
 				//System.out.println("max "+maxV);
 				int [] distTo= new int[maxV+1];
 				Edge[] adj = new Edge[maxV+1];
 				for(int i=0;i<maxV+1;i++){
 					adj[i]= new Edge(0,0,0);
 				}

 				for(int i=0;i<edges;i++){	
 					line = array[i];
 					int from = Integer.parseInt( line.split(" ")[0]);
 					int to = Integer.parseInt( line.split(" ")[1]);
 					int weight = Integer.parseInt( line.split(" ")[2]);
 					Edge e = new Edge(from, to, weight);
 					//System.out.println("edge is "+e.toString());
 					adj[from].add( e );
 				}

 				line = buf.readLine();
 			    int SOURCE = Integer.parseInt(line.split(" ")[0]);
 			    int DESTINATION = Integer.parseInt(line.split(" ")[1]); 			     

 			    //System.out.println("SOURCE "+ SOURCE);
 			    //System.out.println("DESTINATION "+ DESTINATION);
 			    Comparator<Edge> weightComparator = new weightComparator();
				PriorityQueue<Edge> minQueue = new PriorityQueue<Edge>(edges, weightComparator);
 			    minQueue.add(new Edge(-1,SOURCE,0));
 			    for(int i=0;i<maxV+1;i++){
 			    	distTo[i]=Integer.MAX_VALUE;
 			    }
 			    distTo[SOURCE]=0;
 			   
 			    	disjstras(adj,SOURCE,minQueue,distTo); 

	 			    if(DESTINATION <=maxV && distTo[DESTINATION]==Integer.MAX_VALUE){
						//System.out.println("NO");
						result[t]="NO";
	 			    }else if(DESTINATION <=maxV ){
	 			    	//System.out.println(distTo[DESTINATION]);	
	 			    	result[t]=""+distTo[DESTINATION];
	 			    }else{
	 			    	result[t]="NO";
	 			    }	
 			
 			    
 			    
 			}

 			for(int t=0;t<test;t++){
 				System.out.println(result[t]);
 			}

 	}

 	private static class weightComparator implements Comparator<Edge>{
 		@Override
 		public int compare(Edge a, Edge b){
 			//System.out.println("comparing weight "+a.weight+" with "+b.weight);
 			if(a.weight<b.weight) return -1;
 			else if(a.weight>b.weight) return 1;
 			else return 0;
 		}
 	}

 	private static void disjstras(Edge[] adj, int SOURCE,Queue<Edge> minQueue,int[] distTo){

 		while(!minQueue.isEmpty()){
 			Edge v = minQueue.poll();
 			//System.out.println("queue size "+minQueue.size());
 			//System.out.println("now removing "+v.toString());
 			relax(adj,v,minQueue,distTo);
 		}

 	}

 	private static void relax(Edge[] adj, Edge fromEdge,Queue<Edge> minQueue,int[] distTo){
 		//////System.out.println("fromEdge "+fromEdge.toString());
 		int v = fromEdge.to;
 		//System.out.println("v "+v);
 		for(Edge e: adj[v]){
 			int w = e.to;
 			//System.out.println("w "+w); 			
 			//System.out.println("dist["+w+"]= "+ distTo[w] +" compare dist["+v+"]="+distTo[v]+" + "+e.weight);
 			if(distTo[w]>distTo[v]+e.weight){
 				
 				//System.out.println("queue size is "+minQueue.size());
 				//System.out.println("edges are ");
 				/*Iterator<Edge> it  = minQueue.iterator();
 				while(it.hasNext()){
 					Edge iedge = (Edge)it.next();
 					System.out.println(iedge.toString());
 				}*/
 				Edge oldEdge = new Edge(v,w,distTo[w]);
 				////System.out.println("old edge "+oldEdge.toString());
 				distTo[w]=distTo[v]+e.weight;
 				//System.out.println("contains old edge "+minQueue.contains(oldEdge));
 				Edge someOther = new Edge(1,2,4);
 				////System.out.println("contains some other edge "+minQueue.contains(someOther));
 				someOther = new Edge(1,12,14);
 				//System.out.println("contains another other edge "+minQueue.contains(someOther));
 				if(minQueue.contains(oldEdge)){
 					//System.out.println("removing old edge "+oldEdge.toString());
 					//System.out.println("removed = "+minQueue.remove(oldEdge));
 					minQueue.remove(oldEdge);
 				}
 				int newDist=distTo[v]+e.weight;
 				Edge toAdd = new Edge(v,w,newDist);
 				//System.out.println("adding "+toAdd.toString());  
 				minQueue.offer( new Edge(v,w,newDist));
 				//System.out.println("queue size is "+minQueue.size());
 				//System.out.println("edges are ");
 				/*it  = minQueue.iterator();
 				while(it.hasNext()){
 					Edge iedge = (Edge)it.next();
 					System.out.println(iedge.toString());
 				}*/
 			}
 		}
 	}

}