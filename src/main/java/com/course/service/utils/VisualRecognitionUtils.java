package com.course.service.utils;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class VisualRecognitionUtils {
    public static Authenticator authenticator = new IamAuthenticator("HR3VZNgVwWBQjT6kev2b3niKQOeLXvC6aeFg-LLzYTAv");

    public static VisualRecognition service = new VisualRecognition("2018-03-19", authenticator);
    private static String url = "https://api.kr-seo.visual-recognition.watson.cloud.ibm.com/instances/fa479873-c441-47de-ace0-23b2b9137c7d";

    public ClassifiedImages recognition(String image){
        service.setServiceUrl(url);
        ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                .url(image)
                .classifierIds(Collections.singletonList("food"))
                .build();
        ClassifiedImages result = service.classify(classifyOptions).execute().getResult();
        return result;
    }
}
