package Sort.src;/*
插入排序（Insertion Sort）：
假定第1个元素是最小的，
从第2个元素开始，依次将元素插入到它应放置的位置
类似于玩扑克牌时整理手上的扑克牌
提示：暂未参与排序的元素，可视为玩扑克牌时仍放在桌上未抓取的扑克牌
 */

import java.util.Arrays;

public class InsertionSort extends Analyze{
    //以下定义的2个变量用于评测排序算法的效率
    //用于记录对比次数
    public static int compareCount;
    //用于记录交换位置的次数
    public static int swapCount;

    /*由子类重写父类Analyze的sort()方法*/
    @Override
    public void sort(){
        //预定义变量
        int[] data=new int[Constants.DATA_SIZE];
        createData(data);
        System.out.println("初始数组："+ Arrays.toString(data));
        compareCount=0;
        swapCount=0;

        //核心逻辑
        for (int i = 1; i < data.length; i++) {
            int j=i;
            while (j>0){
                if(data[j]<data[j-1]){
                    swap(data,j,j-1);
                    j--;
                    compareCount++;
                    swapCount++;
                }else {
                    compareCount++;
                    break;
                }
            }
        }

        //将排序好的数组打印出来
        System.out.println("插入排序："+ Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }
}
