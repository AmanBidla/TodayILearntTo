  
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void addWord(String word){

        TrieNode node = root;
        char [] array = word.toCharArray();
        for(char c:array){

            node = node.addChild(c);
            if(node == null){
                return;
            }
        }
        node.setWord(true);
    }

    public TrieNode match(String S){

        TrieNode node = this.root;
        char [] array = S.toCharArray();
        for(char c:array){
            node = node.get(c);
            if(node == null){
                return null;
            }
        }
        return node;
    }

}