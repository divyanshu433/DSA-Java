public class tries_06 {
    static class Node{
        Node childern[] = new Node[26];
        boolean eow = false;
 
        public Node(){
            for(int i = 0; i < 26; i++){
                childern[i] = null;
            }
        }
    }
 
    public static Node root = new Node();

    public static void insert(String s){
        Node curr = root;
        for(int i = 0 ; i < 26; i++){
            int idx = s.charAt(i) - 'a';
            if(curr.childern[idx] == null){
                curr.childern[idx] = new Node();
            }
            curr = curr.childern[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i = 0 ; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.childern[idx] == null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.eow;
    }
    public static void main(String[] args) {
        
    }
}
