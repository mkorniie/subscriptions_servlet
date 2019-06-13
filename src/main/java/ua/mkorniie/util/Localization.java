package ua.mkorniie.util;

import lombok.Getter;
import lombok.Setter;
import ua.mkorniie.entity.Language;

import java.util.Locale;
import java.util.ResourceBundle;


public class Localization {
    @Getter @Setter private static Language currentLanguage = Language.ua;
    private static Locale engLocale = new Locale("en", "US");
    private static Locale uaLocale = new Locale("ua", "UA");

    public static ResourceBundle getCurrentBundle() {
        ResourceBundle resourceBundle = null;
        if (currentLanguage == Language.eng) {
            resourceBundle = ResourceBundle.getBundle("MessagesBundle_en_US", engLocale);
        } else if (currentLanguage == Language.ua) {
            resourceBundle = ResourceBundle.getBundle("MessagesBundle_ua_UA", uaLocale);
        }

        return resourceBundle;
    }

    private Localization() {}
}
