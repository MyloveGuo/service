package com.course.service.service.impl;

import com.course.service.service.VisualRecognitionService;
import com.course.service.utils.VisualRecognitionUtils;
import com.ibm.watson.visual_recognition.v3.model.ClassifierResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualRecognitionServiceImpl implements VisualRecognitionService {

    @Autowired
    VisualRecognitionUtils utils;

    @Override
    public List<ClassifierResult> recognition(String url) {
        return utils.recognition(url).getImages().get(0).getClassifiers();
    }
}
