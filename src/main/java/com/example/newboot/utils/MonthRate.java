package com.example.newboot.utils;

public class MonthRate {
    public static double rate(double a, double b, double c, int cnt, int ina) {
        double rate = 1D, x, jd = 0.1D, side = 0.1D, i = 1D;
        do {
            x = a / b - (Math.pow(1 + rate, c) - 1) / (Math.pow(rate + 1, c) * rate);
            if (x * side > 0) {
                side = -side;
                jd *= 10;
            }
            rate += side / jd;
        } while (i++ < cnt && Math.abs(x) >= 1 / Math.pow(10, ina));
        if (i > cnt) {
            return Double.NaN;
        }
        return rate;
    }


    public static void main(String agrs[]) {
        {
            // Double 现值 = 7944760.00d;
            // Double 年金 = 186627.21d;
            // Double 期数 = 48d;

            // 计算200次，比Excel20次要精确，误差精确到小数点后10位
            System.out.println(rate(150000, 6000, 36, 200, 10));

        }

    }
}
