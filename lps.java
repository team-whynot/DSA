class Solution {
    public String longestPalindrome(String s) {
        
        String Q = convertToNewString(s);
        int P[] = new int[Q.length()];
        int c = 0, r = 0;    // current center, right limit

        for (int i = 1; i < Q.length() - 1; i++) {
            // find the corresponding letter in the palidrome subString
            int iMirror = 2*c - i;

            if(r > i) {
                P[i] = Math.min(r - i, P[iMirror]);
            }

            // expanding around center i
            while (Q.charAt(i + 1 + P[i]) == Q.charAt(i - 1 - P[i])){
                P[i]++;
            }

            // Update c,r in case if the palindrome centered at i expands past r,
            if (i + P[i] > r) {
                c = i;              // next center = i
                r = i + P[i];
            }
        }
        int maxPalindrome = 0;
        int centerIndex = 0;

        for (int i = 1; i < Q.length() - 1; i++) {

            if (P[i] > maxPalindrome) {
                maxPalindrome = P[i];
                centerIndex = i;
            }
        }
        
        int start = (centerIndex - 1 - maxPalindrome) / 2;
        return s.substring(  start, start+maxPalindrome);
        
        
    }
    // Transform S into new string with special characters inserted.
    public String convertToNewString(String s) {
        String newString = "@";

        for (int i = 0; i < s.length(); i++)
            newString += "#" + s.substring(i, i+1);

        newString += "#$";
        return newString;
    }

}