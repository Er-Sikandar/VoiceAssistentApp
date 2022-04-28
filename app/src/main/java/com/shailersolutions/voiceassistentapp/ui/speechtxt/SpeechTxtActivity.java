package com.shailersolutions.voiceassistentapp.ui.speechtxt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.shailersolutions.voiceassistentapp.R;
import com.shailersolutions.voiceassistentapp.databinding.ActivitySpeechTxtBinding;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class SpeechTxtActivity extends AppCompatActivity {
    private ActivitySpeechTxtBinding binding;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_speech_txt);
        binding.imgMic.setOnClickListener(view -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");

            try{
                startActivityForResult(intent, 101);
            }catch (Exception e){

            }
        });

        // todo text watcher here...
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Log.e("bb ",charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                Log.e("on ",charSequence.toString());


            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("aff ",editable.toString());
                tts=new TextToSpeech(SpeechTxtActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i==TextToSpeech.SUCCESS){
                            tts.setLanguage(Locale.ENGLISH);
                            tts.setSpeechRate(1.0f);
                            tts.speak(editable.toString(), TextToSpeech.QUEUE_ADD,null);

                        }
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                binding.etSearch.setText(Objects.requireNonNull(result).get(0));

            }
        }

    }
}