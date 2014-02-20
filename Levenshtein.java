import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class BayBridges {
	/* Point class comprises of BigDecimal x,y
	* 
	* x represent coordinate of x-coordinate of Point
	* y represent coordinate of y-coordinate of Point
	*
	*/
	static class Point implements Comparable<Point> {
		BigDecimal x;
		BigDecimal y;
		

		public Point(BigDecimal x, BigDecimal y){
			this.x =x;
			this.y =y;
		}

		@Override
		public int compareTo(Point p){
 			return x.compareTo(p.x);
		}
	}

	/* Location class comprises of Point P1,P2,serial#
	*
	* P1 represent coordinate of Location on left side of bank
	* P2 represent coordinate of Location on right side of bank
	* num represents serial number of location
	*
	*/
	static class Location implements Comparable<Location> {
		Point top,bottom;
		int num;

		public Location(Point a, Point b,int num) {
			this.top =a;
			this.bottom =b;
			this.num = num;
		}

		@Override
		public int compareTo(Location l){

			return bottom.compareTo(l.bottom);
		}

		private BigDecimal distanceTopFromOrigin(){
			return top.x;
		}

		private BigDecimal distanceBottomFromOrigin(){
			return bottom.x;
		}
	}


	/* Find the longest increasing subsequence of locations  */
	private static List<Integer> longestIncreasingSubstequence(List<Location>locations){


		Location [] array = locations.toArray(new Location[locations.size()]);
		
		int N = array.length;
		int [] dp = new int[N];
		int [] prev = new int[N];

		for(int i=0;i<N;i++){
			dp[i]=1;
			prev[i]=-1;
		}

		int ans=0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){

				if(less(array[i],array[j] ) ) {
					
					if(dp[i]+1>dp[j]){
						dp[j]= dp[i]+1;
						prev[j]=i;	
					}

					if(dp[j]>dp[ans]){
						ans=j;	
					}
				}
				
			}
		}

		Location [] sub = new Location[dp[ans]];
		int L = dp[ans];
		List<Integer> brigeNum = new ArrayList<Integer>();

		for(int i=L-1;i>=0;i--){
			sub[i]= array[ans];
			ans = prev[ans];
			brigeNum.add(sub[i].num);
		}

		//Collections.sort(brigeNum);
		
		for(int i:brigeNum){
			System.out.println(i);
		}

		return brigeNum;

	}

	/* compare x coordinate of 2 locations */
	private static boolean  less(Location a, Location b){

		if( ((a.distanceTopFromOrigin()).compareTo(b.distanceTopFromOrigin())) <=0) return true;
		else return false;
	}

	/* parse file
	 *
	 * create Point p1 with  x1,y1
	 * create Point p2 with  x2,y2
	 * create Location L (P1,P2,Serial#)
	 * 
	 *  add Location L to ArrayList of Locations
	 *  
	 *  return ArrayList of locations
	 */
	private static List<Location> parseFile(String file) throws FileNotFoundException{
		List<Location> locations = new ArrayList<Location>();
		File f = new File(file);
		Scanner sc = new Scanner(f);
		int count =1;
		while(sc.hasNextLine()){
			
			String line = sc.nextLine();
			String part= line.substring(3);

			String [] array = part.split(",");
			
			String a = array[0].substring(2,array[0].length());
			String b = array[1].substring(0,array[1].length()-1);
			String c = array[2].substring(2);
			String d = array[3].substring(0,array[3].length()-2);
		
			Point p1 = new Point(new BigDecimal(a.trim()),new BigDecimal(b.trim()));
			Point p2 = new Point(new BigDecimal(c.trim()),new BigDecimal(d.trim()));

			Location l = new Location(p1,p2,count);
			locations.add(l);
			count++;
		}

		return locations;
	}

	/* main program starts here
	 *   accepts a string file name 
	 *   parses file 
	 *          file format :
     *			N lines where each line is of the format :
     *			serial#: ([X1-CORD, Y1-CORD], [X2-CORD, Y1-CORD])
     *   sort locations based on x-coordinate at bottom
     *   find longest increasing subsequence based on  x-coordinate at top
     */
	public static void main(String[] args) {
		String file;
		if(args.length>0){
			try{
				file = args[0];
				List<Location> locations= parseFile(file);
				Collections.sort(locations);
				longestIncreasingSubstequence(locations);
				//test();
			}catch(FileNotFoundException e){
				System.out.println(e.toString());
			}
			
		}
		 
		
	}



	/* test results */
	public static void test(){
		List<Location> list = importAllTest();
		Collections.sort(list);
		List<Integer> testList = longestIncreasingSubstequence(list);

		assert(testList.get(0)==1);
		assert(testList.get(2)==2);
		assert(testList.get(3)==3);
		assert(testList.get(4)==5);
		assert(testList.get(5)==6);
		assert(testList.size()==5);

	}

	/* test cases */
	private static List<Location> importAllTest(){

		List<Location> locations = new ArrayList<Location>();

		Point ptop = new Point(new BigDecimal("37.788353"), new BigDecimal("-122.387695"));
		Point pbottom = new Point(new BigDecimal("37.829853"), new BigDecimal("-122.294312"));
		Location L = new Location(ptop,pbottom,1);
		locations.add(L);


		ptop = new Point (new BigDecimal("37.429615"), new BigDecimal("-122.087631"));
		pbottom = new Point(new BigDecimal("37.487391"), new BigDecimal("-122.018967"));
		L = new Location(ptop,pbottom,2);
		locations.add(L);

		ptop = new Point (new BigDecimal("37.474858"), new BigDecimal("-122.131577"));
		pbottom = new Point(new BigDecimal("37.529332"), new BigDecimal("-122.056046"));
		L = new Location(ptop,pbottom,3);
		locations.add(L);
		

		ptop = new Point (new BigDecimal("37.532599"),new BigDecimal("-122.218094"));
		pbottom= new Point(new BigDecimal("37.615863"),new BigDecimal("-122.097244"));
		L = new Location(ptop,pbottom,4);
		locations.add(L);
		

		ptop = new Point (new BigDecimal("37.516262"),new BigDecimal("-122.198181"));
		pbottom= new Point(new BigDecimal("37.653383"),new BigDecimal("-122.151489"));
		L = new Location(ptop,pbottom,5);
		locations.add(L);
		

		ptop = new Point (new BigDecimal("37.504824"),new BigDecimal("-122.181702"));
		pbottom = new Point(new BigDecimal("37.633266"),new BigDecimal("-122.121964"));
		L = new Location(ptop,pbottom,6);
		locations.add(L);
		

		return locations;

	}


	 
}