class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add(null);

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            String word = q.poll();

            if (word == null) {
                level++;

                if (!q.isEmpty()) {
                    q.add(null);
                }

                continue;
            }

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] chars = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {

                    chars[i] = c;

                    String nextWord = new String(chars);

                    if (words.contains(nextWord) && !vis.contains(nextWord)) {
                        vis.add(nextWord);
                        q.offer(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}