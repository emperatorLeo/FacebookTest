package com.example.leosantana.facebooktest;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.xmlpull.v1.XmlPullParser;

import java.util.Arrays;

public class IniciarSecionActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackM;
    private Button customButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_secion_view);
        customButton = (Button)findViewById(R.id.prueba);
        callbackM = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);

       /* loginButton.registerCallback(callbackM, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                openWindows();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"is canceled",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"was an error",Toast.LENGTH_LONG).show();
            }
        });*/

        final FacebookCallback<LoginResult> Fcall = new FacebookCallback<LoginResult>() {
           @Override
           public void onSuccess(LoginResult loginResult) {
              openWindows();
           }

           @Override
           public void onCancel() {

           }

           @Override
           public void onError(FacebookException error) {

           }
       };

        LoginManager.getInstance().registerCallback(callbackM, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                openWindows();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        customButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                loginButton.performClick();
                loginButton.registerCallback(callbackM,Fcall);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackM.onActivityResult(requestCode,resultCode,data);

    }

    private void openWindows(){
        Intent saludo = new Intent(this,SaludoActivity.class);
        startActivity(saludo);
    }

    /*Paginas para consultar
      http://blog.nkdroidsolutions.com/android-facebook-login-example-v4/
      http://stackoverflow.com/questions/18135885/facebook-authentication-without-login-button
      https://code.tutsplus.com/es/tutorials/quick-tip-add-facebook-login-to-your-android-app--cms-23837*/


}
