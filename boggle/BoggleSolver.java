  
import java.util.Set;
import java.util.TreeSet;


class Item{

    public final int x, y;
    public final String prefix;
    public Item(int x, int y, String prefix){
        this.x=x;
        this.y=y;
        this.prefix=prefix;
    }
}


public class BoggleSolver {


    public static Trie buildTrie(String[] dict){

        Trie trie = new Trie();
        for(String word: dict){
            trie.addWord(word);
        }
        return trie;
    }

    public static Set<String> findWords(char [][] board, Trie dict){

        Set<String> result = new TreeSet<String>();
        int M = board.length;
        int N = board[0].length;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                boolean [][] visited = new boolean[M][N];
                dfs(result,dict,board,visited,new Item(i,j,""));
            }
        }
        return result;
    }

    public static void dfs(Set<String> result, Trie dict,char[][] board, boolean [][]visited, Item item ){

        int M = board.length;
        int N = board[0].length;
        int x = item.x;
        int y = item.y;
        if(x<0 || x>=M || y<0 || y>=N){
            return;
        }else if(visited[x][y]){
            return;
        }

        String newWord = item.prefix + board[x][y];
        TrieNode findWord = dict.match(newWord);
        if(findWord == null){
            return;
        }

        if(findWord.isWord()){
            result.add(newWord);
        }
        visited[x][y]=true;

        dfs(result,dict,board,visited,new Item(x,y-1,newWord));
        dfs(result,dict,board,visited,new Item(x,y+1,newWord));
        dfs(result,dict,board,visited,new Item(x-1,y,newWord));
        dfs(result,dict,board,visited,new Item(x+1,y,newWord));
        dfs(result,dict,board,visited,new Item(x+1,y+1,newWord));
        dfs(result,dict,board,visited,new Item(x-1,y-1,newWord));
        dfs(result,dict,board,visited,new Item(x-1,y+1,newWord));
        dfs(result,dict,board,visited,new Item(x+1,y-1,newWord));

        visited[x][y]=false;

    }

    public static void main(String[] args) {

        String [] dict = {"GEEKS","FOR","QUIZ","GO"};
        char [][] board = { {'G','I','Z'},{'U','E','K'},{'Q','S','E'} };

        Set<String> result = findWords(board,buildTrie(dict));
        for(String s: result){
            System.out.println(s);
        }
    }

}
