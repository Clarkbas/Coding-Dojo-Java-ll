package com.example.coding.Dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.coding.Dojos.Repositories.AnswerRepository;
import com.example.coding.Dojos.Repositories.QuestionRepository;
import com.example.coding.Dojos.Repositories.TagQuestionRepository;
import com.example.coding.Dojos.Repositories.TagRepository;
import com.example.coding.Dojos.models.Answer;
import com.example.coding.Dojos.models.Question;
import com.example.coding.Dojos.models.Tag;
import com.example.coding.Dojos.models.TagQuestion;




@Service
public class DOService {
	private final QuestionRepository qR;
	private final TagRepository tR;
	private final TagQuestionRepository tQR;
	private final AnswerRepository aR;
	
	public DOService(QuestionRepository qR, TagRepository tR, TagQuestionRepository tQR, AnswerRepository aR) {
		this.qR = qR;
		this.tR = tR;
		this.tQR = tQR;
		this.aR = aR;
	}
	
    public Question saveQuestion(Question question) {
        return qR.save(question);
    }
	
	public Tag saveTag(Tag tag) {
		return tR.save(tag);
	}
	
	public Answer saveAnswer(Answer answer) {
		return aR.save(answer);
	}
	
	public TagQuestion saveTagQuestion(TagQuestion tagQuestion) {
		return tQR.save(tagQuestion);
	}
	
    public Tag findSpecificTagbyName(String name) {
        return tR.findBySubjectIgnoreCase(name);
    }
	
	public List<Question> allQuestions(){
		return qR.findAll();
	}
	
	public Question findQuestionById(Long id) {
		Optional<Question> check = qR.findById(id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	
    public void tagCheckAndSave(List<String> tags, Question question) {
        Question saveQuestion = saveQuestion(question);
        for (String check : tags) {
            if (findSpecificTagbyName(check) != null) {
                TagQuestion combine = new TagQuestion();
                combine.setTag(findSpecificTagbyName(check));
                combine.setQuestion(saveQuestion);
                saveTagQuestion(combine);
            } else {
                Tag newTag = new Tag();
                newTag.setSubject(check);
                Tag cTag = saveTag(newTag);
                TagQuestion combine = new TagQuestion();
                combine.setTag(cTag);
                combine.setQuestion(saveQuestion);
                saveTagQuestion(combine);
            }
        }
    }
	
}