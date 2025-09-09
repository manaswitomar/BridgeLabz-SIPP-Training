
@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHomeLighting {

    public static void main(String[] args) {

        LightAction motionTrigger = () -> System.out.println("Motion detected → Turning ON hallway lights.");

        LightAction timeOfDayTrigger = () -> System.out.println("It's evening → Dimming living room lights to 50%.");

        LightAction voiceCommandTrigger = () -> System.out
                .println("Voice command 'Good Night' → Turning OFF all lights.");

        System.out.println("=== Smart Home Lighting Automation ===");

        motionTrigger.execute();

        timeOfDayTrigger.execute();

        voiceCommandTrigger.execute();
    }
}
