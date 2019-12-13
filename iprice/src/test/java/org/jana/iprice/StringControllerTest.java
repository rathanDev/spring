package org.jana.iprice;

import org.jana.iprice.controller.StringController;
import org.jana.iprice.service.StringService;
import org.jana.iprice.util.IpriceStringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class StringControllerTest {

    @InjectMocks
    StringController stringController;

    @Mock
    StringService stringService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(stringController, "stringService", stringService);
    }

    @Test
    void testConvertToUpperCase() {

        String input = "hello world";
        String expected = IpriceStringUtil.convertToUpperCase(input);

        Mockito
                .when(stringService.convertToUpperCase(input))
                .thenReturn(IpriceStringUtil.convertToUpperCase(input));

        assertEquals(
                expected,
                stringController.convertToUpper(input).getBody());
    }

    @Test
    void testConvertToAlternateCases() {

        String input = "hello world";
        String expected = IpriceStringUtil.convertToAlternateCases(input);

        Mockito
                .when(stringService.convertToAlternateCases(input))
                .thenReturn(IpriceStringUtil.convertToAlternateCases(input));

        assertEquals(
                expected,
                stringController.convertToAlternateCases(input).getBody());
    }

    @Test
    void testConvertToCSV() {

        String input = "hello world";
        String expected = IpriceStringUtil.convertToCSV(input);

        Mockito
                .when(stringService.convertToCSV(input))
                .thenReturn(IpriceStringUtil.convertToCSV(input));

        assertEquals(
                expected,
                stringController.convertToCSV(input).getBody());
    }

}
