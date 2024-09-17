# Binary Search:二分查找

#### 1.算法思想：减而治之

在循环的每一轮中排除掉一定不存在目标元素的区间，在剩下的可能存在目标元素的区间里继续查找

#### 2.应用范围：

- 在**有序数组**中查找一个元素，返回该元素在数组中的下标
- 在整数范围内查找一个整数

#### 3.思路（2种）：

- 在循环体中查找元素
- 在循环体中排除目标元素一定不存在的区间

#### 4.代码：

`Test`:

```java
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
```



`Solution1`:

```java
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
```



`Solution2`:

```java
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
```



`Solution3`:

```java
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
```