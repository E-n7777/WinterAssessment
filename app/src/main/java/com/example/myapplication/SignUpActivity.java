package com.example.myapplication;

import static com.example.myapplication.R.id.tv_login_back;
import static com.example.myapplication.Util.Post.getPostData;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.HashMap;
/**
 * description ：注册界面
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEtSignUpUsername;
    private EditText mEtPassword1;
    private EditText mEtPassword2;
    private Button mBtnRegister;
    private TextView mTvBack;
    private String mUsername;
    private String mPassword;
    private String mRePassword;
    private String mUrl = "https://www.wanandroid.com/user/register";
    private HashMap<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
        initClick();
    }

    private void initView() {
        mEtSignUpUsername = findViewById(R.id.et_sign_up_username);
        mEtPassword1 = findViewById(R.id.et_sign_up_password);
        mEtPassword2 = findViewById(R.id.et_confirm_password);
        mBtnRegister = findViewById(R.id.btn_register);
        mTvBack = findViewById(tv_login_back);
    }

    private void initClick() {
        mBtnRegister.setOnClickListener(this);
        mTvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_login_back) {
            Toast.makeText(SignUpActivity.this, "请登录", Toast.LENGTH_SHORT).show();
            finish();
        } else if (v.getId() == R.id.btn_register) {
            mUsername = mEtSignUpUsername.getText().toString();
            mPassword = mEtPassword1.getText().toString();
            mRePassword = mEtPassword2.getText().toString();
            params = new HashMap<>();
            params.put("username", mUsername);
            params.put("password", mPassword);
            params.put("repassword", mRePassword);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String result = getPostData(mUrl, params);
                    Log.d("signup", "result-->" + result);
                    //主线程
                    goToUI(result);
                }
            }).start();
        }
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
                        Toast.makeText(SignUpActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(SignUpActivity.this, "注册成功！请重新登录~", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
