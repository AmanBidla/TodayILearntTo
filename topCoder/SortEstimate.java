public class SortEstimate{
	

	public double estimate(int c, int time){

		double low=0,high=Integer.MAX_VALUE,x=0.0,previous=0.00;
		while(low<high){
			x=(high-low)/2+low;
			double t =calcualteTime(x,c);
			System.out.println("x is "+x+" t is "+t+" diff is "+(t-time)+" is less than 1e-6 is "+((t-time)<1e-6));
			
			 /*if(t==time) return x;
			else if(  (t-time)<0&&(t-time)<1e-6) return  x;
			else if(t>time) high=x;
			else low=x;*/

			if(t==time) return x;
			else if(t>time) high =x;
			else if (t<time) low=x;
			
			if (Math.abs(t-previous)<1e-12) return x;
			previous =t;

		}
		return x;
	}

	public double calcualteTime(double x, int c){
		double time = c*x*Math.log(x)/Math.log(2);
		return time;
	}

	public static void main(String[] args) {
		int c=1,time=8;
		//int c=2,time=16;
		//int c=37,time=12392342;
		SortEstimate e = new SortEstimate();
		System.out.println("n is "+e.estimate(c,time));
	}

}