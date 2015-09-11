package com.hnudeal.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.hnudeal.main.MainActivity;
import com.hnudeal.main.R;


public class LoginActivity extends AppCompatActivity {

    private TextView mTextDetails;
    private CallbackManager mCallbackManger;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mprofileTracker;

    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
//            displayWelcomemesssage(profile);
//            mTokenTracker.startTracking();
//            mprofileTracker.startTracking();

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        mCallbackManger = CallbackManager.Factory.create();
        AccessTokenTracker tracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken old, AccessToken newToken) {

            }
        };
        ProfileTracker profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {

            }
        };

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login, container, false);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onViewCreated(View view, Bundle savedInstanceState) {

        //super.onViewCreated(view, savedInstanceState);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setActivated(true);
        loginButton.registerCallback(mCallbackManger, mCallback);
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
//        displayWelcomemesssage(profile);
    }

    @Override
    public void onStop() {
        super.onStop();
//        mTokenTracker.stopTracking();
//        mprofileTracker.startTracking();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManger.onActivityResult(requestCode, resultCode, data);
//        mCallbackManger.onActivityResult(requestCode,resultCode,data);
    }

    //메인으로 가기
    public void moveMainActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }


}
