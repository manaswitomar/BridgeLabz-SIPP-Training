import java.util.ArrayList;

class Patient {
    private String name;
    private ArrayList<Doctor> doctors; // Doctors this patient has consulted

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void showDoctors() {
        System.out.println("Patient " + name + " has consulted:");
        for (Doctor d : doctors) {
            System.out.println("  - Dr. " + d.getName());
        }
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());

        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this);
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  - Dr. " + d.getName());
        }

        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");

        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");

        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");

        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(alice);
        hospital.addPatient(bob);

        hospital.displayInfo();

        System.out.println("\n--- Consultations ---");
        drSmith.consult(alice);
        drSmith.consult(bob);
        drJones.consult(alice);

        System.out.println("\n--- Doctor's Patients ---");
        drSmith.showPatients();
        drJones.showPatients();

        System.out.println("\n--- Patient's Doctors ---");
        alice.showDoctors();
        bob.showDoctors();
    }
}
