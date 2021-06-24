package com.jsstech.quizappdemo;

public class QuestionModel {
    private int ansResult;
    private boolean truAns;

    public QuestionModel(int ansResult,boolean truAns) {
        this.ansResult = ansResult;
        this.truAns = truAns;
    }

    public int getAnsResult() {
        return ansResult;
    }

    public void setAnsResult(int ansResult) {
        this.ansResult = ansResult;
    }

    public boolean isTruAns() {
        return truAns;
    }

    public void setTruAns(boolean truAns) {
        this.truAns = truAns;
    }
}
