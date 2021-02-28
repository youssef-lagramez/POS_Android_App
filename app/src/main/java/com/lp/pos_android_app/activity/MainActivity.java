package com.lp.pos_android_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.lp.pos_android_app.R;
import com.lp.pos_android_app.fragment.StoreAndCategory;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        StoreAndCategory x = new StoreAndCategory();
        fragmentTransaction.add(R.id.home_container,x);
        fragmentTransaction.commit();
    }

    public void findview(){


    }
}