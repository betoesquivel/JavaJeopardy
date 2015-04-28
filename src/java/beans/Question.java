/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.fasterxml.jackson.jr.ob.JSON;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Question(String json) {
        try {
            Map<String, Object> map = JSON.std.mapFrom(json);
            this.id = (int) map.get("id");
            this.question = (String) map.get("question");
            this.answer = (String) map.get("answer");
            this.level = (int) map.get("level");
            this.fkCategory = (int) map.get("fkCategory");
            this.fkClass = -1;
        } catch (IOException ex) {
            Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
        }

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
}
