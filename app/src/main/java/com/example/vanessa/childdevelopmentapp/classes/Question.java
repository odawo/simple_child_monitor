package com.example.vanessa.childdevelopmentapp.classes;

/**
 * Created by Vanessa on 07/11/2017.
 */

public class Question {

    private String question;
    private String answer;
    private String[] choice = new String[2];

    public Question() {}

    public Question(String question, String[] choices, String answer) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getChoice(int i) {
        return choice[i];
    }

    public void setChoice(int i, String choice) {
        this.choice[i] = choice;
    }
}
