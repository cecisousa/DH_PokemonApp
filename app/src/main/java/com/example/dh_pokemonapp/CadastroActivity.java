package com.example.dh_pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.dh_pokemonapp.LoginActivity.NAME_KEY;

public class CadastroActivity extends AppCompatActivity {
    private TextView boasVindas;
    private TextInputLayout txtProduto;
    private TextInputLayout txtValor;
    private Button btnEnviar;

    public static final String PRODUCT_KEY = "product";
    public static final String PRICE_KEY = "price";
    public static final String CONTADOR_KEY = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        boasVindas = findViewById(R.id.textView);
        txtProduto = findViewById(R.id.textInputLayout1);
        txtValor = findViewById(R.id.textInputLayout2);
        btnEnviar = findViewById(R.id.button2);

        Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();
            String name = bundle.getString(NAME_KEY);
            boasVindas.setText("Olá, " + name + "! Cadastre um produto:");
        } else {
            Snackbar.make(boasVindas, "Não há dados!", Snackbar.LENGTH_LONG).show();
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String product = txtProduto.getEditText().getText().toString();
                String price = txtValor.getEditText().getText().toString();

                if (!product.isEmpty() && !price.isEmpty()){
                    Intent intent = new Intent(CadastroActivity.this, ProdutoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(PRODUCT_KEY, product);
                    bundle.putString(PRICE_KEY, price);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (product.isEmpty()){
                    txtProduto.setError("O campo produto deve ser preenchido!");
                } else {
                    txtValor.setError("O campo valor deve ser preenchido!");
                }

            }
        });


    }
}
