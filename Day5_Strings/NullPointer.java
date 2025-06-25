
public class NullPointer {
    public static String generateNullPointerException() {
        String text = NullPointer.generateNullPointerException();
        int length = text.length(); 
        System.out.println("Length: " + length); 
    }
    public static void handleNullPointerException() {
        String text = null;
        try {
            int length = text.length(); 
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println( e.getMessage());
        } catch (RuntimeException e) {
            System.out.println( e.getMessage());
        }
    }
    public static void main(String[] args) {

        System.out.println("--- Generating Unhandled NullPointerException ---");
        try {
            generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Program crashed due to unhandled exception: " + e);}
        System.out.println("\n--- Handling NullPointerException with Try-Catch ---");
        handleNullPointerException();
    }
}
