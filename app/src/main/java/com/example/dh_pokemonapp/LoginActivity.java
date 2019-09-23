package com.example.dh_pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button btnEntrar;
    private TextInputLayout txtNome;
    private TextInputLayout txtSenha;

    public static final String NAME_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = findViewById(R.id.button);
        txtNome = findViewById(R.id.textInputLayout1);
        txtSenha = findViewById(R.id.textInputLayout2);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtNome.getEditText().getText().toString();
                String password = txtSenha.getEditText().getText().toString();

                if (!name.isEmpty() && !password.isEmpty()){
                    Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(NAME_KEY, name);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (name.isEmpty()){
                    txtNome.setError("O campo nome deve ser preenchido!");
                } else {
                    txtSenha.setError("O campo senha deve ser preenchido!");
                }

            }
        });
    }
}
