package Sort.src;/*
选择排序（Selection Sort）：
将尚未排序的第1个元素和剩余的每个元素依次进行对比，
若与预期的顺序不符，则换位
 */

import java.util.Arrays;

public class SelectionSort extends Analyze{
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
        int min;
        for (int i = 0; i < data.length-1; i++) {
            min=i;
            for (int j = i+1; j < data.length; j++) {
                if(data[j]<data[min]){
                    min=j;
                }
                compareCount++;
            }
            if(min!=i){
                swap(data,min,i);
                swapCount++;
            }
        }

        //将排序好的数组打印出来
        System.out.println("选择排序："+ Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }
}
