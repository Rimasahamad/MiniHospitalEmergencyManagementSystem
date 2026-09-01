public class EmergencyQueue {

    PatientNode front;
    PatientNode rear;


    public EmergencyQueue() {
        front = null;
        rear = null;
    }


    // Add patient to queue
    public void enqueue(Patient patient) {

        PatientNode newNode = new PatientNode(patient);


        if (rear == null) {

            front = rear = newNode;

        } else {

            rear.right = newNode;
            rear = newNode;

        }

        System.out.println("Patient added to emergency queue");
    }



    // Remove patient from queue
    public Patient dequeue() {

        if (front == null) {

            System.out.println("Emergency queue is empty");
            return null;

        }


        Patient patient = front.patient;

        front = front.right;


        if (front == null) {
            rear = null;
        }


        return patient;
    }



    // Display waiting patients
    public void displayQueue() {

        if (front == null) {

            System.out.println("No patients waiting");

            return;
        }


        PatientNode current = front;


        System.out.println("Emergency Waiting Patients:");

        while(current != null) {

            current.patient.displayPatient();

            current = current.right;
        }
    }
}