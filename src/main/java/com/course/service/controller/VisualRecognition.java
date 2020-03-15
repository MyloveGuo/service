package com.course.service.controller;

import com.course.service.dto.CommonResult;
import com.course.service.service.VisualRecognitionService;
import com.ibm.watson.visual_recognition.v3.model.ClassifierResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisualRecognition {

    @Autowired
    VisualRecognitionService service;


    @GetMapping("/recognition")
    @ResponseBody
    public Object recognition(String url){
        List<ClassifierResult> result = service.recognition(url);
        return new CommonResult().success(result);
    }
}
