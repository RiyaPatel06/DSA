class Solution {
    
    private int squareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {

            slow = squareSum(slow);              // 1 step

            fast = squareSum(squareSum(fast));   // 2 steps

        } while (slow != fast);

        return slow == 1;
    }
    
}