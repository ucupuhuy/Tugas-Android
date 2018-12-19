package com.example.dmswcksno.loginsqlite;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    //deklarasi edittext
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //deklarasi TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //deklarasi Button
    Button buttonRegister;

    //deklarasi SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //mengecek database jika ada user dengan email yang sama
                    if (!sqliteHelper.isEmailExists(Email)) {

                        //validasi username tidak terdaftar tambahkan user ke database
                        sqliteHelper.addUser(new User(null, UserName, Email, Password));
                        Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //validasi email yang dimasukkan sama
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    //method ini digunakan untuk textview login
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //method ini digunakan untuk mengkoneksikan xml view dari objek
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }

    //untuk memvalidasi inputan
    public boolean validate() {
        boolean valid = false;

        //untuk mendapatkan nilai dari edittext
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //validasi username
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("User Name salah!");
        } else {

        }

        //untuk memvalidasi email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Email Salah!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }



        return valid;
    }
}
