import java.util.ArrayList;
import java.util.List;

public class HospitalPatientManagement{
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient("P001", "Alice", 30, 5, 2000);
        Patient p2 = new OutPatient("P002", "Bob", 45, 700);

        // Add patients to list
        patients.add(p1);
        patients.add(p2);

        // Add medical records (via interface)
        if (p1 instanceof MedicalRecord) {
            ((MedicalRecord) p1).addRecord("Appendicitis - Surgery performed.");
        }

        if (p2 instanceof MedicalRecord) {
            ((MedicalRecord) p2).addRecord("Seasonal flu - Medication prescribed.");
        }

        // Display details and bill (Polymorphism)
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Medical History: " + ((MedicalRecord) patient).viewRecords());
            System.out.println("Total Bill: ₹" + patient.calculateBill());
            System.out.println("-----------------------------------");
        }
    }
}
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation: Getters
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Medical history (protected via method access)
    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory); // Defensive copy
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    public abstract double calculateBill();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomChargePerDay;
    private List<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 1500; // flat service charge
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

