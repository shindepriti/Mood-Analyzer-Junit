package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {

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

    public static Object invokeMethod(MoodAnalyzer moodAnalyzerObject, String methodName) throws MoodAnalyzerException {
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
}
