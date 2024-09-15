import java.util.Arrays;

public class MergeSort extends Analyze{
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
        data=mergeSort(data,0,data.length-1);

        //将排序好的数组打印出来
        System.out.println("归并排序："+ Arrays.toString(data));
        printRunningResult(compareCount,swapCount);
    }

    /**
     * @param data   待处理的数组
     * @param start  需要被拆分的区间的头元素的下标
     * @param end    需要被拆分的区间的尾元素的下标
     */
    public static int[] mergeSort(int[] data,int start,int end) {
        //若初始数组的长度只有1，那么我们无需对其进行归并排序，直接返回原数组回去
        if(end==start){
            return new int[] {data[start]};//该数组中只存放了1个元素，即data[start]
        }

        //若初始数组的长度大于1，我们必须对其进行归并排序，具体过程如下：
        else{
            //1.求需要被拆分的区间的中点
            int mid=start+(end-start)/2;

            //2.创建2个新的数组，分别存放拆分后的左右数组（递归）
            int[] leftData=mergeSort(data,start,mid);
            int[] rightData=mergeSort(data,mid+1,end);

            //3.创建1个新的数组，存放合并后的数组
            int[] mergedData=new int[leftData.length+rightData.length];

            /*4.核心逻辑：分而治之*/

            //4.1  l、r、m分别表示leftData、rightData、mergedData的下标变量
            int l=0,r=0,m=0;

            //4.2  当leftData和rightData都没有遍历结束之前，一直进行循环
            while (l<leftData.length && r<rightData.length){
                //对比2个数组的元素
                if(leftData[l]<rightData[r]){
                    mergedData[m]=leftData[l];//将较小的数字存入到mergedData中去
                    l++;//存入后记得将下标自增，以便进行下一轮对比
                }
                else {
                    mergedData[m]=rightData[r];
                    r++;
                }
                //将mergedData的下标自增，因为在这一轮对比中，该下标对应的位置已有元素存入
                m++;

                //以下代码是对上述if-else语句的高度简化，使用了三元表达式和后置自增，但可读性较差
                //mergedData[m++]=leftData[l]<rightData[r] ? leftData[l++] : rightData[r++];
            }

            //4.3  若左侧数组还有剩余，可依次填充进合并后的数组里
            while (l<leftData.length){
                mergedData[m++]=leftData[l++];
            }

            //4.4  若右侧数组还有剩余，可依次填充进合并后的数组里
            while (r<rightData.length){
                mergedData[m++]=rightData[r++];
            }

            //5.返回合并后的数组
            return mergedData;
        }
    }
}
