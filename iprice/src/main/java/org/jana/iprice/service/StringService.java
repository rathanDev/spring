package org.jana.iprice.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {


    public String convertToUpperCase(String input) {
        return input.toUpperCase();
    }


    public String convertToAlternateCases(String input) {

        int i = 0;
        char[] chars = input.toCharArray();

        for (char ch : chars) {
            if (i % 2 == 1) {
                chars[i] = Character.toUpperCase(ch);
            }
            i++;
        }

        return new String(chars);
    }

    public String convertToCSV(String input) {

        StringBuilder sb = new StringBuilder(input);
        int noOfIterations = (input.length() * 2) - 1;

        for (int i = 0; i < noOfIterations; i++) {
            if (i % 2 == 1) {
                sb.insert(i, ',');
            }
        }

        return sb.toString();
    }


}
