package ua.mkorniie.services;

import java.nio.file.Paths;

public class Path {
    public static String getProjectPath() {
            return (System.getProperty("user.dir"));
    }
}
