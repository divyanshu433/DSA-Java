public class tries_05_longest_word_prefix {

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
            int idx = key.charAt(i) - 'a';
            if(curr.childern[idx] == null){
                return false;
            }
            curr = curr.childern[idx];
        }
        return curr.eow;
    }
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i = 0 ; i < 26; i++){
            if(root.childern[i] != null && root.childern[i].eow == true){
                char ch = (char) (i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.childern[i], temp);
                temp.deleteCharAt(temp.length() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
