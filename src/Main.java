import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        VisitLinkedList visitList = new VisitLinkedList();


        while (true) {

            System.out.println("\n===== Mini Hospital Emergency Management System =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");

            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Patient");

            System.out.println("7. Add Treatment Record");
            System.out.println("8. View Treatment History");

            System.out.println("9. Add Patient Visit");
            System.out.println("10. View Patient Visits");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();


            switch(choice) {


                case 1:

                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();


                    Patient patient = new Patient(id, name, age, contact, condition);

                    bst.insert(patient);

                    System.out.println("Patient registered successfully");

                    break;



                case 2:

                    System.out.print("Enter Patient ID to search: ");

                    int searchID = scanner.nextInt();

                    Patient found = bst.search(searchID);


                    if(found != null){

                        found.displayPatient();

                    }else{

                        System.out.println("Patient not found");

                    }

                    break;



                case 3:

                    System.out.print("Enter Patient ID to delete: ");

                    int deleteID = scanner.nextInt();

                    bst.delete(deleteID);

                    System.out.println("Patient deleted");

                    break;



                case 4:

                    bst.inorder();

                    break;



                case 5:

                    System.out.print("Enter Patient ID: ");

                    int queueID = scanner.nextInt();

                    Patient queuePatient = bst.search(queueID);


                    if(queuePatient != null){

                        queue.enqueue(queuePatient);

                    }else{

                        System.out.println("Patient not found");

                    }

                    break;



                case 6:

                    Patient treated = queue.dequeue();


                    if(treated != null){

                        treated.displayPatient();

                    }

                    break;



                case 7:

                    System.out.print("Enter Patient ID for treatment record: ");

                    int treatmentID = scanner.nextInt();

                    Patient treatmentPatient = bst.search(treatmentID);


                    if(treatmentPatient != null){

                        stack.push(treatmentPatient);

                    }else{

                        System.out.println("Patient not found");

                    }

                    break;



                case 8:

                    stack.displayStack();

                    break;



                case 9:

                    System.out.print("Enter Visit ID: ");
                    int visitID = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String treatment = scanner.nextLine();


                    Visit visit = new Visit(
                            visitID,
                            date,
                            doctor,
                            diagnosis,
                            treatment
                    );


                    visitList.addVisit(visit);

                    break;



                case 10:

                    visitList.displayVisits();

                    break;



                case 0:

                    System.out.println("Thank you");

                    scanner.close();

                    return;



                default:

                    System.out.println("Invalid choice");

            }
        }
    }
}