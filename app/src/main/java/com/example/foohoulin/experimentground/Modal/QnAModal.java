package com.example.foohoulin.experimentground.Modal;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QnAModal {
    private String askerName;
    private String askerQuestion;
    private String askerProfilePicture;
    private String answerName;
    private String answerAnswer;
    private String answerProfilePicture;

    public QnAModal(String askerName , String askerQuestion , String askerProfilePicture ,String answerName , String answerAnswer , String answerProfilePicture){
        this.askerName = askerName ;
        this.askerQuestion = askerQuestion ;
        this.askerProfilePicture = askerProfilePicture ;
        this.answerName = answerName ;
        this.answerAnswer = answerAnswer ;
        this.answerProfilePicture = answerProfilePicture ;
    }

    public String getAskerName() {
        return askerName;
    }

    public void setAskerName(String askerName) {
        this.askerName = askerName;
    }

    public String getAskerQuestion() {
        return askerQuestion;
    }

    public void setAskerQuestion(String askerQuestion) {
        this.askerQuestion = askerQuestion;
    }

    public String getAskerProfilePicture() {
        return askerProfilePicture;
    }

    public void setAskerProfilePicture(String askerProfilePicture) {
        this.askerProfilePicture = askerProfilePicture;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerAnswer() {
        return answerAnswer;
    }

    public void setAnswerAnswer(String answerAnswer) {
        this.answerAnswer = answerAnswer;
    }

    public String getAnswerProfilePicture() {
        return answerProfilePicture;
    }

    public void setAnswerProfilePicture(String answerProfilePicture) {
        this.answerProfilePicture = answerProfilePicture;
    }


}
