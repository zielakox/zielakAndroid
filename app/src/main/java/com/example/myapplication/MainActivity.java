package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editPhoneNumber;
    private EditText editTextPassword;
    private EditText editTextPasswordCheck;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordCheck = findViewById(R.id.editTextPasswordCheck);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phoneNumber = editPhoneNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordCheck = editTextPasswordCheck.getText().toString().trim();

                if (name.isEmpty() || surname.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Wprowadź imię i nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Wprowadź adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Wprowadź numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Wprowadź hasło", Toast.LENGTH_SHORT).show();
                } else if (passwordCheck.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Potwierdź hasło", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Zły adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.length() < 9)
                {
                    Toast.makeText(MainActivity.this, "Zły numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6)
                {
                    Toast.makeText(MainActivity.this, "Złe hasło", Toast.LENGTH_SHORT).show();
                } else if (!passwordCheck.equals(password))
                {
                    Toast.makeText(MainActivity.this, "Hasła nie są takie same", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz wysłany. ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}