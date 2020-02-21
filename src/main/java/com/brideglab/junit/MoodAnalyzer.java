package com.brideglab.junit;
import com.bridgelab.exception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
    message="This is Default Message";
    }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String Mood(String message) throws MoodAnalyzerException {
        this.message=message;
        return checkMood();
    }

    public String checkMood() throws MoodAnalyzerException {
        try {
            if (message.contains(""))
            {
                throw new  MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY,"Please Enter Proper message");
            }
            if (message.contains("SAD")) {
                return "SAD";
            }
            return "HAPPY";

        }catch(NullPointerException e) {
           throw new  MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_NULL,"Please Enter Proper message");
        }
    }

    public boolean equals(Object any){
        if(this.message.equals(((MoodAnalyzer)any).message))
            return  true;
        return false;
    }

}
