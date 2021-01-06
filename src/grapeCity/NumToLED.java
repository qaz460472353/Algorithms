package grapeCity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 数字转换液晶显示
 */
public class NumToLED {
    // num0-num9 代表电子数字 0 - 9
    public static String[][] num0 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", " ", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    public static String[][] num1 = new String[][] { { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    public static String[][] num2 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " } };
    public static String[][] num3 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };
    public static String[][] num4 = new String[][] { { " ", " ", " " }, { "|", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    public static String[][] num5 = new String[][] { { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };
    public static String[][] num6 = new String[][] { { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    public static String[][] num7 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    public static String[][] num8 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    public static String[][] num9 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };

    public static String[][] option = new String[][] { { " ", " ", " " }, { " ", "●", " " }, { " ", " ", " " }, { " ", "●", " " }, { " ", " ", " " } };

    public static String[][][] numAll = new String[][][] { num0, num1, num2, num3, num4, num5, num6, num7, num8, num9 };

    public static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) {
        print();
    }
    public static void print() {
        String[][][] newStr = getDateArray();
        // 第一层控制行数
        for (int i = 0; i < 5; i++) {
            // 第二层每行多少个字符串
            for (int k = 0; k < newStr.length; k++) {
                // 第三层，每个数字占三个位置
                for (int j = 0; j < 3; j++) {
                    System.out.print(newStr[k][i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static String[][][] getDateArray() {
        String[][][] dateArray = new String[5][][];
        String dateStr = sdf.format(new Date());
        char[] dateChars = dateStr.toCharArray();
        for (int i = 0; i < dateChars.length; i++) {
            switch (dateChars[i]) {
                case ':':
                    dateArray[i] = option;
                    break;
                default:
                    Integer index = Integer.valueOf(String.valueOf(dateChars[i]));
                    dateArray[i] = numAll[Integer.valueOf(String.valueOf(dateChars[i]))];
                    break;
            }
        }

        return dateArray;
    }
}
