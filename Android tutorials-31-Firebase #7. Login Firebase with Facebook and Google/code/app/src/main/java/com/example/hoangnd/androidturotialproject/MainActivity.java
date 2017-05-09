package com.example.hoangnd.androidturotialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private CallbackManager callbackManager;
    private AccessToken facebookAccessToken;
    private LoginButton btnFacebookLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        btnFacebookLogin = (LoginButton) findViewById(R.id.btnFacebookLogin);
        initializeFacebookLogin();
    }
    public void handleFacebookLogin(View view) {

    }
    private void initializeFacebookLogin() {
        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create();
        btnFacebookLogin.setReadPermissions("email", "public_profile");
        btnFacebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                facebookAccessToken = loginResult.getAccessToken();
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });
    }
}
