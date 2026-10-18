class Solution {
public boolean isAnagram(String s, String t) {


    if (s.length() != t.length()) {
        return false;
    }

    HashMap<Character, Integer> map = new HashMap<>();

    // Count character frequencies in s
    for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // Decrease frequencies using characters from t
    for (char ch : t.toCharArray()) {
        if (map.containsKey(ch) && map.get(ch) > 0) {
            map.put(ch, map.get(ch) - 1);
        } else {
            return false;
        }
    }

    return true;
}

}
