class Solution {
    class Pair{
        String movie;
        int frq;
        public Pair(String movie, int frq){
            this.movie = movie;
            this.frq = frq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] visit = new boolean[friends.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visit[id] = true;
        while(level != 0){
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                int nd = queue.poll();
                for(int frd : friends[nd]){
                    if(!visit[frd]){
                        queue.add(frd);
                        visit[frd] = true;
                    }
                }
            }
            level--;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int que: queue){
            for(String movie: watchedVideos.get(que)){
                map.put(movie, map.getOrDefault(movie, 0) + 1);
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for(String movie : map.keySet()){
            pairs.add(new Pair(movie, map.get(movie)));
        }

        pairs.sort((a, b) -> {
            if (a.frq != b.frq) {
                return a.frq - b.frq;
            } else return a.movie.compareTo(b.movie);
        });

        List<String> result = new ArrayList<>();
        for(Pair pair : pairs) result.add(pair.movie);

        return result;
    }
}