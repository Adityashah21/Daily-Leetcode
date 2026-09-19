class Solution {
    public boolean backspaceCompare(String s, String t) {

        int sp = s.length() - 1;
        int tp = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (sp >= 0 || tp >= 0) {

            // Process s
            while (sp >= 0) {
                if (s.charAt(sp) == '#') {
                    skipS++;
                    sp--;
                } else if (skipS > 0) {
                    skipS--;
                    sp--;
                } else {
                    break;
                }
            }

            // Process t
            while (tp >= 0) {
                if (t.charAt(tp) == '#') {
                    skipT++;
                    tp--;
                } else if (skipT > 0) {
                    skipT--;
                    tp--;
                } else {
                    break;
                }
            }

            // One string has a character, other doesn't
            if (sp >= 0 && tp < 0) {
                return false;
            }

            if (sp < 0 && tp >= 0) {
                return false;
            }

            // Compare actual characters
            if (sp >= 0 && tp >= 0) {
                if (s.charAt(sp) != t.charAt(tp)) {
                    return false;
                }

                sp--;
                tp--;
            }
        }

        return true;
    }
}