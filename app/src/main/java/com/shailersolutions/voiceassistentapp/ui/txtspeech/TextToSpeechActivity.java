package com.shailersolutions.voiceassistentapp.ui.txtspeech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.shailersolutions.voiceassistentapp.R;
import com.shailersolutions.voiceassistentapp.databinding.ActivityTextToSpeechBinding;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity {
private ActivityTextToSpeechBinding binding;
    private TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_text_to_speech);

        binding.btnTxt.setOnClickListener(view -> {
            tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i==TextToSpeech.SUCCESS){
                        tts.setLanguage(Locale.ENGLISH);
                        tts.setSpeechRate(1.0f);
                        tts.speak(binding.etTxt.getText().toString().trim(), TextToSpeech.QUEUE_ADD,null);

                    }
                }
            });
        });





    }
}