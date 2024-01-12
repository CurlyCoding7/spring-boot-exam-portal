package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    private String content;
    private String image;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    
    private String answer;

    @Transient
    private String givenAnswer;


    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;


    @JsonIgnore
    public String getAnswer() {
        return answer;
    }


    @JsonProperty
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    


}
