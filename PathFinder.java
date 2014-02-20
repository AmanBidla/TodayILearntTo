import java.util.LinkedList;
import java.util.Queue;

class Point {

	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class PathFinder{


	private static Queue<Point> q = new LinkedList<Point>();

	private static char [][] matrix = {{'a','b','c','d','e'},
                      {'f','g','h','i','j'},
                      {'k','l','m','n','o'},
                      {'p','q','r','s','t'},
                      {'u','v','w','x','y'},
                      {'z',' ',' ',' ',' '}};

    private void findPath(){

    	String word ="con";
    	generateTarget(word);
    	Point last = new Point(0,0);
    	while(!q.isEmpty()){
    		Point t = (Point)q.remove();
    		findPath(last,t);
    		last =t;
    	}
 
    }

    public void generateTarget(String word){
    	Point p;
    	for(int i=0;i<word.length();i++){
    		p = generatePoint(word.charAt(i));
    		q.add(p);
    	}
    }

    public static void main(String[] args) {
    	PathFinder p = new PathFinder();
    	p.findPath();
    }

	public void findPath(Point p, Point t){

		int x=p.x;
		int y=p.y;

		if(isPointZ(x,y)){
			 zPath(p,t);
		}else if(x==t.x){
			 sameX(p,t);
		}else if(y==t.y){
			 sameY(p,t);
		}else if(x<t.x){
			 lessX(p,t);
		}else if(x>t.x){
			 moreX(p,t); 
		}
	}


	public void lessX(Point p, Point t){

		int x= p.x,y=p.y;
		while(x<t.x){
			if(otherThanZ(x,y)){
				 zPath(new Point(x,y),t);
			}
			System.out.println("MOVING DOWN "+x);
			x++;
		}


		 sameX(new Point(x,y),t);

	}

	public void moreX(Point p, Point t){

		int x=p.x,y=p.y;
		while(x>p.y){
			System.out.println("MOVING UP");
			x--;
		}

		  sameX(new Point(x,y),t);
	}
	public boolean isPointZ(int x, int y){
		Point p = generatePoint('z');
		return ((p.x==x) && (p.y==y));	
	}

	public void sameX(Point p, Point t){

		int x= p.x;
		int y=p.y;

		if(y<t.y){
			while(y<t.y){
				System.out.println("MOVE RIGHT");
				if(otherThanZ(x,y)){
					 zPath(new Point(x,y),t);
				}
				y++;
			}
			System.out.println("REACHED TARGET ==>"+matrix[x][y]);
			System.out.println("---------");
		}else{
			while(y>t.y){
				System.out.println("MOVE LEFT");
				y--;
			}
			System.out.println("REACHED TARGET ==>"+matrix[x][y]);
			System.out.println("---------");
		}

	}

	public void sameY(Point p, Point t){
		int x= p.x;
		int y=p.y;

		if(x<t.x){
			while(x<t.x){
				System.out.println("MOVE UP");
				x++;
			}
			System.out.println("REACHED TARGET"+matrix[x][y]);
			System.out.println("---------");
		}else{

			while(x>t.x){
				System.out.println("MOVE DOWN");
				if(otherThanZ(x,y)){
					 zPath(new Point(x,y),t);
				}
				x--;
			}
			System.out.println("REACHED TARGET"+matrix[x][y]);
			System.out.println("---------");

		}

	}


	public void zPath(Point p, Point t){

		if( targetReached(p,t))
			return;
		else{
			if(!otherThanZ(p)){
				System.out.println("MOVING UP");
				Point p1=generatePoint('u');
				 findPath(p1,t);
			}else{
				int x=p.x-1;
				int y=p.y;
				 findPath(new Point(x,y),t);
			}


		}
	}

	public boolean targetReached(Point p, Point t){
		return ((p.x==t.x) && (p.y==t.y));
	}

	public boolean otherThanZ(Point p){

		Point z = generatePoint('z');
		return ((p.x==z.x) && (p.y==z.y));
	}

	public boolean otherThanZ(int x, int y){
		Point p = new Point(x,y);
		return otherThanZ(p);
	}

	public Point generatePoint(char c){
		int x = (c-'a')/5;
		int y= (c-'a')%5;
		return new Point (x,y);
	}




}