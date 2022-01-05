package validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_NAME = "^[A-Z][a-z]+\\s$";
    private static final String REGEX_CUSTOMER_ID = "^(KH-)\\d{4}$";
    private static final String REGEX_SERVICE_ID = "^(DV-)\\d{4}$";
    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_PERSONAL_ID = "^(\\d{9}|\\d{12})$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";


    public static boolean regexName(String idCard)  {
        pattern = Pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexPersonalId(String idCard)  {
        pattern = Pattern.compile(REGEX_PERSONAL_ID);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexPhone(String idCard)  {
        pattern = Pattern.compile(REGEX_PHONE);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexEmail(String idCard)  {
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexDate(String idCard)  {
        pattern = Pattern.compile(REGEX_DATE);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean dateValid(String date) {

        boolean valid = false;

        try {

            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd")
                            .withResolverStyle(ResolverStyle.STRICT)
            );
            valid = false;

        } catch (DateTimeParseException e) {
//            e.printStackTrace();
            valid = true;

        }

        return valid;
    }
    public static boolean regexCustomerId(String idCard)  {
        pattern = Pattern.compile(REGEX_CUSTOMER_ID);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexServiceId(String idCard)  {
        pattern = Pattern.compile(REGEX_SERVICE_ID);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }




}
