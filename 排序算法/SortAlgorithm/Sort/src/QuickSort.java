import java.util.Arrays;

public class QuickSort extends Analyze{
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


        //将排序好的数组打印出来
        System.out.println("插入排序："+ Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }
}
