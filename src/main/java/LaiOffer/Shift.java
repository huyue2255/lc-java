package LaiOffer;

/**
 * Created by yuehu on 10/14/20.
 */
public class Shift {


    public static void main(String[] args) {
        int leftnumber = 10;
        int rightnumber = 10;
        //原始数二进制
        printInfo(leftnumber);
        leftnumber = leftnumber << 1;
        //左移一位
        System.out.println("left shift");
        printInfo(leftnumber);
        rightnumber = rightnumber >> 1;
        //右移一位
        System.out.println("right shift");
        printInfo(rightnumber);


        //左移、右移、无符号右移
        //https://blog.csdn.net/weixin_37490221/article/details/78011470
//        7右移2位
//
//        00000000 00000000 00000000 00000111//7的二进制（不要告诉我你不知道为什么）
//        右移两位后
//        00000000 00000000 00000000 00000001//最左边用符号位填充
//        转换十进制为：
//        1

//        7无符号右移2位
//        00000000 00000000 00000000 00000111//7的二进制（不要告诉我你不知道为什么）
//        右移两位后
//        00000000 00000000 00000000 00000001//最左边用0填充
//        转换十进制为：
//        1

//        -7右移2位
//        11111111111111111111111111111001//-7的二进制
//        右移两位后
//        11111111111111111111111111111110//最左边用符号位填充
//        转换十进制为：
//        -2

//        -7无符号右移2位
//        11111111111111111111111111111001//-7的二进制
//        右移两位后
//        00111111111111111111111111111110//最左边用0填充
//        转换十进制为：
//        1073741822

//        7左移2位
//        00000000 00000000 00000000 00000111//7的二进制（不要告诉我你不知道为什么）
//        右移两位后
//        00000000 00000000 00000000 00011100//最右边用0填充
//        转换十进制为：
//        28

//        -7左移2位
//        11111111111111111111111111111001//-7的二进制
//        右移两位后
//        11111111111111111111111111100100//最左边用0填充
//        转换十进制为：
//        -28

        System.out.println(Integer.toBinaryString(-7));//将整型-7转化为二进制形式显示
        System.out.println(Integer.toBinaryString(7));//将整型7转化为二进制形式显示
//        System.out.println(7>>2);//将整型7右移2位
//        System.out.println(7>>>2);//将整型7无符号右移2位
//        System.out.println(-7>>2);//将整型-7右移两位
//        System.out.println(-7>>>2);//将整型-7无符号右移两位
//        System.out.println(7<<2);//将整型7左移移两位
//        System.out.println(-7<<2);//将整型-7左移移两位
    }

    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}

