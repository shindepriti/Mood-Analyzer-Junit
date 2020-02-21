package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static com.brideglab.junit.MoodAnalyzerFactory.*;

public class MoodAnalyzerTest {
    //1.1
    @Test
    public void givenInput_whenHappy_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        String mood = null;
        try {
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //1.2
    @Test
    public void givenInput_whenSad_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try {
           String  mood = moodAnalyzer.checkMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    //2.1
    @Test
    public void givenInput_whenNull_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            String mood = moodAnalyzer.checkMood();
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    //3
    @Test
    public void givenInput_whenNull_shouldReturnException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            ExpectedException exceptRule = ExpectedException.none();
            exceptRule.expect(MoodAnalyzerException.class);
            String mood = moodAnalyzer.checkMood();
            Assert.assertEquals(null, mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    //3
    @Test
    public void givenInput_whenEmpty_shouldReturnExceptionMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            String mood = moodAnalyzer.checkMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals("Please Enter Proper message", e.getMessage());
        }
    }

    //3.1
    @Test
    public void givenInput_whenEnteredNull_shouldReturnExceptionMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            String mood = moodAnalyzer.checkMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    //3.2
    @Test
    public void givenInput_whenEnteredEmpty_shouldReturnExceptionMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            String mood = moodAnalyzer.checkMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
    //5
    @Test
    public void givenInputUsingReflector_whenProper_shouldReturnObject() {

        try {
            Constructor constructor = Class.forName("com.brideglab.junit.MoodAnalyzer").getConstructor(String.class);
            Object obj=constructor.newInstance("I am in Happy mood");
            MoodAnalyzer moodAnalyzer=(MoodAnalyzer) obj;
           String mood=moodAnalyzer.checkMood();
           Assert.assertEquals("HAPPY",mood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    //4
    @Test
    public void givenMoodAnalyzerUsingDefaultConstructor_whenProper_ShouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = createMoodAnalyzerDefault();
        Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
    }

    //4.2
    @Test
    public void givenMoodAnalyzerClass_whenProper_shouldReturnNoSuchClass() {

        try {
            getConstructor("com.brideglab.junit.MoodAnalyzer12",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }
    //4.3
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnNoSuchMethod() {
        try {
            getConstructor("com.brideglab.junit.MoodAnalyzer",Integer.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    //5
    @Test
    public void givenMoodAnalyzerUsingReflector_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = createMoodAnalyzer("This is Happy Mood");
        try {
            String mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    //5.1
    @Test
    public void givenMoodAnalyzerClassObject_whenProper_ShouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = createMoodAnalyzer("I am in Happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"), moodAnalyzer);
    }
}
