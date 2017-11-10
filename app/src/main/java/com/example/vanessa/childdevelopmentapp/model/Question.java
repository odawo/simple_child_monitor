package com.example.vanessa.childdevelopmentapp.model;

/**
 * Created by Vanessa on 07/11/2017.
 */

public class Question {

    private int id;
    private String question;
    private String answer;
    private String choiceyes;
    private String choiceno;

    public Question() {
        id = 0;
        question = "";
        answer = "";
        choiceyes = "";
        choiceno = "";
    }

    public Question(String questionn, String answern, String choiceyesn, String choicenon) {
        question = questionn;
        answer = answern;
        choiceyes = choiceyesn;
        choiceno = choicenon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getChoiceyes() {
        return choiceyes;
    }

    public void setChoiceyes(String choiceyes) {
        this.choiceyes = choiceyes;
    }

    public String getChoiceno() {
        return choiceno;
    }

    public void setChoiceno(String choiceno) {
        this.choiceno = choiceno;
    }
}
