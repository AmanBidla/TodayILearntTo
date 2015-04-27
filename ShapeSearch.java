import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/* Shape has list of Cells and total size of Cell*/
class Shape{

	List<Cell> shapes = new ArrayList<Cell>();
	int size=0;

	public void add(Cell c){
		shapes.add(c);
		size++;
	}

	public String toString(){
		String str="";
		for(Cell c:shapes) str+=c.toString();
		return str+" having size = "+size;
	}

}

/* Cell represent a matrix cell having x and y coordinates */
class Cell{

	int x,y;
	Cell(int x,int y){
		this.x=x;
		this.y=y;
	}

	/* return true if 2 cells have same coordinates */
	public boolean equals(Object e){
		Cell cell = (Cell) e;
		if(cell.x==this.x && cell.y==this.y ) return true;		 
		else return false;
	}

	/* This is just quick representation of hash code for this matrix */	
	public int hashCode(){
		
		 
		if(x==0 && y==0){
			 return 123;
		}else if(x==0 && y==1){
			 return 124;
		}else if(x==1 && y==0){
			 return 125;
		}else 
			 return 126;
		 		
	}

	public String toString(){
		return "["+x+","+y+"]";
	}
}

/* Main class */
public class ShapeSearch{

	 int LENGTH; // Length of matrix
	 int BREATH; // Breath of matrix 
	 List<Shape> shapeList = new ArrayList<Shape>(); // List of all valid shapes in matrix


	/* returns all  adjacent cells of input Cell */ 
	public List<Cell> findNext(Cell cell){

		Cell n1 = new Cell(cell.x+1, cell.y);
		Cell n2 = new Cell(cell.x, cell.y+1);
		Cell n3 = new Cell(cell.x, cell.y-1);
		Cell n4 = new Cell(cell.x-1, cell.y);

		List<Cell> list = new ArrayList<Cell>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);

		return list;

	}

	/* return true if Cell is within range of matrix board */
	public boolean isValid(Cell c){

		int x = c.x;
		int y = c.y;

		return x>=0 && x<LENGTH && y>=0 && y<BREATH;

	}

	/* Actual main program starts here. Reads an input file of name "matrixInput.txt" and 
	* populates matrix and finds largest shape in matrix
	*/
	public static void main(String[] args) {
		
		boolean [][] matrix=null;
		ShapeSearch search = new ShapeSearch();
		matrix= search.create(matrix);
		search.find(matrix);
	}


	/**
	* Read input file to create matrix.
	* Input file has first line containing 2 Integers X,Y comma separated.
	*      The X represents length and Y represents breath of matrix
	*	   The next X lines contains 0's or 1s. 
	*	   0 represents false which is an invalid cell of Shape.
	*	   1 represent true which is a valid cell of Shape.
	*/
	public boolean[][] create(boolean[][]matrix){
		String in = "matrixInput.txt";
		
		try{

			BufferedReader buf = new BufferedReader(new FileReader(new File(in)));
			int m=0,j=0;
			String dimension = buf.readLine();
			LENGTH = Integer.parseInt(dimension.split(",")[0]);
			BREATH = Integer.parseInt(dimension.split(",")[1]);
			matrix = new boolean[LENGTH][BREATH];
			String line=null;
			while( (line=buf.readLine())!=null){
				String [] input = line.split("");
				for(int i=0;i<input.length;i++){
					int sign = Integer.parseInt(input[i]);					 
					if(sign==1) matrix[m][j]=true;
					else matrix[m][j]=false;

					j++;
				}
				m++;
				j=0;
			}
		}catch(FileNotFoundException e){

		}catch(IOException e1){

		} 
		return matrix;
	}
	 

	/* Wrapper method to find all largest shape */
	public void find(boolean [][]matrix){

		// First cell to visit is (0,0) 
		Cell c = new Cell(0,0);

		// Map to store visited cell
		Map<Cell,Boolean> seen = new HashMap<Cell,Boolean>();

		find(matrix,c, seen);

		// Find maximum shape from all shapes seen so far
		Shape maxShape=shapeList.get(0);
		for(int i=1;i<shapeList.size();i++){
			if(maxShape.size<shapeList.get(i).size){
				maxShape=shapeList.get(i);
			}
		}

		System.out.println("Max shape is "+maxShape.toString());
		 


	}	

	/* print x,y co-ordinate of cell */
	public void showCell(Cell cell){

		System.out.println("["+cell.x+","+cell.y+"]");
	}

	/* Depth first search on cell 
	*  Map<Cell,Boolean> map to keep track of all cells visited so far 
	*  boolean [][] matrix to represent the grid
	*/
	public void find(boolean [][] matrix, Cell cell, Map<Cell,Boolean> seen){

		// if cell position is invalid or have visited cell then return
		if(!isValid(cell) || seen.containsKey(cell) ) return;
		
		// mark cell as visited
		seen.put(cell,true);

		// BFS from current cell
		if( matrix[cell.x][cell.y]){

			// Queue to store all valid visited cell that are positive
			 Queue<Cell> q = new LinkedList<Cell>();
			 q.add(cell);
			 
			 // Shape to keep store all valid cells
			 Shape p = new Shape();
			 p.add(cell);


			 while(!q.isEmpty()){

			 	Cell c = q.remove();			 	
			 	List<Cell> adjacentList = findNext(c);
 			 	for(Cell adjCell: adjacentList){			 		
			 		 
			 		// if cell is in invalid position OR cell was previously visited OR cell is NEGATIVE don't process
			 		if(!isValid(adjCell) || seen.containsKey(adjCell) || !matrix[adjCell.x][adjCell.y] ) continue;
			 		 
			 		// mark cell as visited 
			 		seen.put(adjCell,true);
			 		q.add(adjCell);

			 		// update current shape with visited cell
			 		p.add(adjCell);
			 	}

			 }

			 // add final shape to shape list
			 shapeList.add(p);

		}

		// propagate to adjacent cells
		Cell n1 = new Cell(cell.x+1, cell.y);
		Cell n2 = new Cell(cell.x, cell.y+1);
		Cell n3 = new Cell(cell.x, cell.y-1);
		Cell n4 = new Cell(cell.x-1, cell.y);

		find(matrix, n1, seen);
		find(matrix, n2, seen);
		find(matrix, n3, seen);
		find(matrix, n4, seen);

	}
}