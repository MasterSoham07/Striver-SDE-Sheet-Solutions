// Brute force

// public class KadanesAlgorithm {
//     public int maxSubArray(int[] nums) {
//         int maxi = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++){
//             for(int j = i; j < nums.length; j++){
//                 int sum = 0;
//                 for(int k = i; k < j; k++){
//                     sum = sum + nums[k];
//                 }
//                 maxi = Math.max(maxi, sum);
//             }
//         }   

//         return maxi;
//     }

//     public static void main(String[] args) {
//         KadanesAlgorithm obj = new KadanesAlgorithm();
//         int[] nums = {-1, 2, 3, -1, 5, -2, -1};
//         System.out.println(obj.maxSubArray(nums));
//     }
// }


// Better Approach

// public class KadanesAlgorithm{
//     public int maxSubArray(int nums[]){
//         int maxi = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++){
//             int sum = 0;
//             for(int j = i; j < nums.length; j++){
//                 sum = sum + nums[j];
//                 maxi = Math.max(maxi, sum);
//             }
//         }

//         return maxi;
//     }

//     public static void main(String[] args) {
//         KadanesAlgorithm obj = new KadanesAlgorithm();
//         int[] nums = {-1, 2, 3, -1, 5, -2, -1};
//         System.out.println(obj.maxSubArray(nums));
//     }
// }

// Optimal Solution (Kadanes Algorithm)


// public class KadanesAlgorithm{
//     public int maxSubArray(int nums[]){
//         int maxi = Integer.MIN_VALUE;
//         int sum = 0;

//         for(int i = 0; i < nums.length; i++){
//             sum = sum + nums[i];
//             maxi = Math.max(maxi, sum);

//             if(sum < 0){
//                 sum = 0;
//             }
//         }

//         return maxi;
//     }

//     public static void main(String[] args) {
//         KadanesAlgorithm obj = new KadanesAlgorithm();
//         int[] nums = {-1, 2, 3, -1, 5, -2, -1};
        
//         System.out.println(obj.maxSubArray(nums));
//     }
// }

// Follow up (also print the subarray with max sum)

public class KadanesAlgorithm{
    public int maxSubArray(int nums[]){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for(int i = 0; i < nums.length; i++){
            if(sum == 0) start = i;
            sum = sum + nums[i];

            if(sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        System.out.print("The subarray is: [");

        for(int i = ansStart; i <= ansEnd; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        return maxi;
    }

    public static void main(String[] args) {
        KadanesAlgorithm obj = new KadanesAlgorithm();
        int[] nums = {-1, 2, 3, -1, 5, -2, -1};
        System.out.println("The subarray sum is: " + obj.maxSubArray(nums));
    }
}