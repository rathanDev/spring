package org.jana.iprice;

import org.jana.iprice.util.IpriceStringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    void testConvertToUpperCase() {

        String input = "hello world";
        String expected = "HELLO WORLD";

        assertEquals(expected, IpriceStringUtil.convertToUpperCase(input));
    }

    @Test
    void testConvertToAlternateCases() {

        String input = "hello world";
        String expected = "hElLo wOrLd";

        assertEquals(expected, IpriceStringUtil.convertToAlternateCases(input));
    }

    @Test
    void test () {

        String input = "hello world";
        String expected = "h,e,l,l,o, ,w,o,r,l,d";

        assertEquals(expected, IpriceStringUtil.convertToCSV(input));
    }

}
