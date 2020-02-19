package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {
    private  MoodAnalyzer moodAnalyzer;

    @Before
    public void initialize() throws Exception {
        moodAnalyzer=new MoodAnalyzer();
    }

    @Test
    public void givenInput_whenHappy_shouldReturnHappy() {
        String mood= null;
        try {
            mood = moodAnalyzer.checkMood("I am in Happy Mood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenInput_whenSad_shouldReturnSad() {
        String mood= null;
        try {
            mood = moodAnalyzer.checkMood("I am in Sad Mood");
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInput_whenNull_shouldReturnHappy()  {
        try {
            ExpectedException exceptRule=ExpectedException.none();
            exceptRule.expect(MoodAnalyzerException.class);
            String mood = moodAnalyzer.checkMood(null);
            Assert.assertEquals(null, mood);
        }catch(MoodAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenInput_whenEmpty_shouldReturnException() {
       try {
            String mood = moodAnalyzer.checkMood("");

        } catch (MoodAnalyzerException e) {
           Assert.assertEquals("Please Enter Proper message",e.getMessage());

       }
    }
}
