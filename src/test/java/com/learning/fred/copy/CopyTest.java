package com.learning.fred.copy;

import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @author fred
 * @date 2021/1/13 09:48
 * @description todo
 */
public class CopyTest {


    @Test
    public void test_copy1() {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/fred-zhang/Documents/my-project/mock-demo/src/test/java/com/learning/fred/copy");

        CopyA source = new CopyA();
        source.setName("fred");
        source.setAge(3);

        CopyB target = new CopyB();

        BeanCopier copier = BeanCopier.create(CopyA.class, CopyB.class, false);

        copier.copy(source, target, null);

        System.out.println(target);
    }

}


class CopyA {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CopyA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class CopyB {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CopyB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
