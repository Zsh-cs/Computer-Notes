package Sort.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //输出重定向
//        PrintStream printStream=
//                new PrintStream(
//                        new FileOutputStream("..\\SortAlgorithm\\Sort\\analysis\\doc1.txt"));
//        System.setOut(printStream);


        /*1.冒泡排序*/
        System.out.println("~~~~~~~~冒泡排序~~~~~~~~");
        new BubbleSort().analyze();
        System.out.println();
        System.out.println();

        /*2.选择排序*/
        System.out.println("~~~~~~~~选择排序~~~~~~~~");
        new SelectionSort().analyze();
        System.out.println();
        System.out.println();

        /*3.插入排序*/
        System.out.println("~~~~~~~~插入排序~~~~~~~~");
        new InsertionSort().analyze();
        System.out.println();
        System.out.println();

        /*4.希尔排序*/
        System.out.println("~~~~~~~~希尔排序~~~~~~~~");
        new ShellSort().analyze();
        System.out.println();
        System.out.println();

        /*5.归并排序*/
        System.out.println("~~~~~~~~归并排序~~~~~~~~");
        new MergeSort().analyze();
        System.out.println();
        System.out.println();

        /*6.快速排序--暂未完成*/
        System.out.println("~~~~~~~~快速排序~~~~~~~~");
        new QuickSort().analyze();
        System.out.println();
        System.out.println();

    }
}
