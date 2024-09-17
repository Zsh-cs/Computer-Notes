package Sort.src;/*
希尔排序（Shell Sort）：
·名称源自于它的发明者Donald Shell
·它通过相距一定间隔的元素来工作，
 各轮次对比所用的距离会随着算法的进行而逐渐减小，
 直到走到只对比相邻元素的最后一轮排序为止。
 因此，它也叫做缩减增量排序（Diminishing Increament Sort）。
·希尔排序是插入排序的升级版
 */

import java.util.Arrays;

public class ShellSort extends Analyze{
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

        //核心逻辑：3个for循环嵌套
        for (int gap = data.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <data.length ; i++) {
                for (int j = i; j >=gap; j-=gap) {
                    if(data[j]<data[j-gap]){
                        swap(data,j,j-gap);
                        compareCount++;
                        swapCount++;
                    }else {
                        compareCount++;
                        break;
                    }
                }
            }
        }

        //将排序好的数组打印出来
        System.out.println("希尔排序："+ Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }
}
