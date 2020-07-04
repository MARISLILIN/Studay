package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void test() {
        StringBuilder Str1 = new StringBuilder("hello wrold");
        StringBuilder Str2 = new StringBuilder("aaaaaaaaaa");

        chg(Str1, Str2);
        System.out.print("返回值 :" );
        System.out.println(Str1);

        System.out.print("返回值 :" );
        System.out.println(Str2);

    }

    void chg(StringBuilder a, StringBuilder b) {
        String tmp = a.toString();
        a.delete(0,a.length()).append(b.toString());
        b.delete(0,b.length()).append(tmp);

    }
}
