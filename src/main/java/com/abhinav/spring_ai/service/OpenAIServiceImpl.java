package com.abhinav.spring_ai.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import com.abhinav.spring_ai.model.Answer;
import com.abhinav.spring_ai.model.Question;

@Service
public class OpenAIServiceImpl implements OpenAIService {

	private ChatClient chatClient;

	public OpenAIServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

	@Override
	public Answer getAnswer(Question question) {
		PromptTemplate promptTemplate = new PromptTemplate(question.question());
		Prompt prompt = promptTemplate.create();
		Instant before = Instant.now();
		System.out.println("*************************************************");
		System.out.println("API invoked at "+new Date());
		ChatResponse response = chatClient.call(prompt);
		Instant after = Instant.now();
		System.out.println("Response received at "+new Date());
		System.out.println("Time taken: "+Duration.between(before, after).toSeconds()+" seconds");
		System.out.println("*************************************************");
		return new Answer(response.getResult().getOutput().getContent());
	}

}
