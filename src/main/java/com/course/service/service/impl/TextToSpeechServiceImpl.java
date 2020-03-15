package com.course.service.service.impl;

import com.course.service.service.TextToSpeechService;
import com.course.service.utils.TextToSpeechUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextToSpeechServiceImpl implements TextToSpeechService {

    @Autowired
    TextToSpeechUtils utils;

    @Override
    public String textToSpeech(String text) {
            return "http://localhost:8080/voice/"+utils.textToSpeech(text)+".wav";
    }
}
