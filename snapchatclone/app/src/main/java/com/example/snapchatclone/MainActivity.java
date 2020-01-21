package com.example.snapchatclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.snapchatclone.Fragment.CameraFragment;
import com.example.snapchatclone.Fragment.ChatFragment;
import com.example.snapchatclone.Fragment.StoryFragment;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        adapterViewPager = new MyPagerAdater(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
    }

    public static class MyPagerAdater extends FragmentPagerAdapter{

        public MyPagerAdater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return ChatFragment.newInstance();
                case 1:
                    return CameraFragment.newInstance();
                case 2:
                    return StoryFragment.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;  //chat, story, camera
        }
    }
}
