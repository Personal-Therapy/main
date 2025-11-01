package com.example.personal_therapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.personal_therapy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                loadFragment(new HomeFragment(), "HOME"); // 홈 프래그먼트
                return true;
            } else if (itemId == R.id.nav_track) {
                loadFragment(new TrackFragment(), "TRACK"); // '추적' 프래그먼트 연결
                return true;
            }
            // ... (다른 탭들)
            return false;
        });

        // 앱 실행 시 기본으로 '홈' 프래그먼트 로드
        if (savedInstanceState == null) {
            binding.bottomNavView.setSelectedItemId(R.id.nav_home);
            loadFragment(new HomeFragment(), "HOME");
        }
    }

    private void loadFragment(Fragment fragment, String tag) {
        // ... (프래그먼트 교체 로직)
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment existingFragment = fragmentManager.findFragmentByTag(tag);
        if (existingFragment != null) {
            transaction.show(existingFragment);
        } else {
            transaction.add(R.id.fragment_container, fragment, tag);
        }
        for (Fragment frag : fragmentManager.getFragments()) {
            if (frag != fragment) {
                transaction.hide(frag);
            }
        }
        transaction.commit();
    }
}