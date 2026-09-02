class  Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        HashSet<String> set = new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair temp = q.poll();
            String word = temp.first;
            int level = temp.second;
            if(word.equals(endWord)==true) return level;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] newCharacter = word.toCharArray();
                    newCharacter[i]=ch;
                    String newWord = new String(newCharacter);
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
