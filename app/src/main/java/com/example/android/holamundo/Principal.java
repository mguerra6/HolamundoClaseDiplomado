package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajanumero1;
    private EditText cajanumero2;
    private TextView cajaresultado;
    private Spinner comboOpciones;
    private String[] opciones;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajanumero1 = (EditText)findViewById(R.id.txtnumero1);
        cajanumero2 = (EditText)findViewById(R.id.txtnumero2);
        cajaresultado =(TextView)findViewById(R.id.txtresultado);
        comboOpciones =(Spinner)findViewById(R.id.cmdoperaciones);

        opciones = this.getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones);
        comboOpciones.setAdapter(adapter);
    }

    public void Calcular(View v)
    {
        int op;
        double n1, n2, res = 0;
        if(validar())
        {
            n1 = Double.parseDouble(cajanumero1.getText().toString());
            n2 = Double.parseDouble(cajanumero2.getText().toString());
            op = comboOpciones.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1 + n2;
                    break;
                case 1:
                    res = n1 - n2;
                    break;
                case 2:
                    res = n1 * n2;
                    break;
                case 3:
                    res = n1 / n2;
                    break;
            }
            cajaresultado.setText(""+res);
            cajanumero1.requestFocus();
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

        if(comboOpciones.getSelectedItemPosition() == 3 && Double.parseDouble(cajanumero2.getText().toString())==0)
        {
            cajanumero2.setError(this.getResources().getString(R.string.error_division));
            cajanumero2.requestFocus();
            return false;
        }
        return true;
    }
}
