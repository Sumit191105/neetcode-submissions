class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> map = new HashMap<>();
       for(String str : strs){
        int[] count = new int[26];
        for(char c : str.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i:count){
            key.append(i).append("#");
        }
        if(!map.containsKey(key.toString())){
            map.put(key.toString(),new ArrayList<>());
        }
        map.get(key.toString()).add(str);
       }
       return new ArrayList<>(map.values());
    }
}
