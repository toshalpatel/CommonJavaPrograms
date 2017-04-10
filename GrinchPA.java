import java.util.Arrays;

public class GrinchPA {
    int array[];
    int len;
    
    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0)
            return;
            
        this.array = inputArr;
        len = inputArr.length;
        quickSort(0, len - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {
            while (array[i] < pivot) {
                    i++;
            }
            while (array[j] > pivot) {
                    j--;
            }
            if (i <= j) {
                    swap(i, j);

                    i++;
                    j--;
            }
        }
        if (lowerIndex < j)
                quickSort(lowerIndex, j);
        if (i < higherIndex)
                quickSort(i, higherIndex);
    }

    private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }

    public void balance(int[] input) {
        int teamA[] = new int[len/2], teamB[] = new int[len/2];
        int sum1 = 0, sum2 = 0;

        int i, m = 0, n = len - 1;

        for(i = 0; i < len/2; i++) {
            teamA[i] = 0;
            teamB[i] = 0;
        }
        
        for(i = 0; i < len/2; i++) {
            teamA[i] = input[m];
            sum1 = sum1 + input[m];
            m++;
            
            teamB[i] = input[n];
            sum2 = sum2 + input[n];
            n--;
        }
        
        System.out.println("Imbalanced partition is as follows - ");
        System.out.println("\tTeam A - " + Arrays.toString(teamA) + "\n\tSum = " + sum1);
        System.out.println("\n\tTeam B - " + Arrays.toString(teamB) + "\n\tSum = " + sum2);
    }
    
    public static void main(String[] args) {
        int input[] = {3,5,8,1,3,9,7,11,100,74,83,65};
        System.out.println("Input array - " + Arrays.toString(input) + "\n");
        
        PartA a = new PartA();
        a.sort(input);
        System.out.println("Sorted array - " + Arrays.toString(input) + "\n");
        a.balance(input);
    }
}
