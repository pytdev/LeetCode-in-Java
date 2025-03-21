package g0201_0300.s0242_valid_anagram;

// #Easy #String #Hash_Table #Sorting #Data_Structure_I_Day_6_String
// #Programming_Skills_I_Day_11_Containers_and_Libraries #Udemy_Strings #Top_Interview_150_Hashmap
// #2025_03_09_Time_2_ms_(97.76%)_Space_43.41_MB_(66.14%)

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charFreqMap = new int[26];
        for (char c : s.toCharArray()) {
            charFreqMap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (charFreqMap[c - 'a'] == 0) {
                return false;
            }
            charFreqMap[c - 'a']--;
        }
        return true;
    }
}
