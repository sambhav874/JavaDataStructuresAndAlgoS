package Algorithms.MinimumSpanningTreeAlgoS.AlgoSDesignTechniques;
//Given two square matrices, find the product of the two matrices using brute force technique.
// Implement the logic in multiply() method.
public class bruteForce_problem2 {

    public static int[][] multiply(int arr1[][],int arr2[][]) {

        int rows1 = arr1.length;
        int cols1 = arr1[0].length;
        int cols2 = arr2[0].length;

        int arr3[][] = new int[rows1][cols1];

        for(int i = 0 ; i < rows1 ; i++){
            for(int j = 0 ; j < cols2 ; j++){
                for(int k = 0 ; k < cols1 ; k++){
                arr3[i][j]+=arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr3;
    }

    public static void main(String[] args) {
        int arr1[][]=new int [][] {{2,4},{1,4}};
        int arr2[][]=new int [][] {{1,4},{1,3}};

        int[][] arr3=multiply(arr1,arr2);

        for(int index1=0;index1<arr3.length;index1++){
            for(int index2=0;index2<arr3.length;index2++){
                System.out.print(arr3[index1][index2]+" ");
            }
            System.out.println();
        }
    }

}
