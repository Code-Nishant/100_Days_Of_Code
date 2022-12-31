class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);

        map.put("V", 5);

        map.put("X", 10);

        map.put("L", 50);

        map.put("C", 100);

        map.put("D", 500);

        map.put("M", 1000);

        

        int num = 0;

        String s;

        for (int i = 0; i <= str.length() - 1; i++) {

            if (i != str.length() - 1) {

                if (map.get(str.substring(i, i + 1)) < map.get(str.substring(i + 1, i + 2))) {

                    num += map.get(str.substring(i + 1, i + 2)) - map.get(str.substring(i, i + 1));

                    i++;

                } else {

                    num += map.get(str.substring(i, i + 1));

                }

            } else {

                num += map.get(str.substring(i, i + 1));

            }

        }

        

 

        return num;
    }
}
