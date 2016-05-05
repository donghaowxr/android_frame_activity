package com.example.activitygroupdemo;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;


@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {
	private RelativeLayout rlBody;
	private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlBody=(RelativeLayout) findViewById(R.id.rlBody);
        btnShow=(Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rlBody.removeAllViews();
				Intent intent=new Intent(MainActivity.this, BodyActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				View view=getLocalActivityManager().startActivity("bodyActivity", intent).getDecorView();
				rlBody.addView(view);
			}
		});
    }
}
