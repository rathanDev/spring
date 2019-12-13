package org.jana.iprice.service;

import org.jana.iprice.util.IpriceStringUtil;
import org.springframework.stereotype.Service;

@Service
public class StringService {

    public String convertToUpperCase(String input) {
        return IpriceStringUtil.convertToUpperCase(input);
    }


    public String convertToAlternateCases(String input) {
        return IpriceStringUtil.convertToAlternateCases(input);
    }

    public String convertToCSV(String input) {
        return IpriceStringUtil.convertToCSV(input);
    }

}
