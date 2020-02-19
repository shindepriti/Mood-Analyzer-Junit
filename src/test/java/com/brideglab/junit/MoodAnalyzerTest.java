package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

    @Test
    public void givenInput_whenHappy_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy Mood");
        String mood= null;
        try {
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("HAPPY",mood);
        }catch(MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenInput_whenSad_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Sad Mood");
        String mood= null;
        try {
            mood = moodAnalyzer.checkMood();
            Assert.assertEquals("SAD",mood);
        }catch(MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInput_whenNull_shouldReturnException()  {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer(null);
        try {
            ExpectedException exceptRule=ExpectedException.none();
            exceptRule.expect(MoodAnalyzerException.class);
            String mood = moodAnalyzer.checkMood();
            Assert.assertEquals(null, mood);
        }catch(MoodAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenInput_whenEmpty_shouldReturnExceptionMessage() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("");
       try {
            String mood = moodAnalyzer.checkMood();
        }catch(MoodAnalyzerException e) {
           Assert.assertEquals("Please Enter Proper message",e.getMessage());

       }
    }

    @Test
    public void givenInput_whenEnteredNull_shouldReturnExceptionMessage() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer(null);
        try {
            String mood=moodAnalyzer.checkMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenInput_whenEnteredEmpty_shouldReturnExceptionMessage() {
    MoodAnalyzer moodAnalyzer=new MoodAnalyzer("");
        try {
            String mood=moodAnalyzer.checkMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
