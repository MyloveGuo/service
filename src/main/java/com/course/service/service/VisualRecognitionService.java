package com.course.service.service;


import com.ibm.watson.visual_recognition.v3.model.ClassifierResult;

import java.util.List;

public interface VisualRecognitionService {
    List<ClassifierResult> recognition(String url);
}
