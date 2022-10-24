public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 7, 15, 37, 90 };
        System.out.println(search(nums, 123));
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int middle;
        boolean isAsc = arr[start] < arr[end];
        System.out.println(isAsc);
        while (start <= end) {
            middle = start + ((end - start) / 2);
            if (arr[middle] == target) {
                return middle;          // element found
            } else if (arr[middle] > target) {
                end = middle - 1;
            } else if (arr[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;          // element not found
    }
}
