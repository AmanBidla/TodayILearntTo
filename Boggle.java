import java.util.*;

class Node{

    Map<Character,Node> map = new HashMap<>();
    boolean isWord;
    char val;
    Node parent;

}

class Trie{

    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){

            char c = word.charAt(i);
            if(!curr.map.containsKey(c)){
                Node node = new Node();
                node.parent = curr;
                node.val = c;
                curr.map.put(c, node);
            }
            curr = curr.map.get(c);
        }
        curr.isWord=true;
    }

    public Node startsWith(String prefix) {
        if (prefix.length()==0){
            return null;
        }
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!curr.map.containsKey(c)){
                return null;
            }
            curr = curr.map.get(c);
        }
        return curr;
    }

    public void remove(String word) {

        Node curr = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            curr = curr.map.get(c);
        }

        curr.isWord= false;

        while(!curr.equals(root) && (curr.parent.map.size()==1)) {
            Node parent = curr.parent;
            parent.map.clear();
            curr = null;
            curr = parent;
        }

        Node parent = curr.parent;
        parent.map.remove(curr.val);

    }




}

public class Boggle {

    public List<String> solve(char [][] board, String[] words ){

        List<String> result = new ArrayList<>();

        if(board == null || board.length==0 || words==null || words.length==0){
            return result;
        }

        Trie trie  = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        boolean [][]   visited = new boolean[board.length][board[0].length];

        String buf ="";

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {

                dfs(board, i, j, trie, visited, buf, result);
            }
        }

        return result;

    }

    private static void dfs(char [][]board, int i, int j, Trie trie, boolean [][] visited, String buf, List<String> result) {

        if (i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j]) {
            return ;
        }
        visited[i][j] = true;

        buf = buf + String.valueOf(board[i][j]);
        //System.out.println(">> "+buf);

        Node node = trie.startsWith(buf);

        if(node!= null && node.isWord){
            result.add(buf.toString());
            trie.remove(buf.toString());
        }


        dfs(board, i+1, j, trie, visited, buf,result);
        dfs(board, i, j+1, trie, visited, buf,result);
        dfs(board, i, j-1, trie, visited, buf,result);
        dfs(board, i-1, j, trie, visited, buf,result);

        dfs(board, i - 1, j - 1,trie, visited, buf,result);
        dfs(board, i - 1, j + 1,trie, visited, buf,result);
        dfs(board, i + 1, j - 1, trie,visited, buf,re sult);
        dfs(board, i + 1, j + 1, trie,visited, buf,result);


        buf= buf.substring(buf.length()-1);
        visited[i][j] =false;

    }

    public static void main(String[] args) {

        //char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        //String[] words = {"oath","pea","eat","rain"};
        Boggle boggle = new Boggle();

        char [] [] board = {
                {'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
        String [] words = {"GEEKS", "FOR", "QUIZ", "GO"};
        

        List<String>result = boggle.solve(board, words);
        result.stream().forEach(s -> System.out.println(s));
    }

}
