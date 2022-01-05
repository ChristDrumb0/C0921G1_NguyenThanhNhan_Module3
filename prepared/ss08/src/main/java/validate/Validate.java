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
//    private static final String REGEX_NAME = "^[A-Z][a-z]+\\s$";
    private static final String REGEX_NAME = "^([A-Z][a-z]+\\s[A-Z][a-z]+'?-?[a-zA-Z]\\s?([a-zA-Z]{1,})?)$";
    private static final String REGEX_PATIENT_ID = "^(BN-)\\d{3}$";
    private static final String REGEX_MEDICAL_RECORD_ID = "^(BA-)\\d{3}$";
    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_PERSONAL_ID = "^(\\d{9}|\\d{12})$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_SPECIAL = "^[^\\d\\t`~!@#$%^&*()_\\-+=|\\\\{}\\[\\]:;\"'<>,.?\\/]+$";


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
    public static boolean dateValid(final String date) {

        boolean valid = true;

        try {

            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            valid = false;


        } catch (DateTimeParseException e) {
//            e.printStackTrace();
            valid = true;
        }

        return valid;
    }
    public static boolean compareDate(String date1 ,String date2) {

        boolean valid = true;

        try {

            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate time1 = LocalDate.parse(date1,DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            LocalDate time2 =LocalDate.parse(date2,DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            if(time1.compareTo(time2)<=0){
                valid = false;
            }


        } catch (DateTimeParseException e) {
//            e.printStackTrace();

            valid = true;
        }

        return valid;
    }
    public static boolean regexPatientId(String idCard)  {
        pattern = Pattern.compile(REGEX_PATIENT_ID);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexMedicalRecordId(String idCard)  {
        pattern = Pattern.compile(REGEX_MEDICAL_RECORD_ID);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }
    public static boolean regexSpecial(String idCard)  {
        pattern = Pattern.compile(REGEX_SPECIAL);
        matcher = pattern.matcher(idCard);

        if (!matcher.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String date1 = "2000-02-01";
        String date2 = "2000-02-02";
        System.out.println(compareDate(date1,date2));
    }




}
