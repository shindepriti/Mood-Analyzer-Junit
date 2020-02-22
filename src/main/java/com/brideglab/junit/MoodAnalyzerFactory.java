package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    //Use Reflection to Parametrized Constructor
    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Constructor constructor = Class.forName("com.brideglab.junit.MoodAnalyzer").getConstructor(String.class);
            Object obj = constructor.newInstance(message);
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) obj;
            return (MoodAnalyzer) moodAnalyzer;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Use reflection To Default Constructor
    public static MoodAnalyzer createMoodAnalyzerDefault() {
        try {
            Constructor constructor = Class.forName("com.brideglab.junit.MoodAnalyzer").getConstructor();
            Object obj = constructor.newInstance();
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) obj;
            return (MoodAnalyzer) moodAnalyzer;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Use Reflection To Invoke Default And Parametrized Constructor Of Class
    public static Constructor<?> getConstructor(String param, Class className) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzer = Class.forName(param);
            return moodAnalyzer.getConstructor(className);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }
    // Use Reflection to Invoke Method
    public static Object invokeMethod(Object moodAnalyzerObject, String methodName) throws MoodAnalyzerException {
        try {
            return moodAnalyzerObject.getClass().getMethod(methodName).invoke(moodAnalyzerObject);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Use Reflector to SetField value and Invoke Method Using Reflection
    public static Object setFieldValue(Object moodAnalyzerObject, String fieldName,String fieldValue) throws MoodAnalyzerException {
        try {

            Field field = moodAnalyzerObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyzerObject,fieldValue);
            return moodAnalyzerObject.getClass().getDeclaredMethod("checkMood").invoke(moodAnalyzerObject);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.FIELD_INVOCATION_ISSUE, e.getMessage());
        }
        return null;
    }

}
