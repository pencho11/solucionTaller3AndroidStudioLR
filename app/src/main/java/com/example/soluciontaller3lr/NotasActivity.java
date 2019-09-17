package com.example.soluciontaller3lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soluciontaller3lr.basesdedatos.AdminSQLiteOpenHelper;
import com.example.soluciontaller3lr.notas.NotasString;

public class NotasActivity extends AppCompatActivity {

    private EditText etCodigo ;
    private EditText etNombre;
    private EditText etNota1;
    private EditText etNota2;
    private EditText etNota3;
    private EditText etNota4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        etCodigo = findViewById(R.id.txtCodigo);
        etNombre= findViewById(R.id.txtDescripcion);
        etNota1 = findViewById(R.id.txtNota1);
        etNota2 = findViewById(R.id.txtNota2);
        etNota3 = findViewById(R.id.txtNota3);
        etNota4 = findViewById(R.id.txtNota4);
    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, NotasString.ADMINISTRACION.getMsj()
                , null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();
        String nombre = etNombre.getText().toString();
        String nota1 = etNota1.getText().toString();
        String nota2 = etNota2.getText().toString();
        String nota3 = etNota3.getText().toString();
        String nota4 = etNota4.getText().toString();

        double  calificacion1 = Double.parseDouble(nota1);
        double calificacion2 = Double.parseDouble(nota2);
        double calificacion3 = Double.parseDouble(nota3);
        double calificacion4 = Double.parseDouble(nota4);
        double totalNota;
        totalNota = ((calificacion1 + calificacion2 + calificacion3 + calificacion4) / 4);
        Toast.makeText(this,NotasString.PROMEDIO.getMsj()+ totalNota, Toast.LENGTH_SHORT).show();


        if(!codigo.isEmpty() && !nombre.isEmpty() && !nota1.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put(NotasString.CODIGO.getMsj(), codigo);
            registro.put(NotasString.NOMBRE.getMsj(), nombre);
            registro.put(NotasString.NOTA1.getMsj(), nota1);
            registro.put(NotasString.NOTA2.getMsj(), nota2);
            registro.put(NotasString.NOTA3.getMsj(), nota3);
            registro.put(NotasString.NOTA4.getMsj(), nota4);
            registro.put(NotasString.TOTAL.getMsj(), totalNota);

            baseDeDatos.insert(NotasString.NOTAS.getMsj(), null, registro);

            baseDeDatos.close();
            etCodigo.setText(NotasString.DIMENSION.getMsj());
            etNombre.setText(NotasString.DIMENSION.getMsj());
            etNota1.setText(NotasString.DIMENSION.getMsj());
            etNota2.setText(NotasString.DIMENSION.getMsj());
            etNota3.setText(NotasString.DIMENSION.getMsj());
            etNota4.setText(NotasString.DIMENSION.getMsj());

            Toast.makeText(this,NotasString.REGISTROEXITOSO.getMsj(), Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this, NotasString.REGISTROFALLIDO.getMsj(), Toast.LENGTH_SHORT).show();
        }
    }

}
