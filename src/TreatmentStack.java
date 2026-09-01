public class TreatmentStack {

    PatientNode top;


    public TreatmentStack() {
        top = null;
    }


    // Add completed treatment
    public void push(Patient patient) {

        PatientNode newNode = new PatientNode(patient);

        newNode.right = top;

        top = newNode;

        System.out.println("Treatment record added");
    }



    // Remove most recent treatment
    public Patient pop() {

        if (top == null) {

            System.out.println("Treatment history is empty");
            return null;

        }


        Patient patient = top.patient;

        top = top.right;


        return patient;
    }



    // Display treatment records
    public void displayStack() {

        if (top == null) {

            System.out.println("No treatment records");

            return;
        }


        PatientNode current = top;


        System.out.println("Treatment History:");


        while(current != null) {

            current.patient.displayPatient();

            current = current.right;
        }
    }
}