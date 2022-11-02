package com.daryl.mytest;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * option
 *
 * @author wl
 * @create 2022-02-18
 */
public class DarylTest {

    public static void main(String[] args) {

        //注册驱动
        //获取连接
        //获取数据库连接对象
        //执行sql语句
        //处理查询结果集
        //关闭连接
        ResultSet resultSet = null;
        Statement statement = null;
        Connection conn = null;

        try {
            //注册驱动
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            String url = "jdbc:mysql://127.0.0.1:3306/house?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
            String user = "root";
            String password = "toor";
            //获取连接
            conn = DriverManager.getConnection(url, user, password);

            statement = conn.createStatement();
            String sql = "select * from t_sys_user where id = 666";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println(username);
            }
        } catch (Exception e) {
            try {
                assert resultSet != null;
                resultSet.close();
                statement.close();
                conn.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
//        int a = 10;
//        int b = 20;
//        System.out.println("a :" + a );
//        System.out.println("b :" + b );
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println("a :" + a );
//        System.out.println("b :" + b );
//        Integer a = 10;
//        Integer b = 10;
        Integer integer = new Integer(10);
        Integer integer1 = integer;
        System.out.println(integer == integer1);

        integer = integer ^ integer1;
        integer1 = integer ^ integer1;
        integer = integer ^ integer1;
        System.out.println(integer);
//        System.out.println(a);
//        System.out.println(b);
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a);
//        System.out.println(b);
        //System.out.println(String.format("%02d", 89));
    }

//    private static int getFirstLetter(int[] nums, int target) {
//        if (nums == null) {
//            return -1;
//        }
//        int length = nums.length;
//        if (length <= 1) {
//            if (length == 1){
//                return 0;
//            }
//            return -1;
//        }else {
//            Arrays.binarySearch()
//        }
//    }

    @Test
    public void test02() {
        String val = "20220102";
        Date date = new Date();
        String regex = "[0-9]{4}-[0-1][1-9]-[0-31]{2}";
        String regex2 = "\\d{4}年\\d{2}月\\d{2}日";
        String time = "2022-09-01";
        String time2 = "2022年01月01日";
        System.out.println(time.matches(regex));
        System.out.println(time2.matches(regex2) + "6666666");
        //LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Integer getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return getSum(n - 1) + n;
    }

    @Test
    public void test04() {
        int i = 1;
        for (System.out.println(1); i <= 2; System.out.println(2)) {
            System.out.println(3);
            i++;
        }
    }

    @Test
    public void test05() throws Exception {
        Map<String, String> pinYin = changeChinesePinyin("三");
        System.out.println(pinYin.get("fullPinyin"));
    }

    public static Map<String, String> changeChinesePinyin(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        Map<String, String> pinyin = new HashMap<>();

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        StringBuffer fullPinyin = new StringBuffer();
        StringBuffer simplePinyin = new StringBuffer();
        StringBuffer firstPinyin = new StringBuffer();

        char[] chineseChar = chinese.toCharArray();
        for (int i = 0; i < chineseChar.length; i++) {
            String[] str = null;
            try {
                str = PinyinHelper.toHanyuPinyinStringArray(chineseChar[i], format);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (str != null) {
                if (str.length == 0) {
                    continue;
                }
                fullPinyin.append(str[0].toString());
                simplePinyin.append(str[0].charAt(0));
            }
            if (str == null) {
                String regex = "^[0-9]*[a-zA-Z]*+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(String.valueOf(chineseChar[i]));
                if (m.find()) {
                    fullPinyin.append(chineseChar[i]);
                    simplePinyin.append(chineseChar[i]);
                }
            }
        }
        String[] name = PinyinHelper.toHanyuPinyinStringArray(chineseChar[0], format);
        if (name == null && fullPinyin.substring(0, 1).matches("[a-zA-Z]")) {
            name = new String[]{fullPinyin.substring(0, 1)};
        } else if (name == null) {
            name = new String[]{"#"};
        }
        firstPinyin.append(name[0].charAt(0));
        pinyin.put("fullPinyin", fullPinyin.toString());
        pinyin.put("simplePinyin", simplePinyin.toString().toUpperCase());
        pinyin.put("groupPinyin", firstPinyin.toString().toUpperCase());
        return pinyin;
    }

    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (length < 4) {
            return list;
        }
        if (length == 4) {
            for (char aChar : chars) {
                sb.append(aChar).append(".");
            }
            list.add(sb.toString().substring(0, sb.toString().length() - 1));
            return list;
        }
        int count = 0;

        for (int i = 0; i < length; i++) {

        }
        return list;
    }

    @Test
    public void test06() {
        //System.out.println(SystemUtils.getUserDir());
        String s = "";
        String s1 = StringUtils.removeEnd(s, ",");
        System.out.println("s1 = " + s1);
    }
}
