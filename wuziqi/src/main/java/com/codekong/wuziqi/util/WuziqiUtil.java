package com.codekong.wuziqi.util;

import android.graphics.Point;

import java.util.List;

/**
 * Created by 尚振鸿 on 2016-11-01.
 */

public class WuziqiUtil {
    //每行上最大的数目
    public static final int MAX_COUNT_IN_LINE = 5;

    /**
     * 检查是否五子连珠
     * @param points
     * @return
     */
    public static boolean checkFiveInLine(List<Point> points) {
        for (Point p: points) {
            int x = p.x;
            int y = p.y;

            boolean win = checkHorizontal(x, y, points);
            if (win) return true;
            win = checkVertical(x, y, points);
            if (win) return true;
            win = checkLeftDiagonal(x, y, points);
            if (win) return true;
            win = checkRightDiagonal(x, y, points);
            if (win) return true;

        }
        return false;
    }

    /**
     * 判断x, y位置的棋子是否横向五个一致
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static boolean checkHorizontal(int x, int y, List<Point> points) {
        int count = 1;
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;

        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x, y位置的棋子是否竖向五个一致
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static boolean checkVertical(int x, int y, List<Point> points) {
        int count = 1;
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x, y - i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;

        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x, y + i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x, y位置的棋子是否左斜向上五个一致
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static boolean checkLeftDiagonal(int x, int y, List<Point> points) {
        int count = 1;
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y + i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;

        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y - i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x, y位置的棋子是否右斜向下五个一致
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static boolean checkRightDiagonal(int x, int y, List<Point> points) {
        int count = 1;
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y - i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;

        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y + i))){
                count ++;
            }else {
                break;
            }
        }

        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }
}
