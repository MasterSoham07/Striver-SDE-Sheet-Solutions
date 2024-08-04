// Brute force any of the sorting algorithms

// Better solution

// public class Sort0s1s2s {
//     public void sortColors(int[] nums) {
//         int cnt0 = 0, cnt1 = 0, cnt2 = 0;

//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] == 0) cnt0++;
//             else if(nums[i] == 1) cnt1++;
//             else cnt2++;
//         }

//         for(int i = 0; i < cnt0; i++){
//             nums[i] = 0;
//         }

//         for(int i = cnt0; i < cnt0 + cnt1; i++){
//             nums[i] = 1;
//         }

//         for(int i = cnt0 + cnt1; i < nums.length; i++){
//             nums[i] = 2;
//         }
//     }

//     public static void main(String[] args) {
//         Sort0s1s2s obj = new Sort0s1s2s();
//         int[] nums = {1, 0, 2, 1, 1, 0, 0, 2, 1, 0};
//         obj.sortColors(nums);
//         for(int i = 0; i < nums.length; i++){
//             System.out.print(nums[i] + " ");
//         }
//     }
// }

// Optimal Solution

public class Sort0s1s2s {

    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int mid = 0, low = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            }

            else if (nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Sort0s1s2s obj = new Sort0s1s2s();
        int[] nums = { 1, 0, 2, 1, 1, 0, 0, 2, 1, 0 };
        obj.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}