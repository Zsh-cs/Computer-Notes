package Sort.src;

import java.util.Arrays;
import java.util.Random;

public abstract class Analyze {
    public static int totalCompareCount;//记录总的对比次数
    public static int totalCount;//记录总的换位次数
    public static double averageCompareCount;//平均对比次数
    public static double averageCount;//平均换位次数
    public static int runtimes;//记录运行次数

    /*共用的方法结构*/
    public final void analyze(){
        //预定义变量
        int[] data=new int[Constants.DATA_SIZE];
        //初始化类变量
        runtimes=0;
        totalCompareCount=0;
        totalCount=0;

        //开始测量时间
        long startTime=System.nanoTime();
        //循环体
        while (runtimes< Constants.RUN_TIMES) {
            runtimes++;
            System.out.println("****第"+runtimes+"次****");

            //此处交给子类进行重写
            sort();

        }
        //结束测量时间
        long endTime=System.nanoTime();

        //计算平均运行时间
        double duration=(double) (endTime-startTime)/(1000000* Constants.RUN_TIMES);

        //计算平均对比次数和平均换位次数
        averageCompareCount=(double) totalCompareCount/ Constants.RUN_TIMES;
        averageCount=(double) totalCount/ Constants.RUN_TIMES;

        //打印分析结果
        System.out.println("平均对比次数："+averageCompareCount);
        System.out.println("平均换位次数："+averageCount);
        System.out.println("平均运行时间："+duration+"s");
        System.out.println("********************************************************");
    }

    /*生成一个长度为DATA_SIZE的不重复随机数组，随机数的范围为[1,BOUND]*/
    public static int[] createData(int[] data){
        //获取随机对象
        Random random=new Random();
        //核心逻辑
        for (int i = 0; i < data.length;) {
            //生成一个随机数，赋值给num变量
            int num=random.nextInt(Constants.BOUND)+1;
            //默认tag为true，如果找到重复的随机数，就将tag改为false
            boolean tag=true;
            for (int j = 0; j < i; j++) {
                if(data[j]==num){
                    tag=false;
                }
            }
            //如果循环执行完毕后，tag仍为true，再最终把num赋值给数组元素
            if(tag){
                data[i]=num;
                i++;
            }
        }
        //返回生成的不重复随机数组
        return data;
    }

    /*抽象方法，由子类进行重写*/
    public abstract void sort();

    /*交换两个元素*/
    public static void swap(int[] data,int a,int b){
        int temp=data[a];
        data[a]=data[b];
        data[b]=temp;
    }

    /*打印每次运行的结果*/
    public static void printRunningResult(int compareCount,int swapCount){
        System.out.println("对比次数："+compareCount);
        System.out.println("换位次数："+swapCount);
        System.out.println("------------------------------------------");
        totalCompareCount+=compareCount;
        totalCount+=swapCount;
    }
}
