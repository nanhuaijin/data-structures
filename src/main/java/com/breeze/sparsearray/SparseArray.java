package com.breeze.sparsearray;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author breeze
 * @date 2020/2/10
 * 模拟五子棋盘存档和读档
 * 采用二维数组 + 稀疏数组
 */
public class SparseArray {

    //棋盘的大小
    private static final int CHESS_SIZE = 11;

    public static void main(String[] args) {

        //创建一个原始的二维数组 11 * 11
        //0：表示没有棋子，1表示黑子  2表示白子
        int[][] chessArr1 = new int[CHESS_SIZE][CHESS_SIZE];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("====原始的二维数组====");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组的思路
        //1.遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < CHESS_SIZE; i++) {
            for (int j = 0; j < CHESS_SIZE; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum + "\n");

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将棋子(非0数据)存放到稀疏数组中
        //count用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < CHESS_SIZE; i++) {
            for (int j = 0; j < CHESS_SIZE; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("====得到的稀疏数组====");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组保存到磁盘文件中
        try {
            FileOutputStream fos = new FileOutputStream("chess.data");
            for (int[] row : sparseArr) {
                for (int data : row) {
                    fos.write(String.valueOf(data).getBytes());
                    fos.write(",".getBytes());
                }
            }
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //将稀疏数组 转 二维数组
        //1.读取保存稀疏数组的磁盘文件
        String str = null;
        try {
            FileInputStream fis = new FileInputStream("chess.data");

            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                str = new String(bytes, 0, len);
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert str != null;
        String[] split = str.split(",");
        System.out.println("读取磁盘棋盘得到的数组：" + Arrays.toString(split));
        int[][] sparseArr2 = new int[Integer.parseInt(split[2]) + 1][3];

        for (int i = 0; i < split.length; i+=3) {
            sparseArr2[i / 3][0] = Integer.parseInt(split[i]);
            sparseArr2[i / 3][1] = Integer.parseInt(split[i+1]);
            sparseArr2[i / 3][2] = Integer.parseInt(split[i+2]);
        }

        //2.先读取稀疏数组第一行，根据第一行创建原始二维数组
        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("====恢复后的二维数组====");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
