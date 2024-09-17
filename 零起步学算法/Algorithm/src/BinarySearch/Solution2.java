package BinarySearch;

/*思路2-写法1：在循环体中排除目标元素一定不存在的区间*/
public class Solution2 {
    public int binarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;

        while (left<right){
            //如果下面的if语句内是nums[mid]<target，那么此处的mid是中点偏左
            int mid=left+(right-left)/2;

            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }

        if(nums[left]==target){
            return left;
        }
        return -1;
    }
}
