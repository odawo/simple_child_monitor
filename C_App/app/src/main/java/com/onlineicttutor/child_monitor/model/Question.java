package com.onlineicttutor.child_monitor.model;

/**
 * Created by alfiroj on 5/13/16.
 */
public class Question {
    private int id;
    private String QUESTION;
    private String ANSWER;
    private String OptionA;
    private String OptionB;

    public Question(){
        id=0;
        QUESTION="";
        ANSWER="";
        OptionA="";
        OptionB="";
    }

    public Question(String quesTion, String opA, String opB, String ansWer) {

        QUESTION = quesTion;
        OptionA = opA;
        OptionB = opB;
        ANSWER = ansWer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

}
