class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];

        // Count frequency of every character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Current character is no longer remaining
            freq[ch - 'a']--;

            // If already present in stack, skip it
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove bigger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}