package ua.mkorniie;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        String language = "en";
        String country = "US";

        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle_en_US", locale);

        Locale localeFrench = new Locale("fr", "FR");
        ResourceBundle resourceBundleF = ResourceBundle.getBundle("MessagesBundle_fr_FR", localeFrench);

        String strUS = resourceBundle.getString("greetings");
        System.out.println(strUS);

        String strFr = resourceBundleF.getString("greetings");
        System.out.println(strFr);

    }
}
