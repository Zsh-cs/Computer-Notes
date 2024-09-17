package BinarySearch;

/*LeetCode-704：二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
示例 1:
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

示例 2:
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1

提示：
你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
 */

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println("int[] nums="+Arrays.toString(nums));
        int target=9;
        System.out.println("target:"+target);

        Solution1 s1=new Solution1();
        System.out.println("Solution1:"+s1.binarySearch(nums, target));
        Solution2 s2=new Solution2();
        System.out.println("Solution2:"+s2.binarySearch(nums, target));
        Solution3 s3=new Solution3();
        System.out.println("Solution3:"+s3.binarySearch(nums, target));
    }
}
