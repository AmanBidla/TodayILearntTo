import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
 

public class GraphDriver {

	private  static Graph graph;

	public static void process(String fileName){



		try{
			BufferedReader buf = new BufferedReader(new FileReader(new File(fileName)));
			String firstLine= buf.readLine();
			int VERTICES = Integer.parseInt(firstLine.split(",")[0]);
			int EDGES = Integer.parseInt(firstLine.split(",")[1]);	

			System.out.println("Number of vertices "+VERTICES);
			System.out.println("Number of edges "+EDGES);

			graph = new Graph(VERTICES);
			String line;
			while( (line=buf.readLine()) != null){
				 
				String []array = line.split(",");
				int v=0,w=0;
				for(int i=0;i<array.length;i++){
					if(i==0){
						v = Integer.parseInt(array[i]); 
					}else{
						w = Integer.parseInt(array[i]);
						//System.out.println("connecting "+v+" to "+w);
						graph.addEdge(v,w);
					}
				}
				 
			}




		}catch(FileNotFoundException e ){
			System.out.println(e.toString());
		}catch(IOException io){
			System.out.println(io.toString());
		}
		
	}

	public static void main(String[] args) {
		
		process("tiny.txt");
		for(int w: graph.adj(0)){
			System.out.println(w);
		}

	}

}