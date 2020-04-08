package com.breeze.structure.tree;

/**
 * @author breeze
 * @date 2020/4/8
 *
 *  堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求对数组进行升序排列 - 大顶堆
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /**
     * 编写一个堆排序的方法
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int temp;//临时变量
        //分步完成
        //adjustHeap(arr, 1, arr.length);
        //System.out.println("第一次：" + Arrays.toString(arr));
        //
        //adjustHeap(arr, 0, arr.length);
        //System.out.println("第二次：" + Arrays.toString(arr));

        //最终代码
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //2.将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前
        //末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            //交换t
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组(二叉树)，调整成一个大顶堆
     *  举例：{4, 6, 8, 5, 9} i=1 ===> {4,9,8,5,6}
     * @param arr 数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length  表示对多少个元素继续调整，length是在逐渐减少的
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        //先取出当前元素的值，保存在临时变量中
        int temp = arr[i];

        //开始调整
        //1.i * 2 + 1 指向的是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明左子节点小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; //
            }
            //如果子节点大于父节点，则交换
            if (arr[k] > temp) {
                //把较大的值赋给当前节点
                arr[i] = arr[k];
                //i指向k，继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在最顶端
        arr[i] = temp;
    }
}
