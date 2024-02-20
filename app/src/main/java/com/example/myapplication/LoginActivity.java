package com.example.myapplication;

import static com.example.myapplication.Util.Post.getPostData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.HashMap;
/**
 * description ：登录界面
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnLogin;
    private Button mBtnRegister;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private String mUsername;
    private String mPassword;
    private long mExitTime = 0L;
    private HashMap<String, String> params;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initClick();
    }

    private void initView() {
        mBtnLogin = findViewById(R.id.btn_main_login);
        mBtnRegister = findViewById(R.id.btn_main_register);
        mEtUsername = findViewById(R.id.et_main_username);
        mEtPassword = findViewById(R.id.et_main_password);
    }

    private void initClick() {
        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_main_register) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        } else {
            mUsername = mEtUsername.getText().toString();
            mPassword = mEtPassword.getText().toString();
            postRequest();
        }
    }

    private void postRequest() {
        mUrl = "https://www.wanandroid.com/user/login";
        params = new HashMap<>();
        params.put("username", mUsername);
        params.put("password", mPassword);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = getPostData(mUrl, params);
                Log.d("login", "result-->" + result);
                //返回主线程
                goToUI(result);
            }
        }).start();
    }

    private void goToUI(String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.getInt("errorCode");
                    String errorMsg = jsonObject.getString("errorMsg");
                    if (code != 0)
                        Toast.makeText(LoginActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(LoginActivity.this, "欢迎登录~", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent().setClass(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
// 距离上次按返回键的时间 超过了2 秒钟时
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}