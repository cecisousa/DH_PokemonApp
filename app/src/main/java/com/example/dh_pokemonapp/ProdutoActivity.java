package com.example.dh_pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

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

        getValor(getIntent());
        somaTotal();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProdutoActivity.this, CadastroActivity.class));
            }
        });

    }

    private void getValor(Intent intent){
        if (getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();
            ArrayList<Produto> produtos = bundle.getParcelableArrayList(PRODUCT_KEY);

            for (int i = 0; i < produtos.size(); i++){

                if (i == 0) {
                    txtProduct1.setText(produtos.get(i).getNome());
                    txtPrice1.setText(produtos.get(i).getValor());
                    Snackbar.make(txtProduct1, "Produto adicionado!", Snackbar.LENGTH_LONG).show();
                } else if (i == 1) {
                    txtProduct2.setText(produtos.get(i).getNome());
                    txtPrice2.setText(produtos.get(i).getValor());
                    Snackbar.make(txtProduct2, "Produto adicionado!", Snackbar.LENGTH_LONG).show();
                } else if (i == 2) {
                    txtProduct3.setText(produtos.get(i).getNome());
                    txtPrice3.setText(produtos.get(i).getValor());
                    Snackbar.make(txtProduct3, "Produto adicionado!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(txtFinalPrice, "Só podemos cadastrar 3 produtos!", Snackbar.LENGTH_LONG).show();
                }
            }
        } else {
            Snackbar.make(txtProduct1, "Não há dados suficientes", Snackbar.LENGTH_LONG).show();
        }
    }

    public void somaTotal(){
        Integer valor1 = Integer.parseInt(txtPrice1.getText().toString());
        Integer valor2 = Integer.parseInt(txtPrice2.getText().toString());
        Integer valor3 = Integer.parseInt(txtPrice3.getText().toString());
        Integer somaFinal;
        somaFinal = valor1 + valor2 + valor3;
        txtFinalPrice.setText(somaFinal.toString());
    }

}
