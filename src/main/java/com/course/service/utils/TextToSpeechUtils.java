package com.course.service.utils;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class TextToSpeechUtils {
    private static  Authenticator authenticator = new IamAuthenticator("nXdsf2IRKCAxhEQ4Yu6ku23m7dm7nQ5IvYLbgFPhgenR");
    private TextToSpeech service = new TextToSpeech(authenticator);
    private String url = "https://api.jp-tok.text-to-speech.watson.cloud.ibm.com/instances/fb977f4b-3a6e-48a5-8233-de26490f5e85";
    public static int count = 0;
    public int textToSpeech(String text){
        service.setServiceUrl(url);
        try {
            SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
                    .text(text)
                    .accept("audio/wav")
                    .voice("en-US_AllisonVoice")
                    .build();

            InputStream inputStream =
                    service.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);
            OutputStream out = new FileOutputStream(new File("E:/test/"+(count++)+".wav"));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count - 1;
    }
}
