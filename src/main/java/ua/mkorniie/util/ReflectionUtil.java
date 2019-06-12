package ua.mkorniie.util;

import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;
import ua.mkorniie.util.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionUtil {

//    public static void main(String[] args) {
//        User u = new User("fullNameval", "passwordEncoded val",  Roles.USER, "096", "mail", Language.eng);
////        ReflectionUtil.getAllFields(u);
//
////        System.out.println(ReflectionUtil.getAllFieldNames(u));
////        System.out.println("\n\n\n");
////        System.out.println(ReflectionUtil.getFieldNamesButFirst(u));
//
////        System.out.println(ReflectionUtil.getFieldValuesInStringButFirst(u));
//    }

    //tested
    public static Field[] getAllFields(Object object) {
        Class cls = object.getClass();
//        System.out.println("The name of class is " +
//                cls.getName());
        Field[] fields = cls.getDeclaredFields();
        return fields;
    }

    //TODO: change to Optionals
    //tested
    public static ArrayList<String> getAllFieldNames(Class cls) {
        ArrayList<String> result = new ArrayList<>();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
//            System.out.println("The field is: " + fields[i].toString());
            result.add(fields[i].toString());
        }
        return result;
    }

    //tested
    public static ArrayList<String> getFieldNamesButFirst(Class cls) {
        ArrayList<String> result = getAllFieldNames(cls);
        result.remove(0);
//        System.out.println(result);
        return result;
    }

    //tested
    public static ArrayList<String> getFieldValuesInString(Object object) {
        ArrayList<String> result = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            String parameter = null;
            try {
                Method method = object.getClass().getMethod("get" + StringUtil.capitalize(field.getName()));
                Object res = method.invoke(object);
                if (res != null) {
                    parameter = res.toString();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            result.add(parameter);

        }

        return result;
    }

    public static Object setFieldValues(ArrayList<String> set, Object object) {
        ArrayList<String> result = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        Object res = null;
        for (int i = 0; i < fields.length; i++){
            try {
                Method method = object.getClass().getMethod("set" + StringUtil.capitalize(fields[i].getName()));
                res = method.invoke(object, set.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return res;
        }

        return result;
    }

    //tested
    public static ArrayList<String> getFieldValuesInStringButFirst(Object object) {
        ArrayList<String> result = getFieldValuesInString(object);
        if (result != null) {
            result.remove(0);
        }
        return result;
    }
}