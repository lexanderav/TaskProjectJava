package DatesClass;

import InputTextClass.InputText;
import FilesClass.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Dates {

    private static DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static DateFormat getDateFormat() {
        return sdf;
    }

    public static String getInputDate() {
        Date validDate = newInputDate();
        return sdf.format(validDate);
    }

    private static Date newInputDate() {

        Date date = null;
        String readDate = InputText.inputString();

        if (isDateValid(readDate, "dd/MM/yyyy")) {
            try {

                date = sdf.parse(readDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;

        } else
            return newInputDate();
    }

    public static boolean isDateValid(String dateToValidate, String dateFormat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat validFormat = new SimpleDateFormat(dateFormat);
        validFormat.setLenient(false);

        try {

            Date date = validFormat.parse(dateToValidate);

        } catch (ParseException e) {
            System.out.println("The date format is not correct. Try it again.");
            return false;
        }
        return true;
    }

    public static void checkDateToday() {

        if (Files.getMap() != null) {

            System.out.println("<<<<Tasks for today>>>>\n" +
                               "-----------------------");

            for (HashMap.Entry<String, String> pair : Files.getMap().entrySet()) {

                if (pair.getKey().equals(Dates.getToday())) {
                    System.out.println( pair.getKey() + " - " + pair.getValue());
                }
            }

            System.out.println( "-----------------------\n" +
                                "<<<<Tasks for today>>>>\n");

        }
    }

    public static String getToday() {
        Date today = new Date();
        return sdf.format(today);
    }

}
