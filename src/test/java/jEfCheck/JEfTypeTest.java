package jEfCheck;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class JEfTypeTest {

    @Test
    public void isClassesSameReturnFalseTest() {
        Temp temp = new Temp("Test", 1);
        Other other = new Other("Test", 2);
        Assert.assertFalse(JEfType.same(temp,other));
    }


    @Test
    public void isClassesSameReturnTrueTest() {
        Temp temp = new Temp("Test", 1);
        Temp other = new Temp("Test", 2);
        Assert.assertTrue(JEfType.same(temp,other));
    }

    @Test
    public void isInnerClassBaseTest() {
        Temp temp = new Temp("Test", 1);
        TempInner tempInner = new TempInner("TestTemp", 2, 2);
        Assert.assertTrue(JEfType.inner(temp,tempInner));
    }

    @Test
    public void isSameByValueReturnTrueTest() {
        Temp tempFirst1 = new Temp("Test", 1);
        Temp tempSecond1 = new Temp("Test",1);
        Assert.assertTrue(JEfType.sameByValue(tempFirst1, tempSecond1));
    }


    @Test
    public void isSameByValueReturnFalseTest() {
        Temp tempFirst = new Temp("Test", 1);
        Temp tempSecond = new Temp("Test1",1);
        Assert.assertFalse(JEfType.sameByValue(tempFirst, tempSecond));
    }

    @Test
    public void isInnerClassComplexTrueTest() {
        Temp tempFirst = new Temp("Test", 1);
        Temp tempSecond = new Temp("Test1", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempSecond);
        classOne.list.add(1);
        Assert.assertTrue(JEfType.inner(tempFirst, tempSecond));
    }

    @Test
    public void isInnerClassComplexFalseTest() {
        Other other = new Other("Test", 1);
        Temp tempFirst = new Temp("Test1", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
        classOne.list.add(1);
        Assert.assertFalse(JEfType.inner(other, tempFirst));
    }

    @Test
    public void isSameByValueReturnComplexTrueTest() {
        Temp tempFirst = new Temp("Test1", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
        ComplexClassOne classTwo = new ComplexClassOne("field2","field2", tempFirst);
        classOne.list.add(1);
        classTwo.list.add(1);
        Assert.assertTrue(JEfType.sameByValue(classOne, classTwo));
    }


    @Test
    public void isSameByValueReturnComplexSecondFalseTest() {
        Temp tempFirst = new Temp("Test1", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
        ComplexClassOne classTwo = new ComplexClassOne("field3","field2", tempFirst);
        classOne.list.add(1);
        classTwo.list.add(1);
        Assert.assertFalse(JEfType.sameByValue(classOne, classTwo));
    }

    @Test
    public void isSameByValueReturnComplexTrueOtherTest() {
        Temp tempFirst = new Temp("Test1", 1);
        Temp tempSecond = new Temp("Test1", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
        ComplexClassOne classTwo = new ComplexClassOne("field2","field2", tempSecond);
        Assert.assertTrue(JEfType.sameByValue(classOne, classTwo));
    }


    @Test
    public void isSameByValueReturnComplexFalseOtherTest() {
        Temp tempFirst = new Temp("Test1", 1);
        Temp tempSecond = new Temp("Test11", 1);
        ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
        ComplexClassOne classTwo = new ComplexClassOne("field2","field2", tempSecond);
        Assert.assertFalse(JEfType.sameByValue(classOne, classTwo));
    }

    private class Temp{
        String name;
        int count;

        Temp(String name, int count){
            this.name = name;
            this.count = count;
        }
    }

    private class ComplexClassOne{
        String field1;
        String field2;
        Temp temp;
        List<Integer> list;

        ComplexClassOne(String field1, String field2, Temp temp){
            list = new ArrayList<>();
            this.field1 = field1;
            this.field2 = field2;
            this.temp = temp;
        }
    }

    private class Other{
        String name;
        int count;

        Other(String name, int count){
            this.name = name;
            this.count = count;
        }
    }

    private class TempInner extends Temp{
        int result;
        public TempInner(String name, int count, int result) {
            super(name, count);
            this.result = result;
        }
    }
}