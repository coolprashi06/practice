public class GCDOfArrayofNumbers {

    private static int computeGCD(int leastDiff, int arr[]){
        if(leastDiff == 1){
            return leastDiff;
        }

        int i = 0;
        while (i < arr.length){
            if(arr[i] % leastDiff != 0){
                return computeGCD(arr[i] % leastDiff, arr);
            }
            i++;
        }
        return leastDiff;
    }

    private static int findLeastDifference(int[] arr , int size){
        int diff = Integer.MAX_VALUE;

        for (int i=0; i<size-1; i++){
            for (int j=i+1; j<size; j++){
                if (Math.abs((arr[i] - arr[j]) )< diff)
                    diff = Math.abs((arr[i] - arr[j]));
            }
        }
        return diff;
    }


    public static void main(String[] args)
    {
        int arr[] = { 8, 20, 28, 44 };
        int n = arr.length;
        System.out.println(findLeastDifference(arr, n));
        System.out.println(computeGCD(findLeastDifference(arr, n), arr));
    }
}
