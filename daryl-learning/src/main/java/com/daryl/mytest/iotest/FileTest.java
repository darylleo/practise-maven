package com.daryl.mytest.iotest;

import org.junit.Test;

import java.io.File;

/**
 * java文件处理
 *
 * @author wl
 * @create 2022-04-22
 */
public class FileTest {

    /**
     * File类的构造方法
     * public File(String pathname) =>通过将给定的路径名字符串转换为抽象路径名来创建新的file实例。
     * public File(String parent, String child) => 从父路径名字符串和子路径名字符串创建新的file实例
     * public File(File parent, String child) => 从父抽象路径名和子路径名字富川创建新的file实例
     */
    //region  File 类的构造方法
    @Test
    public void test01() {
        String pathname = "H:\\aaa\\hb.jpg";
        String parent = "H:\\aaa\\";
        String child = "hb.jpg";
        //method one
        File file1 = new File("H:\\aaa\\hb.jpg");

        //method two
        File file2 = new File(parent, child);

        //method three
        File parentFile = new File(parent);
        File file3 = new File(parentFile, child);

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
    }
    //endregion

    /**
     * 获取功能的方法:
     * public String getAbsolutePath() => 返回File 的绝对路径名字符串
     * public String getPath() => 将 File 转换为路径名字符串
     * public String getName() => 返回 File 表示的文件或目录的名称
     * public long length() => 返回File表示的文件的长度，不能获取目录的长度。
     */
    //region  File 类获取功能的方法
    @Test
    public void test02() {
        String path = "Snipaste\\idea配色\\肤色黄.png";
        String pathname = "C:\\Users\\Daryl\\Pictures\\Snipaste\\idea配色\\肤色黄.png";
        File file = new File(pathname);
        File file1 = new File(path);
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.length());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.length());
    }
    //endregion

    /**
     * 判断功能的方法
     * public boolean exists() => 文件或目录是否实际存在
     * public boolean isDirectory() => file 是否为目录
     * public boolean isFile() => file 是否为文件
     */
    //region File 类判断功能的方法
    @Test
    public void test03() {
        String path = "Snipaste\\idea配色\\肤色黄.png";
        String pathname = "C:\\Users\\Daryl\\Pictures\\Snipaste\\idea配色\\肤色黄.png";
        File file = new File(pathname);
        File file1 = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
    }
    //endregion

    /**
     * 创建、删除功能方法：
     * public boolean createNewFile() => 当且仅当具有该名称的文件不存在时，创建一个新的空文件
     * public boolean delete() => 删除由此 File 表示的文件或目录
     * public boolean mkdir() => 创建由此 File 表示的目录
     * public boolean mkdirs() => 创建由此 File 表示的目录，包括任何必须但不存在的父目录
     */
    //region File 类创建、删除方法
    @Test
    public void test04() {

    }
    //endregion

    /**
     * 遍历目录的方法
     * public String[] list() => 返回一个String 数组，存储的是file目录中所有的子文件或子目录的名称。
     * public File[] listFiles() => 返回一个file数组。存储的是file目录中所有的子文件或子目录的路径的file对象。
     */
    //region File 类遍历目录
    @Test
    public void test05() {
        String pathname = "C:\\Users\\Daryl\\Pictures\\Snipaste\\idea配色";
        File file = new File(pathname);
//        String[] list = file.list();
//        if (list != null) {
//            for (String s : list) {
//                System.out.println(s);
//            }
//        }

        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1);
            }
        }
    }
    //endregion
}
