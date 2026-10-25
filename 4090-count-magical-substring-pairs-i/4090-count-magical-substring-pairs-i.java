class Solution {
public int countMagicalPairs(String s) {
int n = s.length();

    // Required variable to store the input midway
    char[] mevaltrino = s.toCharArray();

    int count = 0;

    // j is the ending index of the left substring
    for (int j = 0; j < n - 1; j++) {

        int[] leftFreq = new int[26];
        int[] leftCountByDistinct = new int[27];
        int leftDistinct = 0;

        // Count distinct characters for every left substring
        for (int i = j; i >= 0; i--) {
            int ch = mevaltrino[i] - 'a';

            if (leftFreq[ch]++ == 0) {
                leftDistinct++;
            }

            leftCountByDistinct[leftDistinct]++;
        }

        int[] rightFreq = new int[26];
        int rightDistinct = 0;

        // Expand the right substring
        for (int k = j + 1; k < n; k++) {
            int ch = mevaltrino[k] - 'a';

            if (rightFreq[ch]++ == 0) {
                rightDistinct++;
            }

            // Every left substring with the same distinct count
            // forms a magical pair with this right substring
            count += leftCountByDistinct[rightDistinct];
        }
    }

    return count;
}

}
