package Xian.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author HYH
 * @version 1.0
 * @description 三天打鱼两天晒网
 * @since
 */
public class FishDry {
    //计算任意两个日期的天数差
    public static long dayDifference(Date one, Date two) {
        //通过计算两个日期的毫秒数差,除以一天的毫秒数,即可得到两个日期相差的天数
        long difference = ((one.getTime() - two.getTime())/ (24 * 60 * 60 * 1000));
        return Math.abs(difference);
    }

    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat将日期格式转化yyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        //定义Date对象,通过parse方法,将String类型转换为Date类型
        Date one = dateFormat.parse("2010-01-01");
        Date two;
        while (true) {
            System.out.println("请输入查询日期(例2021-03-21)");
            Scanner in = new Scanner(System.in);
            String queryDay = in.nextLine();
            try {
                //通过lenient为false,否则SimpleDateFormat会比较宽松地验证日期
                dateFormat.setLenient(false);
                //通过parse方法,将string类型转换为Date类型
                two = dateFormat.parse(queryDay);
            } catch (ParseException e) {
                //传入的参数不合法,获取异常,重新输入
                System.out.println("非法日期,请重新输入");
                continue;
            }
            //参数日期合法,结束循环
            break;
        }
        //两日期相差天数,比实际判断所需要天数少一天
        long difference = dayDifference(one, two) + 1;
        long day = difference % 5;
        //对5求余数 ,用于判断在打鱼或者还是在打鱼
        if (day > 0 && day < 4) {
            System.out.println("第" + difference + "天,他在打鱼");
        } else {
            System.out.println("第" + difference + "天,他在晒鱼");
        }

    }
}
