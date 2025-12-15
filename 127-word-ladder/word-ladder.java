class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int el=0;el<n;el++){
                String node=q.poll();
                if(node.equals(endWord)) return level+1;
                List<String> Node_list=neighbours(node,set);
                for(String s:Node_list){
                    q.offer(s);
                    set.remove(s);
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> neighbours(String node,HashSet<String> set){
        List<String> list=new ArrayList<>();
        char[] node_chars=node.toCharArray();
        for(int i=0;i<node_chars.length;i++){
            char original=node_chars[i];
            for(char ch='a';ch<='z';ch++){
                node_chars[i]=ch;
                String new_word=String.valueOf(node_chars);
                if(set.contains(new_word)) list.add(new_word);
            }
            node_chars[i]=original;
        }
        return list;
    }
}