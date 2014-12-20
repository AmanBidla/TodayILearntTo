import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class DiskTree{

	Directory root = new Directory("root");

	class Directory{

		List<Directory> list = new ArrayList<Directory>();
		int depth;
		String name;
		public Directory(String name){
			this.name=name;
			depth=0;
		}

		public Directory addSub(String name,Directory current){
			Directory d = new Directory(name);
			current.getSub().add(d);

			Collections.sort(current.getSub(), new Comparator<Directory>(){
				public int compare(Directory d1, Directory d2){
					return d1.name.compareTo(d2.name);
				}
			});
			return current;
		}
		public String toString(){
			StringBuffer sb =new StringBuffer();
			if(!name.equals("root")){
				sb.append(name);
				sb.append(System.getProperty("line.separator")+" ");	
			}		
			for(int i=0;i<list.size();i++){
				sb.append(list.get(i).toString());
			}
			return sb.toString();

		}

		public void listSub(){
			for(Directory d:list){
				System.out.println(d.name);
			}
		}

		public List<Directory> getSub(){
			return list;
		}
	
		public Directory find(String name,Directory d){
			if(d.name==name){
				return d;
			}
			for(Directory directory:getSub()){
				Directory find = find(name,directory);
				if(find!=null){
					return find;
				}
			}
			return null;
		}

	}	
		public static void main(String[] args) {
				
				DiskTree t = new DiskTree();
				t.init();
			
		}

		public void init(){

			try{

				BufferedReader buf = new BufferedReader( new InputStreamReader( System.in ));
				String line =buf.readLine();
				int total = Integer.parseInt(line);
				while(total>0){
					total--;
					line = buf.readLine();										 
					System.out.println("line "+line);
					if(line.split("\\\\").length>0){
						String [] array = line.split("\\\\");
						System.out.println("finding if already present");
						Directory alreadyPresent =  root.find(array[0],root);
						if(alreadyPresent==null){
							System.out.println("not present");
							alreadyPresent = root.addSub(array[0],root);
						}
						System.out.println("adding subarray from index 1");
						System.out.println("already.name "+alreadyPresent.name );
						for(int i=1;i<array.length;i++){
							alreadyPresent= alreadyPresent.addSub(array[i],alreadyPresent);
							System.out.println("already.name "+alreadyPresent.name );
						}						
					}
					System.out.println("total --");
				}

				//System.out.println(root.toString());
			}catch(IOException e){
				System.out.println(e.toString());
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}


}