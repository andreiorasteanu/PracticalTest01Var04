package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    TextView display;
    Button displayInfo;
    CheckBox checkBox;
    CheckBox checkBox2;

    ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        display = findViewById(R.id.textView);
        displayInfo = findViewById(R.id.button);
        displayInfo.setOnClickListener(buttonClickListener);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        String rezultat = getIntent().getStringExtra("rezultat");
        if(rezultat != null && !rezultat.equals("")){
            Toast.makeText(getApplicationContext(), "Am revenit cu butonul " + rezultat, Toast.LENGTH_SHORT).show();
        }

        String[] restoredStrings = new String[3];
        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey("string")) {
                restoredStrings = (String[]) savedInstanceState.get("string");
                if(restoredStrings != null) {
                    if (restoredStrings[0] != null) {
                        editText1.setText(restoredStrings[0]);
                    }
                    if (restoredStrings[1] != null) {
                        editText2.setText(restoredStrings[1]);
                    }
                    if (restoredStrings[2] != null) {
                        display.setText(restoredStrings[2]);
                    }
                }
            }
        }
    }

    public void gotosecondary(View view) {
        Intent intent = new Intent(PracticalTest01Var04MainActivity.this, PracticalTest01Var04SecondaryActivity.class);
        String[] numeGrupa = new String[2];
        numeGrupa[0] = editText1.getText().toString();
        numeGrupa[1] = editText2.getText().toString();
        intent.putExtra("numegrupa", numeGrupa);
        PracticalTest01Var04MainActivity.this.startActivity(intent);
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String text = "";
            if (checkBox.isChecked()) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nu a fost completat campul 1", Toast.LENGTH_SHORT).show();
                } else {
                    text += editText1.getText().toString();
                    text += " ";
                }
            }
            if (checkBox2.isChecked()) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nu a fost completat campul 1", Toast.LENGTH_SHORT).show();
                } else {
                    text += editText2.getText().toString();
                }
            }
            display.setText(text);
        }
    }


    public void onSaveInstanceState(@NonNull Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        String[] savedStrings = new String[3];
        savedStrings[0] = editText1.getText().toString();
        savedStrings[1] = editText2.getText().toString();
        savedStrings[2] = display.getText().toString();
        savedInstanceState.putStringArray("string", savedStrings);
    }
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String[] restoredStrings = new String[3];
        if(savedInstanceState.containsKey("string")){
            restoredStrings = (String[]) savedInstanceState.get("string");
            if(restoredStrings != null) {
                if (restoredStrings[0] != null) {
                    editText1.setText(restoredStrings[0]);
                }
                if (restoredStrings[1] != null) {
                    editText2.setText(restoredStrings[1]);
                }
                if (restoredStrings[2] != null) {
                    display.setText(restoredStrings[2]);
                }
            }
        }

    }
}
