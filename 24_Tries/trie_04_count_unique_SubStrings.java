public class trie_04_count_unique_SubStrings {

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
        for(int i = 0; i < s.length(); i++){
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
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) -'a';
            if(curr.childern[idx] == null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return true;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.childern[i] != null){
                count += countNodes(root.childern[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";

        for(int i = 0; i < str.length(); i++){
            insert(str.substring(i));
        }
        System.out.println(countNodes(root));
    }
}
