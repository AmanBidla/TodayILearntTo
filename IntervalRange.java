import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntervalRange{


	private static final String DELIMITER=  ";\\s";
	private static final String SPACE_DELIMITER = "\\s";
	private static final String HIPHEN_DELIMTER = "-";
	private static final Map<String, Integer> month = new HashMap<String, Integer>();
		
	/**
	*  Read input file and process every line of input file
	* @param String filename to process
	*/
	public static void readFile(String file){

		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			
			String line;
			
			while ((line = input.readLine()) != null) {

				 processLine(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file "+file+" not found "+ e);
		} catch (IOException e) {
			System.out.println("IO exception in processing "+file+" "+ e);
		}


	}

	/**
	*   This method is used to process every line from input file.
	*   Months spending working is an int array of total months between 1990 and 2020
	*   which is 12*32 years =372.
	*  	
	*   Fill months working experience based on start and end time.
	*   Count the total years from month spending working
	* 
	*  @param String line to process 
	*/
	public static void processLine(String line){

				String[] inputSplitByDelimiter = line.split(DELIMITER);
				int[] monthsSpendWorking = new int[372];
				int totalExperience=0;

				Arrays.fill(monthsSpendWorking, 0);

				for (int i=0; i<inputSplitByDelimiter.length; i++){
					String[] period = inputSplitByDelimiter[i].split(HIPHEN_DELIMTER);
					String[] time = period[0].split(SPACE_DELIMITER);
					fillWorkingMonths(monthsSpendWorking,period,time);
				}
				  
				//totalExperience = Arrays.stream(monthsSpendWorking).sum()/12;
				for(int month:monthsSpendWorking){
					totalExperience+=month;
				}
				totalExperience/=12;
 
				System.out.println(totalExperience);
	}

	/**
	* This method is called to fill the monthsSpendingWorking array from start and end months.
	* Start and end months are obtained from input line respectively.
	* Fill the months spend array with value 1 from start and end time
	* @param array of monthsSpend working (initially empty)
	* @param array of year period
	* @param array of month time
	*
	*/
	public static void fillWorkingMonths(int[] monthsSpendWorking,String [] period, String[] time){
		 			 
			int start = month.get(time[0]) + ((Integer.parseInt(time[1])-1990)*12);
			time = period[1].split(" ");
			int end = month.get(time[0]) + ((Integer.parseInt(time[1])-1990)*12);
			Arrays.fill(monthsSpendWorking,start,(end+1),1);
			 				
	}

	static{

		month.put("Jan",0); month.put("Feb",1);month.put("Mar",2);month.put("Apr",3);
		month.put("May",4); month.put("Jun",5);month.put("Jul",6);month.put("Aug",7);
		month.put("Sep",8); month.put("Oct",9);month.put("Nov",10);month.put("Dec",11);
	}

	/* Main begins here */
	public static void main(String[] args) {

		if(args.length!=1){
			System.out.println("Please enter 1 valid file name");
		}else{

			String file = args[0];
			readFile(file);		
		}
		
	}
}