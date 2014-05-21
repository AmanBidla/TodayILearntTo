import java.util.Comparator;

public class Point2D implements Comparable<Point2D>{
	
	private int x;
	private int y;

	public static final Comparator<Point2D> X_ORDER = new XOrder();


	private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }
	public Point2D(int x,int y){
		this.x=x;
		this.y=y;
	}

	public double distanceTo(Point2D p){

		int ydis = (p.getY()-y);
		int xdis = (p.getX()-x);
		double dis = (ydis*ydis)-(xdis*xdis);
		dis = Math.sqrt(dis);
		return dis;

	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	  public int compareTo(Point2D that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

	

}