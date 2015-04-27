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
    private int level;
    private int fkCategory;
    private String category;
    private int fkClass; 

    public Question() {
        id = 0;
        question = null;
        answer = null;
        level = 0;
    }

    public Question(int id, String question, String answer, int difficulty, int fkCategory) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.level = difficulty;
        this.fkCategory = fkCategory;
        this.fkClass = -1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
