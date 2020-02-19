package com.brideglab.junit;

import com.bridgelab.exception.MoodAnalyzerException;

public class MoodAnalyzer {

    public String checkMood(String message) throws MoodAnalyzerException {
        try {
            if (message.contains(""))
            {
                throw new  MoodAnalyzerException("Please Enter Proper message");
            }
            if (message.contains("SAD")) {
                return "SAD";
            }
            return "HAPPY";

        }catch(NullPointerException e) {
           throw new  MoodAnalyzerException("Please Enter Proper message");
        }
    }
}
