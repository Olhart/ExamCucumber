package api.regres.utils;

import io.qameta.allure.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    @Step("Парсим дату из строки {strDate} по формату \"yyyy-MM-dd'T'HH:mm:ss.SSSX\"")
    public static Date parseDataFromString(String strDate) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(strDate);
    }
}
