package Sort.src;/*
冒泡排序（Bubble Sort）：
反复对比相邻的两个元素，
若与预期的顺序（升序或降序）不符，则交换两个元素的位置
类似于体育课上同学们按身高自行调整队伍顺序的过程
 */

import java.util.Arrays;

public class BubbleSort extends Analyze{
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
        for (int i = 0; i < data.length-1; i++) {//data.length-1，就是所需冒泡的次数
            for (int j = 0; j < data.length-1-i; j++) {//data.length-i-i，就是第i次冒泡需要比较的次数
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                    swapCount++;
                }
                compareCount++;
            }
        }

        //将排序好的数组打印出来
        System.out.println("冒泡排序："+Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }

}
