import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputText {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputString() {

        String text ="";

        try {
            text = reader.readLine();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return text;
    }

    public static int inputInt() {

        int text = 0;

        try {
            text = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.getStackTrace();
        }
        return text;
    }

}
