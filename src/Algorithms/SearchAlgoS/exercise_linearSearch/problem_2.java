package Algorithms.SearchAlgoS.exercise_linearSearch;

//Given a list of Employee Ids, check whether an Employee Id is present or not using Linear Search algorithm.
// If the Employee Id is found, return the number of iterations used for searching the Employee Id, else return -1.
// Implement the logic in searchEmployeeId() method.

public class problem_2 {
    public static int searchEmployeeId(int employeeIds[], int elemToBeSearched) {


        for (int index = 0; index < employeeIds.length; index++) {
            if (employeeIds[index] == elemToBeSearched) {
                return index+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {


        int[] employeeIds = {8011, 8012, 8015, 8016, 8020, 8022, 8025};
        int employeeIdToBeSearched = 8022;

        int numberOfIterations = searchEmployeeId(employeeIds, employeeIdToBeSearched);

        if (numberOfIterations == -1) {
            System.out.println("Employee Id " + employeeIdToBeSearched + " is not found!");
        } else {
            System.out.println("Employee Id " + employeeIdToBeSearched + " is found! Number of iterations : " + numberOfIterations);
        }
    }
}
