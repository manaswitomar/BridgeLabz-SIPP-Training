import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
public class BankingApplication {
    public static void main(String[] args) {
        Path filePath = Path.of("transaction.txt");

        try {
            List<String> lines = Files.lines(filePath).collect(Collectors.toList());
            for (String line : lines) {
                try {
                    Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    throw new InvalidTransactionException("Invalid transaction data: " + line);
                }
            }
             List<Integer> transactions = lines.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int sum = transactions.stream().mapToInt(Integer::intValue).sum();
            int max = transactions.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);

        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        try {
            List<Integer> validTransactions = Files.lines(filePath)
                    .map(String::trim)
                    .filter(line -> line.matches("\\d+")) // keep only numeric lines
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int sum = validTransactions.stream().mapToInt(Integer::intValue).sum();
            int max = validTransactions.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("\n[Skipping invalid lines mode]");
            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

