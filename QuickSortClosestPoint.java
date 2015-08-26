import java.util.Arrays;

  class Point implements Comparable<Point>{

	int x, y;

	Point(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int compareTo(Point p){

		//System.out.println("inside compare to method for ["+p.x+","+p.y+"]");
		if( (p.x*p.x) + (p.y*p.y) <2) return -1;
		else if((p.x*p.x) + (p.y*p.y) ==2) return 0;
		else return 1;

	}
}

public class QuickSortClosestPoint  {



    public static void main(String[] args) {
    	
    		//Point [] parray = {new Point(2,-2),new Point(1,1) ,new Point(-2,2) ,new Point(1,-1), new Point(-1,1),new Point(2,2) , new Point(-2,-2), new Point(-1,-1), new Point(3,4)};
    	//Point [] parray = {new Point(3,2),new Point(-1,0) ,new Point(6,-5) ,new Point(5,5), new Point(-4,3)};
    	Point [] parray = {new Point(300,200),new Point(-100,0) ,new Point(600,-500) ,new Point(500,500), new Point(-400,300)};
    		//int k=4;
    		int k=2;
    		for(int i=0;i<k;i++){
    			Point kPoint = kthClosestToOrigin(i,parray);	
    			showKPoint(kPoint,i);
    		}
    		sort(parray);
    		show(parray);
    		Integer [] a= {1,3,99,34,67,100,58};
    		 

    		 
    }

    public static void showKPoint(Point p,int k){
    	System.out.println(k+" th closest point is ["+p.x+","+p.y+"]");
    }

    public static Point kthClosestToOrigin(int k,Point []Points){
    	if(k<0 || k>=Points.length) throw new IndexOutOfBoundsException(" no such k ");
    	int lo=0, hi=Points.length-1;
    	while(hi>lo){
    		int i= partition(Points,lo,hi);
    		if(i>k) hi=i-1;
    		else if(i<k) lo=i+1;
    		else return Points[i];
    	}
    	return Points[lo];



    }


    public static void show(Point []a){
    	 for(Point p:a){
    	 	System.out.print("["+p.x+","+p.y+"]");
    	 }
    	 System.out.println();
    }

	public static void sort(Comparable<Point> []a){

		sort(a,0,a.length-1);
	}

	public static void sort(Comparable<Point> []a, int lo, int hi){
		if(hi <=lo) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	public static int partition(Comparable<Point> []a, int lo, int hi){
		int i=lo;
		int j=hi+1;
		Comparable<Point> v = a[lo];

		while(true){

			while(less(a[++i],v)) if( i == hi) break;
			while(less(v,a[--j])) if(j == lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}

		exch(a,lo,j);
		return j;
	}

	public static boolean less(Comparable v, Comparable  w){
		return (v.compareTo(w)>0);
	}

	

	public static void exch(Object []a, int v, int w){
		Object swap = a[v];
		a[v] = a[w];
		a[w] = swap;
	}

}