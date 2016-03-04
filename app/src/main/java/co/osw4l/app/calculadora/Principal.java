package co.osw4l.app.calculadora;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    public EditText numero_1, numero_2;
    public TextView resultado;
    public String salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        numero_1 = (EditText) findViewById(R.id.numero_1);

        numero_2 = (EditText) findViewById(R.id.numero_2);


        Button boton_suma = (Button) findViewById(R.id.suma),
                boton_resta = (Button) findViewById(R.id.resta),
                boton_multiplicacion = (Button) findViewById(R.id.multiplicacion),
                boton_division = (Button) findViewById(R.id.division);

        resultado = (TextView) findViewById(R.id.resultado);

        boton_suma.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if (numero_1.length() > 0 && numero_2.length() > 0)
                            operacion('+');
                        else
                            toast("suma");
                    }
                });

        boton_resta.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if (numero_1.length() > 0 && numero_2.length() > 0)
                            operacion('-');
                        else
                            toast("resta");
                    }
                });

        boton_multiplicacion.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if (numero_1.length() > 0 && numero_2.length() > 0)
                            operacion('*');
                        else
                            toast("multiplicacion");
                    }
                });


        boton_division.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if (numero_1.length() > 0 && numero_2.length() > 0)
                            operacion('/');
                        else
                            toast("division");
                    }
                });


    }

    protected void operacion(char operador) {
        switch (operador) {
            case '+':
                salida = numero_1.getText().toString() + " + " + numero_2.getText().toString()
                        + " = " + (Integer.parseInt(numero_1.getText().toString()) + Integer.parseInt(numero_2.getText().toString()));
                break;
            case '-':
                salida = numero_1.getText().toString() + " - " + numero_2.getText().toString()
                        + " = " + (Integer.parseInt(numero_1.getText().toString()) - Integer.parseInt(numero_2.getText().toString()));
                break;
            case '*':
                salida = numero_1.getText().toString() + " x " + numero_2.getText().toString()
                        + " = " + (Integer.parseInt(numero_1.getText().toString()) * Integer.parseInt(numero_2.getText().toString()));
                break;

            case '/':
                salida = numero_1.getText().toString() + " / " + numero_2.getText().toString()
                        + " = " + (Double.parseDouble(numero_1.getText().toString()) / Double.parseDouble(numero_2.getText().toString()));
                break;
        }
        resultado.setText(salida);
    }

    protected void toast(String op) {
        Toast.makeText(this, "debe completar todos los campos para poder hacer esta " + op, Toast.LENGTH_SHORT).show();
    }

}
