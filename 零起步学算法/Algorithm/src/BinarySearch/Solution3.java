package BinarySearch;

/*思路2-写法2：在循环体中排除目标元素一定不存在的区间*/
public class Solution3 {
    public int binarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;

        while (left<right){
            //如果下面的if语句内是nums[mid]>target，那么此处的mid是中点偏右
            //注意是(right-left+1)而不是(right-left)!!!
            //否则会进入死循环
            int mid=left+(right-left+1)/2;

            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid;
            }
        }

        if(nums[left]==target){
            return left;
        }
        return -1;
    }
}
