package com.laputa.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    public void test(View v){
    	AbstractLaputaDialog dialog = new LaputaAlertDialog(this, R.layout.view_laputa_alert_dialog)
    	.builder()
    	.setCancelable(true)
    	.setCanceledOnTouchOutside(true)
    	.setMsg("舞低杨柳楼心月。。。")
    	;
    	dialog.show();
    }
}
