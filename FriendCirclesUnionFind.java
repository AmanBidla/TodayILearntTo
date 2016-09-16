public class FriendCirclesUnionFind {


	int [] roots;
    int [] size;
    int count;
    char [][]  matrix;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FriendCirclesUnionFind sol = new FriendCirclesUnionFind();
        String [] array = 
        {
        	"YYNN",
			"YYYN",
			"NYYN",
			"NNNY"
		};
		int N = 4;
        sol.populateInput(N, array);
        sol.solve();
    }
    
    private void solve() {
        
        int N = roots.length;
        for(int i=0;i<N;i++) {
           roots[i]=i;
           size[i]=1;            
        }
         
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]=='Y') {
                    if(!isConnected(i,j)){
                        union(i,j);
                    }
                }
            }
        }
        
        System.out.println(count);
         
    }
    
    private boolean isConnected(int i, int j){
        return find(i)==find(j);
    }
    
    private int find(int p){
        
        while(p!=roots[p]){
            p = roots[p];        
        }
        return p;
    }
    
    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ){
            return ;
        }
        if(size[rootP]<size[rootQ]){
            roots[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            roots[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        
        count--;
    }
    
    private void populateInput(int N, String[] array) {
         
         
        roots = new int[N];
        size = new int[N];
        count= N;
        matrix = new char[N][N];
        int index = 0;
        while(index<count){
            matrix[index] = array[index].toCharArray();             
            index++;
        }
    }
}