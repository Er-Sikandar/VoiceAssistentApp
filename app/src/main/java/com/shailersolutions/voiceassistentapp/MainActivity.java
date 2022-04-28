package com.shailersolutions.voiceassistentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.shailersolutions.voiceassistentapp.databinding.ActivityMainBinding;
import com.shailersolutions.voiceassistentapp.ui.speechtxt.SpeechTxt2Activity;
import com.shailersolutions.voiceassistentapp.ui.speechtxt.SpeechTxtActivity;
import com.shailersolutions.voiceassistentapp.ui.txtspeech.TextToSpeechActivity;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btnStxt.setOnClickListener(view -> {
            startActivity(new Intent(this, SpeechTxt2Activity.class));
        });

        binding.btnTspeech.setOnClickListener(view -> {
            startActivity(new Intent(this, TextToSpeechActivity.class));
        });

    }
}