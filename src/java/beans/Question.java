/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author betoesquivel
 */
public class Question {
    
    private int id;
    private String question;
    private String answer;
    private String difficulty;

    public Question() {
        id = 0;
        question = null;
        answer = null;
        difficulty = null;
    }

    public Question(int id, String question, String answer, String difficulty) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    
    
}
