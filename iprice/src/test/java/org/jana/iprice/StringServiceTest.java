package org.jana.iprice;

import org.jana.iprice.service.StringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class StringServiceTest {

    @InjectMocks
    private StringService stringService;

    @Test
    void testConvertToUpperCase() {

        String input = "hello world";
        String expected = "HELLO WORLD";

        assertEquals(expected, stringService.convertToUpperCase(input));
    }

    @Test
    void testConvertToAlternateCases() {

        String input = "hello world";
        String expected = "hElLo wOrLd";

        assertEquals(expected, stringService.convertToAlternateCases(input));
    }

    @Test
    void testConvertToCSV() {

        String input = "hello world";
        String expected = "h,e,l,l,o, ,w,o,r,l,d";

        assertEquals(expected, stringService.convertToCSV(input));
    }

}
