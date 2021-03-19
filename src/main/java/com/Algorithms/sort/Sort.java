package com.Algorithms.sort;
import java.util.Arrays;

/**
 * 八大排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {9,6,13,10,54,2,33};
        System.out.println("冒泡排序：");
        BubbleSort(arr);
        int[] arr1 = {11,8,13,10,54,2,33};
        System.out.println("选择排序：");
        SelectSort(arr1);
        int[] arr2 = {16,7,13,10,54,2,33};
        System.out.println("插入排序：");
        InsertSort(arr2);
        int[] arr3 = {17,7,13,10,51,2,33};
        System.out.println("快速排序：");
        System.out.println(Arrays.toString(QuickSort(arr3,0,arr.length-1)));
        int[] arr4 = {17,7,13,6,51,1,23};
        System.out.println("归并排序：");
        mergeSort(arr4,0,arr.length-1);
        System.out.println(Arrays.toString(arr4));
        int[] arr5 = {50,10,90,30,70,40,80,60,20};
        System.out.println("堆排序：");
        HeapSort(arr5);
        int[] arr6 = {61,53,19,77,3,4,5};
        System.out.println("希尔排序：");
        shellSort(arr6);
        int[] arr7 = {1,67,77,43,66,21,37,7};
        System.out.println("桶排序(基数排序)：");
        radixSort(arr7);
    }

    /**
     * 冒泡排序
     * 思路：
     *      俩俩交换,大的放在后面,第一次排序后最大值已在数组末尾。
     *      因为俩俩交换,需要n-1趟排序,比如10个数,需要9趟排序
     * @param arr
     */

    public static void BubbleSort(int[] arr) {
        int temp = 0 ;
        //外循环控制趟数
        for (int i = 0; i < arr.length-1; i++) {
            //内循环控制每趟比较个数
            for (int j = 0; j < arr.length - 1 - i; j++) {
               if (arr[j] > arr[j+1]) {
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * 思路：
     *      找到数组中最大的元素,与数组最后一位元素交换。
     *      当只有一个数时,则不需要选择了,因此需要n-1趟排序,比如10个数,需要9趟排序
     * @param arr
     */
    public static void SelectSort(int[] arr) {
        int pos;
        int temp;
        //外层循环控制需要排序的趟数
        for (int i = 0; i < arr.length - 1; i++) {
            pos = 0;
            //内层循环控制遍历数组的个数并得到最大数的角标
            for (int j = 0; j < arr.length - i ; j++) {
                if (arr[j] > arr[pos]) {
                    pos = j;
                }
            }
            temp = arr[pos];
            arr[pos] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * 思路：
     *     将一个元素插入到已有序的数组中,在初始时未知是否存在有序的数据,因此将元素第一个元素看成是有序的
     *     与有序的数组进行比较,比它大则直接放入,比它小则移动数组元素的位置,找到个合适的位置插入
     *     当只有一个数时,则不需要插入了,因此需要n-1趟排序,比如10个数,需要9趟排序
     * @param arr
     */
    public static void InsertSort(int[] arr) {
        //临时变量
        int temp;
        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];

            //如果前一位(已排序的数据)比当前数据要大,那么就进入循环比较[参考第二趟排序]
            while (i >= 1 && arr[i - 1] > temp) {
                //往后退一个位置,让当前数据与之前前位进行比较
                arr[i] = arr[i - 1];
                //不断往前,直到退出循环
                i--;
            }
            //退出了循环说明找到了合适的位置了,将当前数据插入合适的位置中
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 快速排序
     * 思路：
     *      在数组中找一个元素(节点),比它小的放在节点的左边,比它大的放在节点右边。
     *      一趟下来,比节点小的在左边,比节点大的在右边。
     *      循环...
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static int[] QuickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        //节点
        int pivot = arr[(L+R)/2];

        //左右两端进行扫描,只要两端还没有交替,就一直扫描
        while (i <= j) {
            //寻找直到比支点大的数
            while (pivot > arr[i]) {
                i++;
            }
            while (pivot < arr[j]) {
                j--;
            }
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边),它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小,支点的右边比支点大了。
        //“左边”再做排序,直到左边剩下一个数(递归出口)
        if (L < j) {
            QuickSort(arr, L, j);
        }
        //“右边”再做排序,直到右边剩下一个数(递归出口)
        if (i < R) {
            QuickSort(arr, i, R);
        }
        return arr;
    }

    /**
     * 归并排序（二路归并）
     * 思路：
     *      把长度为n的输入序列分成两个长度为n/2的子序列；
     *      对这两个子序列分别采用归并排序；
     *      将两个排序好的子序列合并成一个最终的排序序列。
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static void mergeSort(int[] arr,int L,int R) {
        //如果只有一个元素,那就不用排序了
        if (L == R) {
            return;
        }
        //取中间的数,进行拆分
        int M = (L + R) / 2;
        //左边的数不断进行拆分
        mergeSort(arr, L, M);
        //右边的数不断进行拆分
        mergeSort(arr, M + 1, R);
        //合并
        merge(arr, L, M + 1, R);

    }
    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {
        //左边的数组的大小
        int[] leftArray = new int[M - L];
        //右边的数组大小
        int[] rightArray = new int[R - M + 1];
        //往这两个数组填充数据
        for (int i = L; i <= R; i++) {
            if ( i < M ) {
                leftArray[i - L] = arrays[i];
            }else {
                rightArray[i - M] = arrays[i];
            }
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;
        //比较这两个数组的值,哪个小,就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小,谁将元素放入大数组中,移动指针,继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完,右边的数都已经完了,那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完,左边的数都已经完了,那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }

    /**
     * 希尔排序（缩小增量排序）
     * 思路：
     *      希尔排序实质上就是插入排序的增强版,
     *      希尔排序将数组分隔成n组来进行插入排序,直至该数组宏观上有序,
     *      最后再进行插入排序时就不用移动那么多次位置了～
     * @param arr
     */
    public static void shellSort(int[] arr) {
        //增量每次都/2
        for (int step = arr.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序,直至完毕
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * 思路：
     *      堆排序使用到了完全二叉树的一个特性：
     *      根节点比左孩子和右孩子都要大,完成一次建堆的操作实质上是比较根节点和左孩子、右孩子的大小,
     *      大的交换到根节点上,直至最大的节点在树顶,随后与数组最后一位元素进行交换
     * @param arr
     */
    public static void HeapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }
        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(arr, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 构建堆的过程
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * 桶(基数)排序
     * bucket Sort / radix Sort
     * 思路：
     *     如果数组内位数很多(万位)或者都是个位数，先求出数组最大的值，然后不断/10，只要它能大于0，那么它的位数还有~：
     *     建立二维数组(桶)，buckets[arr.length][10];
     *     分配：按照元素的大小来放入不同的桶子里
     *     回收：将桶子里的元素按桶子顺序重新放到数组中
     *     重复.....两个步骤
     *     排序过程中，如果没有该位数、则补0。
     * 注意：
     *     基数排序对有负数和0的数列难以进行排序，所以往往有0和负数的数组一般我们都不用基数来进行排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = findMax(arr, 0, arr.length - 1);

        //需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            //建桶
            int[][] buckets = new int[arr.length][10];
            //获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] / i) % 10;
                //将其放入桶子里
                buckets[j][num] = arr[j];
            }
            //回收桶子里的元素
            int k = 0;
            //有10个桶子
            for (int j = 0; j < 10; j++) {
                //对每个桶子里的元素进行回收
                for (int l = 0; l < arr.length ; l++) {
                    //如果桶子里面有元素就回收(数据初始化会为0)
                    if (buckets[l][j] != 0) {
                        arr[k++] = buckets[l][j];

                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归，找出数组最大的值
     * @param arr 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */
    public static int findMax(int[] arr,int L,int R) {
        //如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R ) {
            return arr[L];
        }else {
            int a = arr[L];
            //找出整体的最大值
            int b = findMax(arr, L + 1, R);

            if (a > b) {
                return a;
            }else {
                return b;
            }
        }
    }
}
