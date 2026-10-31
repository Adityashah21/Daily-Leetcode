import java.util.HashMap;

class Solution {
public boolean checkInclusion(String s1, String s2) {
if (s1.length() > s2.length()) {
return false;
}

    HashMap<Character, Integer> map = new HashMap<>();

    // Count characters in s1
    for (char ch : s1.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    int windowSize = s1.length();
    int left = 0;

    // Store the frequencies of the current window
    HashMap<Character, Integer> window = new HashMap<>();

    for (int right = 0; right < s2.length(); right++) {
        char ch = s2.charAt(right);

        window.put(ch, window.getOrDefault(ch, 0) + 1);

        // Keep the window size equal to s1.length()
        if (right - left + 1 > windowSize) {
            char outgoing = s2.charAt(left);

            window.put(outgoing, window.get(outgoing) - 1);

            if (window.get(outgoing) == 0) {
                window.remove(outgoing);
            }

            left++;
        }

        // Compare the character frequencies
        if (window.equals(map)) {
            return true;
        }
    }

    return false;
}


}
