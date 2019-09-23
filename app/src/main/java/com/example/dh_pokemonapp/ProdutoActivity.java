package com.example.dh_pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.dh_pokemonapp.CadastroActivity.PRICE_KEY;
import static com.example.dh_pokemonapp.CadastroActivity.PRODUCT_KEY;

public class ProdutoActivity extends AppCompatActivity {
    private TextView txtProduct1;
    private TextView txtProduct2;
    private TextView txtProduct3;
    private TextView txtPrice1;
    private TextView txtPrice2;
    private TextView txtPrice3;
    private TextView txtFinalPrice;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        txtProduct1 = findViewById(R.id.textView3);
        txtProduct2 = findViewById(R.id.textView5);
        txtProduct3 = findViewById(R.id.textView7);
        txtPrice1 = findViewById(R.id.textView4);
        txtPrice2 = findViewById(R.id.textView6);
        txtPrice3 = findViewById(R.id.textView8);
        txtFinalPrice = findViewById(R.id.textView9);
        btnVoltar = findViewById(R.id.button3);

        Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();
            String product = bundle.getString(PRODUCT_KEY);
            Float price = Float.valueOf(bundle.getString(PRICE_KEY));

            txtProduct1.setText(product);
            txtPrice1.setText("R$ " + String.format("%.2f",price));
        } else {
            Snackbar.make(txtProduct1, "Não há dados", Snackbar.LENGTH_LONG).show();
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProdutoActivity.this, CadastroActivity.class));
            }
        });

    }
}
