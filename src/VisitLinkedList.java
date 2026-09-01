public class VisitLinkedList {


    class VisitNode {

        Visit visit;
        VisitNode next;


        VisitNode(Visit visit) {

            this.visit = visit;
            this.next = null;
        }
    }


    VisitNode head;


    public VisitLinkedList() {

        head = null;
    }



    // Add visit
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);


        if(head == null) {

            head = newNode;

        } else {

            VisitNode current = head;


            while(current.next != null) {

                current = current.next;
            }


            current.next = newNode;
        }


        System.out.println("Visit added successfully");
    }



    // Display visit history
    public void displayVisits() {


        if(head == null) {

            System.out.println("No visit history");

            return;
        }


        VisitNode current = head;


        System.out.println("Patient Visit History:");


        while(current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }



    // Search visit
    public Visit searchVisit(int id) {


        VisitNode current = head;


        while(current != null) {


            if(current.visit.visitId == id) {

                return current.visit;
            }


            current = current.next;
        }


        return null;
    }



    // Remove visit
    public void removeVisit(int id) {


        if(head == null) {

            return;
        }


        if(head.visit.visitId == id) {

            head = head.next;

            return;
        }


        VisitNode current = head;


        while(current.next != null) {


            if(current.next.visit.visitId == id) {

                current.next = current.next.next;

                return;
            }


            current = current.next;
        }
    }
}