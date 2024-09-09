package misc;

class StringCompression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        String compressed = compressString(input);
        System.out.println("Compressed string: " + compressed);
    }

    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different, append the current character and count to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0; // Reset count
            }
        }

        // If the compressed string is not smaller than the original, return the original
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
