package com.fastdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.fastdev.fragment.MainScreenFragment;
import com.fastdev.fragment.data.UserData;

public class MainActivity extends AppCompatActivity {
    private long mExitTime;
    private MainScreenFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        changeView(UserData.getInstance().getUseInfo().getMainIndex());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    //选择页面
    private void changeView(int index) {
        getFragmentManager().findFragmentById(R.id.fragment_root);
        fragment = (MainScreenFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_root);
        UserData.getInstance().getUseInfo().setMainIndex(index);
        fragment.setNavByIndex(index);
    }
}
