class Solution {

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        // Step 1: Remove extra spaces
        int index = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (arr[i] != ' ') {

                if (index > 0) {
                    arr[index++] = ' ';
                }

                while (i < n && arr[i] != ' ') {
                    arr[index++] = arr[i++];
                }
            }
        }

        // Step 2: Reverse the complete valid part
        reverse(arr, 0, index - 1);

        // Step 3: Reverse every individual word
        int start = 0;

        for (int i = 0; i <= index; i++) {

            if (i == index || arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }

        return new String(arr, 0, index);
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}