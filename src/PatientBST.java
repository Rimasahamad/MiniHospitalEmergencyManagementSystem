public class PatientBST {

    PatientNode root;

    public PatientBST() {
        root = null;
    }

    // Insert patient
    public void insert(Patient patient) {
        root = insertPatient(root, patient);
    }

    private PatientNode insertPatient(PatientNode root, Patient patient) {

        if (root == null) {
            return new PatientNode(patient);
        }

        if (patient.patientId < root.patient.patientId) {
            root.left = insertPatient(root.left, patient);
        } 
        else if (patient.patientId > root.patient.patientId) {
            root.right = insertPatient(root.right, patient);
        }

        return root;
    }


    // Search patient
    public Patient search(int id) {
        PatientNode result = searchPatient(root, id);

        if (result != null) {
            return result.patient;
        }

        return null;
    }


    private PatientNode searchPatient(PatientNode root, int id) {

        if (root == null || root.patient.patientId == id) {
            return root;
        }

        if (id < root.patient.patientId) {
            return searchPatient(root.left, id);
        }

        return searchPatient(root.right, id);
    }


    // Display patients in ascending order
    public void inorder() {
        inorderTraversal(root);
    }


    private void inorderTraversal(PatientNode root) {

        if (root != null) {

            inorderTraversal(root.left);

            root.patient.displayPatient();

            inorderTraversal(root.right);
        }
    }
    // Delete patient
public void delete(int id) {
    root = deletePatient(root, id);
}


private PatientNode deletePatient(PatientNode root, int id) {

    if (root == null) {
        return null;
    }


    if (id < root.patient.patientId) {

        root.left = deletePatient(root.left, id);

    } 
    else if (id > root.patient.patientId) {

        root.right = deletePatient(root.right, id);

    } 
    else {

        // No child
        if (root.left == null && root.right == null) {
            return null;
        }

        // One right child
        else if (root.left == null) {
            return root.right;
        }

        // One left child
        else if (root.right == null) {
            return root.left;
        }

        // Two children
        else {

            PatientNode successor = findMinimum(root.right);

            root.patient = successor.patient;

            root.right = deletePatient(root.right, successor.patient.patientId);
        }
    }

    return root;
}


private PatientNode findMinimum(PatientNode root) {

    while(root.left != null) {
        root = root.left;
    }

    return root;
}
}