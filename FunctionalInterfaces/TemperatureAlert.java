import java.util.function.Predicate;

public class TemperatureAlert {

    public static void main(String[] args) {
        double threshold = 30.0;  

        
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        
        double[] temperatures = {25.5, 29.9, 30.0, 32.5, 40.0};

        System.out.println("=== Temperature Alert System ===");
        for (double temp : temperatures) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT 🚨: Temperature " + temp + "°C exceeds threshold " + threshold + "°C!");
            } else {
                System.out.println("OK ✅: Temperature " + temp + "°C is within safe limits.");
            }
        }
    }
}
