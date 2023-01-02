class Solution {
    public List < List < String >> Anagrams(String[] string_list) {
        Trie root = new Trie();
        int size = string_list.length;
        for (int i = 0; i < size; ++i) {
            char[] buffer = string_list[i].toCharArray();
            // Sort the buffer
            Arrays.sort(buffer);
            Trie.insert(root, new String(buffer), i);
        }
        List < List < String >> ans = new ArrayList < > ();
        printAnagramsUtil(root, string_list, ans);
        return ans;
    }
    static void printAnagramsUtil(Trie root, String[] wordArr, List < List < String >> ans) {
        if (root == null)
            return;
        if (root.endOfWord) {
            ArrayList < String > words = new ArrayList < String > ();
            for (Integer i: root.wordIdx) {
                words.add(wordArr[i]);
            }
            ans.add(words);
        }
        for (int i = 0; i < 26; ++i)
            printAnagramsUtil(root.children[i], wordArr, ans);
    }
}
class Trie {
    Trie[] children;
    boolean endOfWord;
    List < Integer > wordIdx;
    Trie() {
        children = new Trie[26];
        Arrays.fill(children, null);
        endOfWord = false;
        //list to store index of words
        wordIdx = new ArrayList < Integer > ();
    }
    //insert function
    static void insert(Trie root, String s, int idx) {
        Trie temp = root;
        for (char i: s.toCharArray()) {
            int childIdx = i - 'a';
            if (temp.children[childIdx] == null) {
                temp.children[childIdx] = new Trie();
            }
            temp = temp.children[childIdx];
        }
        temp.wordIdx.add(idx);
        temp.endOfWord = true;
    }
}
