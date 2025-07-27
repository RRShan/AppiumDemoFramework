public class ReverseString {
    public static void main(String[] args) {
        String word = "I Am Anuradha";
        char[] ch = word.toCharArray();  // Correct way to get characters from the string
        String rev = " ";

        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];  // Append characters in reverse order
        }

        System.out.println(rev);
    }
}
