package com.binzet.formatter;

import com.binzet.entity.Province;
import com.binzet.service.ProvinceService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements Formatter<Province> {
    private ProvinceService provinceService;

    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findOne(Long.valueOf(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return object.toString();
    }
}
