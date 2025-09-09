public class Palindrome {

    private String text;
    public Palindrome(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Palindrome checker1 = new Palindrome("Madam");
        Palindrome checker2 = new Palindrome("Hello");
        Palindrome checker3 = new Palindrome("A man, a plan, a canal, Panama");

        checker1.displayResult();
        checker2.displayResult();
        checker3.displayResult();
    }
}

