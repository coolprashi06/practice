import java.util.Arrays;

public class FindKthLargest {


    private static void quickSort(Integer[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high){
        //choose pivot element to be the end element
        int pivot = arr[high];
        int pivotPos = high;

        //start with low as first index and high as the second last index
        high--;

        while (true){

            while (arr[low] < pivot){
                //this means it's already less than pivot so move forward
                low++;
            }

            while (high > low && arr[high] > pivot){
                //this means it's already greater than pivot so move backwards
                high--;
            }

            //now swap it because order has to be maintained w.r.t pivot
            swap(arr, low, high);

            //increment low because the element has been swapped and we need to move forward
            low++;

            //we reached to the point where low and high are equal
            if(low >= high){
                //swap the pivot element with the high one and return the high.
                swap(arr, high, pivotPos);
                return high;
            }
        }
    }


    private static void swap(Integer[] arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }


    private static int findKthLargestUsingSort(Integer[] arr, int pos){
        Arrays.sort(arr);

        return arr[pos-1];
    }

    public static void main(String args[]){
        Integer[] arr = new Integer[]{17,41,5,22,54,6,29,3,13};
        int length = arr.length;

        //find nth largest using merge sort provided by java
        System.out.println("3rd largest using merge sort :: " + findKthLargestUsingSort(arr, 3));

        //find nth largest using quick sort
        quickSort(arr,0, length-1);
        //printArray(arr);
        System.out.println("3rd largest using quick sort :: "+ arr[2]);

    }
}
