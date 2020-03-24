package com.breeze.structure.recursion;

/**
 * @author breeze
 * @date 2020/2/28
 *
 *  递归：简单的说，就是方法自己调用自己，每次调用时传入不同的变量
 *
 *  迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        //1.创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //2.使用1代表墙
        //上下全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置响应的挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[6][2] = 1;
        map[6][4] = 1;

        //输出地图
        System.out.println("迷宫地图是：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯，在迷宫中找路
        searchWay(map, 1, 1);

        //输出路线
        System.out.println("找路后的地图是：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯来给小球找路
     *      1.当map[i][j] = 0 表示该点没有走过，1表示为墙，2表示道路可以走，3表示该点已经走过但是走不通
     *      2.在走迷宫时需要定义一个策略，先走下面 --> 再走右面 --> 再走上面 --> 再走左边
     *      3.如果该点走不通，再回溯
     * @param map 表示地图
     * @param i 从地图的哪个位置开始 行
     * @param j 列
     * @return 如果小球可以到达[6][5]位置，说明道路找到
     */
    public static boolean searchWay(int[][] map, int i, int j) {
        //说明通路已经找到
        if (map[6][5] == 2) {
            return true;
        } else {
            //说明该点还没有走过，按照策略玩一把
            if (map[i][j] == 0) {
                //下 --> 右 --> 上 --> 左
                //假定该点是可以走通
                map[i][j] = 2;

                if (searchWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (searchWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (searchWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (searchWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//map[i][j] 可能是 1,2,3
                return false;
            }
        }
    }
}
