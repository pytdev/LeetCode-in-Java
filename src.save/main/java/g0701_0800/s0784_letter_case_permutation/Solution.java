package g0701_0800.s0784_letter_case_permutation;

// #Medium #String #Bit_Manipulation #Backtracking

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        helper(s, 0, "");
        return ans;
    }

    public void helper(String s, int curr, String temp) {
        if (curr == s.length()) {
            ans.add(temp);
            return;
        }
        if (Character.isDigit(s.charAt(curr))) {
            helper(s, curr + 1, temp + s.substring(curr, curr + 1));
        } else {
            if (Character.isLowerCase(s.charAt(curr))) {
                helper(s, curr + 1, temp + s.substring(curr, curr + 1));
                helper(s, curr + 1, temp + (s.substring(curr, curr + 1)).toUpperCase());
            } else {
                helper(s, curr + 1, temp + s.substring(curr, curr + 1));
                helper(s, curr + 1, temp + (s.substring(curr, curr + 1)).toLowerCase());
            }
        }
    }
}