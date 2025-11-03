package com.example.mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen; // cần thư viện AndroidX

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Kích hoạt SplashScreen API trước khi setContentView
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash); // layout tùy chỉnh của bạn

        // Có thể thêm animation, logic, hoặc kiểm tra đăng nhập
        new Handler().postDelayed(() -> {

            startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        }, 1500);
    }
}
