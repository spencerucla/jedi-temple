public class Solution {
    public static boolean permutationPalindrome(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)-'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1)
                oddCount++;
        }
        return oddCount < 2;
    }

    public static void main(String[] args) {
        System.out.println(permutationPalindrome("civic"));
        System.out.println(permutationPalindrome("ivicc"));
        System.out.println(permutationPalindrome("civil"));
        System.out.println(permutationPalindrome("livci"));
    }
}
