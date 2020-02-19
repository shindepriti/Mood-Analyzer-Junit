package com.brideglab.junit;

import com.bridgelab.exception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message=message;
    }
    public String checkMood() throws MoodAnalyzerException {
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
