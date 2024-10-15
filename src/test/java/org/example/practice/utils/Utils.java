package org.example.practice.utils;

import java.util.ResourceBundle;

public class Utils {

    private Utils() {
    }

    public static String readFromProperties(String property) {
        String targetEnvironment = System.getProperty("target.env");
        String propertyToSearch;
        if (targetEnvironment != null && !targetEnvironment.isEmpty()) {
            propertyToSearch = String.format("%s.%s", targetEnvironment, property);
        } else {
            propertyToSearch = String.format("%s.%s", "qa0", property);
        }
        return ResourceBundle.getBundle("vop-test")
                .getString(propertyToSearch);
    }

}
