package s0044_wildcard_matching;

public class Solution {
    public boolean isMatch(String inputString, String pattern) {
        int i = 0;
        int j = 0;
        int starIdx = -1;
        int lastMatch = -1;

        while (i < inputString.length()) {
            if (j < pattern.length()
                    && (inputString.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pattern.length() && pattern.charAt(j) == '*') {
                starIdx = j;
                lastMatch = i;
                j++;
            } else if (starIdx != -1) {
                // there is a no match and there was a previous star, we will reset the j to indx
                // after star_index
                // lastMatch will tell from which index we start comparing the string if we
                // encounter * in pattern
                j = starIdx + 1;
                lastMatch++; // we are saying we included more characters in * so we incremented the
                // index
                i = lastMatch;

            } else {
                return false;
            }
        }
        boolean isMatch = true;
        while (j < pattern.length() && pattern.charAt(j) == '*') j++;

        if (i != inputString.length() || j != pattern.length()) isMatch = false;

        return isMatch;
    }
}
