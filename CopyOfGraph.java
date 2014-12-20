package Google.TodayILearntTo;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Vertex implements Comparable<Vertex>{
	private final int v;
	Vertex adj=null;
	String id=null;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vertex(int v) {
		super();
		this.v = v;
	}

	public int getV() {
		return v;
	}
	public void adj(Vertex w){
		adj= w;
	}
	public Vertex getAdj(){
		return adj;
	}

	@Override
	public int compareTo(Vertex w) {
		if(v<w.getV())
			return -1;
		else if(v>w.getV()){
			return 1;
		}else{
			return 0;
		}
	}

	 
	 
}
public class CopyOfGraph {


	private int V;
	private int E;
	private int S;
 	private Vertex [][] matrix;
 	private boolean[] marked;
 
	public CopyOfGraph() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			this.S = Integer.parseInt(reader.readLine());
			this.V = S*S;
 	        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");	  
	        this.E = 0;
 	        matrix = new Vertex[S][S];
 	        marked = new boolean [V];
	        createMatrix(reader);
	         
        }catch(IOException e){
        	System.out.println(e.toString());
        }

    }

 


	private void createMatrix(BufferedReader reader) throws IOException {
		int row=0;
		for(int i=0;i<S;i++){
			createMatrix(reader, row);
			row++;
		}
	}


	private void createMatrix(BufferedReader reader, int row)
			throws IOException {
		String line;
		line=reader.readLine();
		String []lineArray = line.split(" ");
		for(int j=0;j<lineArray.length;j++){
			matrix[row][j]=new Vertex(Integer.parseInt( lineArray[j]));
		}
	}

 
    public static void main(String[] args) {
    	
    	CopyOfGraph g = new CopyOfGraph();
    	g.showMatrix();
    	g.createLink();
    	System.out.println(g.toString());
    	g.countConnected();
    }

    private void createLink() {
    	
    	for(int row=0;row<S;row++){
    		for(int col=0;col<S;col++){
    			
    			Vertex v0= matrix[row][col];
    			Vertex v1=new Vertex(Integer.MAX_VALUE);
    			Vertex v2=new Vertex(Integer.MAX_VALUE);
    			Vertex v3=new Vertex(Integer.MAX_VALUE);
    			Vertex v4=new Vertex(Integer.MAX_VALUE);
    			
    			if(col-1 >=0){
    				v1=matrix[row][col-1];
    			}
    			if(col+1 <S){
    				v2=matrix[row][col+1];
    			}
    			if(row-1 >=0){
    				v3=matrix[row-1][col];
    			}
    			if(row+1 <S){
    				v4=matrix[row+1][col];
    			}
    			
    			 
    			Vertex min =v1.compareTo(v2)<=0?v1:v2;
    			min= min.compareTo(v3)<=0?min:v3;
    			min=min.compareTo(v4)<=0?min:v4;
    			if(min.getV()<=v0.getV())
    				addEdge(v0,min);
    				
    			}
    			
    		}
    	}
		
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for(int row=0;row<S;row++){
        	for(int col=0;col<S;col++){
        		 Vertex v = matrix[row][col];
        		 s.append((v.getV()) + ": ");
        		 Vertex w = v.getAdj();
        		 if(w!=null){
        			 s.append((w.getV()) + " ");
        		 }        		  
                 s.append(NEWLINE);
        	}
        }
         
        return s.toString();
    }


	private void addEdge(Vertex v, Vertex w) {
        E++;
        System.out.println("v "+v.getV()+" w "+w.getV());
        if(v.getV()<=w.getV())
        	w.adj(v);	        	
        else
        	v.adj(w);	
	}


	public void showMatrix(){

    	for(int i=0;i<S;i++){
    		for(int j=0;j<S;j++){
    			System.out.print(matrix[i][j].getV()+" ");
    		}
    		System.out.println("");
    	}
    }
	
	public void countConnected(){
		int index=64;
		Map<String,Integer> connected = new HashMap<String,Integer>();
		for(int row=0;row<S;row++){
			for(int col=0;col<S;col++){
				Vertex v = matrix[row][col];
				Vertex w = v.getAdj();
				if(w!=null){
					if(w.getId()==null){
						index++;
						String id = String.valueOf((char)(index));
						w.setId(id);
						v.setId(id);
						System.out.println(w.getV()+"  "+w.getId()+ " "+v.getV()+" "+v.getId());
						connected.put(id,1);
 					}else{
 						v.setId(w.getId());
 						System.out.println("resetting "+w.getV()+"  "+w.getId()+ " "+v.getV()+" "+v.getId());
 						int count = connected.get(w.getId());
 						count++;
 						connected.put(w.getId(),count);
 					}
				}
			}
		}
		int size = connected.size();
		index=64;
		int [] array= new int[size];
		for(int i=0;i<size;i++){
			index++;
			String id= String.valueOf((char)(index));
			array[i]=connected.get(id)+1;
		}
		Arrays.sort(array);
		if(size==0){
			System.out.println(1);
		}
		for(int i=size-1;i>=0;i--){
			System.out.print(array[i]+" ");
		}
		
	}



}