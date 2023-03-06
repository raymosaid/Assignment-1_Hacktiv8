package com.example.assignment1_hacktiv8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText komentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentar = findViewById(R.id.komentarTextField);
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
        saveDataKomentar(komentar.getText().toString());
        super.onStop();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
        String dataKomentar = ambilDataKomentar();
        komentar.setText(dataKomentar);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    private void saveDataKomentar(String value){
        SharedPreferences.Editor editor = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keyKomentar", value);
        editor.commit();
    }

    private String ambilDataKomentar(){
        String result = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("keyKomentar", null);
        return result;
    }
}