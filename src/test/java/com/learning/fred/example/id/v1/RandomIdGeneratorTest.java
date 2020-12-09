package com.learning.fred.example.id.v1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fred
 * @date 2020/12/1 09:31
 * @description todo
 */
public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubSplitByDot("field1.field2");
        Assert.assertEquals("field2", actualSubstr);


        actualSubstr = idGenerator.getLastSubSplitByDot("field1");
        Assert.assertEquals("field1", actualSubstr);

        actualSubstr = idGenerator.getLastSubSplitByDot("field1#field2$field3");
        Assert.assertEquals("field1#field2$field3", actualSubstr);
    }

    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {

        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubSplitByDot(null);
        Assert.assertNull(actualSubstr);

        actualSubstr = idGenerator.getLastSubSplitByDot("");
        Assert.assertEquals("", actualSubstr);
    }

    @Test//?
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue(('0' < c && c > '9') || ('a' < c && c > 'z') || ('A' < c && 'Z' < c));
        }

    }

    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);

        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);

    }

}
