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
    static {

    }

    @Daryl
    private Student student;

    private String name;

    @Test
    public void test() throws Exception{
        load();
        student.setName("daryl");
        System.out.println(student + "6666");
        System.out.println(this);
    }

    private  void load() {
        Class<AnnoTest> clazz = AnnoTest.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Daryl.class) != null) {
                field.setAccessible(true);
                try {
                    Method declaredMethod = clazz.getDeclaredMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
                    Method[] declaredMethods = clazz.getDeclaredMethods();
                    for (Method method : declaredMethods) {
                        method.getName();
                    }
                    declaredMethod.invoke(this, field.getType().newInstance());
                    //field.set(this, field.getType().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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
