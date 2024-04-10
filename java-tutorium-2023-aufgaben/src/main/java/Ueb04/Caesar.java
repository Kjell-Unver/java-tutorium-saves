package Ueb04;

public class Caesar {

    public static void main(String[] args) {
        String original =  "HALLOZ";
        int key = 2;
        String encrypted = caesar(original, key); // "JCNNQB"

        System.out.println(encrypted);
        System.out.println(caesar(encrypted, key, "decrypt"));
    }

    public static String caesar(String input, int key) {
        return caesar(input, key, "encrypt");
    }

    public static String caesar(String input, int key, String mode) {
        String result = "";

        // String buchstaben = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < input.length(); i++) {
            int factor = 1;
            if (mode.equals("decrypt")) factor = -1;
            // result += buchstaben.charAt((buchstaben.indexOf(input.charAt(i)) + key) % buchstaben.length());
            result += (char)((26 + input.charAt(i) - 'A' + key * factor) % 26 + 'A');
        }

        return result;
    }
}
