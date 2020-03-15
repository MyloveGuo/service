package com.course.service.controller;

import com.course.service.dto.CommonResult;
import com.course.service.service.TextToSpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextToSpeechController {

    @Autowired
    TextToSpeechService speechService;

    @GetMapping("/test")
    public Object test(){
        return new CommonResult().success("success");
    }

    @GetMapping("/textToSpeech")
    @ResponseBody
    public Object textToSpeech(String text) {
        String url = speechService.textToSpeech(text);
        return new CommonResult().success(url);
    }
}
