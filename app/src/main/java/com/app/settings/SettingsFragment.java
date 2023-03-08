package com.app.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment  {
    RadioGroup radioGroup;
    RadioButton radioButton;
    private String selectedLanguage;
    private int userProgress = 0;
    private SeekBar seekBar;
    private TextView progressText;
    private ImageView arrowBack;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.settings_layout, container, false);
         arrowBack = view.findViewById(R.id.arrowBack);
         seekBar = view.findViewById(R.id.seekBar);
         progressText = view.findViewById(R.id.progressText);
         radioGroup = view.findViewById(R.id.radioGroup);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set Current Progress
        progressText.setText(String.valueOf(seekBar.getProgress()));
        userProgress = seekBar.getProgress();

        // Current Default Language
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = view.findViewById(radioId);
        selectedLanguage = String.valueOf(radioButton.getText());

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(),MainActivity.class);
                intent.putExtra("latency",userProgress);
                intent.putExtra("language",selectedLanguage);
                startActivity(intent);
                requireActivity().finish();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressText.setText(String.valueOf(progress));
                userProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = group.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioId);
                selectedLanguage = String.valueOf(radioButton.getText());
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), callback);
    }


    // This callback will only be called when MyFragment is at least Started.
    private final OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
        @Override
        public void handleOnBackPressed() {
            // Handle the back button event

            Intent intent = new Intent(requireActivity(),MainActivity.class);
            intent.putExtra("latency",userProgress);
            intent.putExtra("language",selectedLanguage);
            startActivity(intent);
            requireActivity().finish();

        }
    };

}
