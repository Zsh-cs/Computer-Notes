package BinarySearch;

/*思路1：在循环体中查找元素*/
public class Solution1 {
    public int binarySearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            //不推荐写法：int mid=(left+right)/2;
            //理由：left+right可能数值太大导致内存溢出

            //如果mid对应元素小于目标元素，那么目标元素只存在于区间[mid+1,right]
            //所以应该将left移动到mid+1的位置
            if(nums[mid]<target){
                left=mid+1;
            }
            //如果mid对应元素刚好等于目标元素，那么直接返回mid
            else if (nums[mid]==target) {
                return mid;
            }
            //如果mid对应元素大于目标元素，那么目标元素只存在于区间[left,mid-1]
            //所以应该将right移动到mid-1的位置
            else{
                right=mid-1;
            }
        }

        //如果经历完上述循环后，仍然没有找到目标元素，说明目标元素不存在于该数组中，那么返回-1
        return -1;
    }
}
