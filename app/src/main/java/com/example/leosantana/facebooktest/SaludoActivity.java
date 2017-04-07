package com.example.leosantana.facebooktest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

/**
 * Created by leosantana on 05/04/17.
 */

public class SaludoActivity extends AppCompatActivity {
    Button cerrarSesion ;
    TextView mensaje ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saludo);

        cerrarSesion = (Button)findViewById(R.id.cerrar_sesión_button);
        mensaje = (TextView)findViewById(R.id.mensaje);
        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                if(AccessToken.getCurrentAccessToken()==null){
                 mensaje.setText("se ha cerrado sesión correctamente!");
                }
            }
        });
    }
}
