package com.daryl.mytest.annotationtest;

import com.daryl.domain.Student;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wl
 * @create 2022-02-16
 */
public class AnnoTest {

    @Daryl
    private Student student;

    private String name;

    @Test
    public void test() throws Exception{
        //load 注入student
        load();
        //
        student.setName("daryl");
        System.out.println("student = " + student);
        System.out.println("name = " + name);
    }

    private  void load() {
        Class<AnnoTest> clazz = AnnoTest.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Daryl.class) != null) {
                field.setAccessible(true);
                try {
//                    Method declaredMethod = clazz.getDeclaredMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
//                    Method[] declaredMethods = clazz.getDeclaredMethods();
//                    for (Method method : declaredMethods) {
//                        method.getName();
//                    }
//                    //set方法注入
//                    declaredMethod.invoke(this, field.getType().newInstance());
                    field.set(this, field.getType().getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Student yuan = Student.yuan();
        Class<Student> clazz = Student.class;
        Student yan = clazz.getDeclaredConstructor().newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] declaredFields1 = yuan.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields1[i].setAccessible(true);
           declaredFields[i].set(yan,declaredFields1[i].get(yuan));
        }

        System.out.println(yan);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
