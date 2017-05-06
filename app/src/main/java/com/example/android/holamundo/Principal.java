package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajanumero1;
    private EditText cajanumero2;
    private TextView cajaresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajanumero1 = (EditText)findViewById(R.id.txtnumero1);
        cajanumero2 = (EditText)findViewById(R.id.txtnumero2);
        cajaresultado =(TextView)findViewById(R.id.txtresultado);
    }

    public void Calcular(View v)
    {
        if(validar())
        {
            double n1, n2, suma;
            n1 = Integer.parseInt(cajanumero1.getText().toString());
            n2 = Integer.parseInt(cajanumero2.getText().toString());
            suma = n1 + n2;
            cajaresultado.setText(""+suma);
        }


    }

    public void Borrar(View v)
    {
        cajanumero1.setText("");
        cajanumero2.setText("");
        cajaresultado.setText("");
        cajanumero1.requestFocus();
    }

    public boolean validar()
    {
        if(cajanumero1.getText().toString().isEmpty())
        {
            cajanumero1.setError(this.getResources().getString(R.string.error_numero1));
            cajanumero1.requestFocus();
            return false;
        }
        else if(cajanumero2.getText().toString().isEmpty())
        {
            cajanumero2.setError(this.getResources().getString(R.string.error_numero2));
            cajanumero2.requestFocus();
            return false;
        }
        return true;
    }
}
