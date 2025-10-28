package com.example.personal_therapy; // 본인의 패키지명

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.personal_therapy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 기분 체크 SeekBar 리스너 설정
        binding.scrollView.findViewById(R.id.seekBarMood).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // progress는 0-9 값이므로 +1 해서 1-10 값으로 표시
                String moodValue = String.valueOf(progress + 1);
                binding.scrollView.findViewById(R.id.tvMoodValue).setText(moodValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // 2. 기분 분석하기 버튼 리스너
        binding.scrollView.findViewById(R.id.btnAnalyzeMood).setOnClickListener(v -> {
            String currentMood = binding.scrollView.findViewById(R.id.tvMoodValue).getText().toString();
            Toast.makeText(this, "현재 기분: " + currentMood, Toast.LENGTH_SHORT).show();
            // TODO: 기분 분석 결과 화면으로 이동
        });

        // 3. 메뉴 카드 클릭 리스너 (예시)
        binding.scrollView.findViewById(R.id.cardDiagnosis).setOnClickListener(v -> {
            Toast.makeText(this, "정신건강 진단 클릭", Toast.LENGTH_SHORT).show();
        });

        binding.scrollView.findViewById(R.id.cardHealing).setOnClickListener(v -> {
            Toast.makeText(this, "힐링 콘텐츠 클릭", Toast.LENGTH_SHORT).show();
        });

        // 4. 긴급 전화 버튼
        binding.scrollView.findViewById(R.id.btnEmergencyCall).setOnClickListener(v -> {
            // TODO: 전화 권한 확인 필요
            // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1393"));
            // startActivity(intent);
            Toast.makeText(this, "1393 전화 연결", Toast.LENGTH_SHORT).show();
        });

        // 5. 하단 네비게이션 탭 선택 리스너 (예시)
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                // 홈 (현재 화면)
                return true;
            } else if (itemId == R.id.nav_consult) {
                Toast.makeText(this, "상담 클릭", Toast.LENGTH_SHORT).show();
                // TODO: 상담 Fragment/Activity로 이동
                return true;
            } else if (itemId == R.id.nav_track) {
                Toast.makeText(this, "추적 클릭", Toast.LENGTH_SHORT).show();
                // TODO: 추적 Fragment/Activity로 이동
                return true;
            } else if (itemId == R.id.nav_profile) {
                Toast.makeText(this, "프로필 클릭", Toast.LENGTH_SHORT).show();
                // TODO: 프로필 Fragment/Activity로 이동
                return true;
            }
            return false;
        });

        // 기본으로 홈 메뉴가 선택되도록 설정
        binding.bottomNavView.setSelectedItemId(R.id.nav_home);
    }
}