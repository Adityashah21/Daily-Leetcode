class Solution {
    public int minAddToMakeValid(String s) {

        int balance = 0;
        int additions = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    additions++;
                }
            }
        }

        return additions + balance;
    }
}