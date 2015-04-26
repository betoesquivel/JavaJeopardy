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
    private String level;
    private int fkCategory;
    private int fkClass; 

    public Question() {
        id = 0;
        question = null;
        answer = null;
        level = null;
    }

    public Question(int id, String question, String answer, String difficulty, int fkCategory, int fkClass) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.level = difficulty;
        this.fkCategory = fkCategory;
        this.fkClass = fkClass;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(int fkCategory) {
        this.fkCategory = fkCategory;
    }

    public int getFkClass() {
        return fkClass;
    }

    public void setFkClass(int fkClass) {
        this.fkClass = fkClass;
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
}
