public class countAndSay{

    public String countAndSay(int n) {
     
	     if(n<=0){
	         return "";
	     }else if(n==1){
	         return "1";
	     }
	     
	     int count=0;
	     int i=1;
	     char [] seq = {'1'};
	     while(i<n){
	         StringBuilder buf = new StringBuilder();
	         count=0;
	         char last = seq[0];
	         for(int j=0;j<=seq.length;j++){
	             if(j<seq.length && seq[j]==last){
	                 count++;
	                 continue;
	             }else{
	                 buf.append(count).append(last);
	                 if(j<seq.length){
	                     last=seq[j];
	                 }
	                 count=1;
	             }
	         }
	         seq = buf.toString().toCharArray();
	         i++;
	     }
	     return new String(seq);
	}
}
 