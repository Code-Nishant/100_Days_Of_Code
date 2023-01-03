class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2){
        if(str1.length() != str2.length()) return false;
        if(str1.equals(str2)) return true;
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length(); i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(map1.getOrDefault(ch1, ch2) != ch2 || map2.getOrDefault(ch2, ch1) != ch1) return false;
            else {
                map1.put(ch1, ch2);
                map2.put(ch2, ch1);   
            }
        }
        
        return true;
    }
}
