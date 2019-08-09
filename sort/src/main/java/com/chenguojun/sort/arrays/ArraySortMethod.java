package com.chenguojun.sort.arrays;

/**
 * @author cjj
 * @Title: ArraySortMethod
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/817:48
 */
public class ArraySortMethod {
    private final static int arr[] = {23, 48, 12, 56, 45};


    public static void main(String[] args) {

        //冒泡排序
        //将第i位上的元素与其后的每一个元素分别比较，每次遇见更小的，就将两个元素交换位置
        //第i位上的元素确定之后再继续确定第i+1位上的元素
//        int temp;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(arr);
//    }

//        int temp ;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]){
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(arr.toString());


        int arr3[] = {23, 12, 48, 56, 45};
        for (int i = 0; i < arr3.length; i++) {
            int tem = i;
            //将数组中从i开始的最小的元素所在位置的索引赋值给tem
            for (int j = i; j < arr3.length; j++) {
                if (arr3[j] < arr3[tem]) {
                    tem = j;
                }
            }
            //上面获取了数组中从i开始的最小值的位置索引为tem，利用该索引将第i位上的元素与其进行交换
            int temp1 = arr3[i];
            arr3[i] = arr3[tem];
            arr3[tem] = temp1;
        }
        System.out.println(arr);


    }

    public void test() {

    }
}


