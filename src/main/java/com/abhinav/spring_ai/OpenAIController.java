package com.abhinav.spring_ai;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.spring_ai.model.Answer;
import com.abhinav.spring_ai.model.Question;
import com.abhinav.spring_ai.service.OpenAIService;

@RestController
public class OpenAIController {

	private OpenAIService openAIService;

	public OpenAIController(OpenAIService openAIService) {
		this.openAIService = openAIService;
	}

	@PostMapping(path = "/getAnswer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Answer> getAnswer(@RequestBody Question question) {
		Answer answer = new Answer();
		answer.setResponse(openAIService.getAnswer(question.getPrompt()));
		return ResponseEntity.ok().body(answer);
	}
}
