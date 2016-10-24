package com.owen.demo.badgeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.owen.library.BadgeView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        View target = findViewById(R.id.btnTarget);
        BadgeView badge = new BadgeView(this, target);
        badge.setText("1");
        badge.show();
    }
}
