public class KMPAlgorithm{
	
	public static void main(String abc[]){
	
	char text[]= "abra abracad abracadabra".toCharArray();
	char pattern[]="abracadabra".toCharArray();
	
	int[]table = patternTable(text,pattern);
	int index =  findPattern(text,pattern,table);
	for(int i=index;i<text.length;i++){
		System.out.print(text[i]);
	}
	System.out.println("");
	
	}


	public static int findPattern(char[]text,char[]pattern,int[]table){
		int i=0,j=0;
		
		while((i+j)<text.length){
			
			if(pattern[i]==text[i+j]){
				if(i==pattern.length-1){
					return j;
				}
				i=i+1;
			}else{
				j=((i+j)-table[i]);
				if(table[i]>-1){
					i=table[i];
				}else{
					i=0;
				}
			}
		}
		return text.length;
	}
	
	public static int[] patternTable(char[]text,char[]pattern){
		int []table= new int [pattern.length];
		table[0]=-1;
		table[1]=0;
		int sub=0;
		for(int i=2;i<pattern.length;i++){
			if(pattern[i-1]==pattern[sub]){
				sub=sub+1;
				table[i]=sub;
				i=i+1;
			}else if(sub>0){
				sub=table[sub];
			}else{
				table[i]=0;
				i=i+1;
			}
		}
		return table;
	}

} 


