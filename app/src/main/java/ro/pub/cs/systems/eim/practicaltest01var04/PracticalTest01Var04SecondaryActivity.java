package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
    TextView nume;
    TextView grupa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);
        nume = findViewById(R.id.nume);
        grupa = findViewById(R.id.grupa);
        String[] numeGrupa = new String[2];
        numeGrupa = getIntent().getStringArrayExtra("numegrupa");
        nume.setText(numeGrupa[0]);
        grupa.setText(numeGrupa[1]);
    }

    public void ok(View view) {
        Intent intent = new Intent(PracticalTest01Var04SecondaryActivity.this, PracticalTest01Var04MainActivity.class);
        intent.putExtra("rezultat", "OK");
        PracticalTest01Var04SecondaryActivity.this.startActivity(intent);
    }

    public void cancel(View view) {
        Intent intent = new Intent(PracticalTest01Var04SecondaryActivity.this, PracticalTest01Var04MainActivity.class);
        intent.putExtra("rezultat", "Cancel");
        PracticalTest01Var04SecondaryActivity.this.startActivity(intent);
    }
}
