import java.util.*;

class GfG {

    // Function to print permutations of the string
    // This function takes two parameters:
    // 1. String
    // 2. Starting index of the string.
    static void permuteRec(StringBuilder s, int idx) {
      
        // Base case
        if (idx == s.length() - 1) {
            System.out.println(s);
            return;
        }

        for (int i = idx; i < s.length(); i++) {
          
            // Swapping 
            swap(s, idx, i);

            // First idx+1 characters fixed
            permuteRec(s, idx + 1);

            // Backtrack
            swap(s, idx, i);
        }
    }

    // Wrapper function
    static void permute(String s) {
        permuteRec(new StringBuilder(s), 0);
    }

    // Helper function to swap characters in the StringBuilder
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s);
    }
}
