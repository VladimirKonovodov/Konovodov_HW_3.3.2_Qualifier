package com.example.konovodov_hw_332_qualifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static Button button;

    public static Locale locale;


    private Spinner mLanguagesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setTitle(R.string.app_name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initLanguagesChange(mLanguagesSpinner.getSelectedItem().toString());
            }
        });
    }

    private void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguagesSpinner.setAdapter(adapterLanguages);

        mLanguagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initLanguagesChange(String lang) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (lang) {
            case "Русский": {
                locale = new Locale("ru");
                break;
            }
            case "English": {
                locale = new Locale("en");
                break;
            }
            default:
                break;

        }
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        recreate();
    }

    public void init() {
        button = (Button) findViewById(R.id.button);
        mLanguagesSpinner = findViewById(R.id.languagesSpinner);
        initSpinnerLanguages();
    }
}
