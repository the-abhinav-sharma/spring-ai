package com.abhinav.spring_ai.service;

import com.abhinav.spring_ai.model.Answer;
import com.abhinav.spring_ai.model.Question;

public interface OpenAIService {

	Answer getAnswer(Question question);

}
