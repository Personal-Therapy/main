package com.example.personal_therapy; // 본인의 패키지명

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.personal_therapy.databinding.FragmentHomeBinding; // ※주의: ActivityMainBinding 아님

public class HomeFragment extends Fragment {

    // 프래그먼트용 바인딩 클래스 사용
    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // XML 레이아웃(fragment_home.xml)을 인플레이트
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // View가 생성된 직후에 로직 실행 (onCreateView 다음)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ▼▼▼ 사용자가 보내준 로직이 여기로 이동 ▼▼▼

        // 1. 기분 체크 SeekBar 리스너 설정
        // ※ binding.scrollView.findViewById 대신 binding.seekBarMood로 직접 접근
        binding.seekBarMood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String moodValue = String.valueOf(progress + 1);
                binding.tvMoodValue.setText(moodValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // 2. 기분 분석하기 버튼 리스너
        binding.btnAnalyzeMood.setOnClickListener(v -> {
            String currentMood = binding.tvMoodValue.getText().toString();
            // Toast의 this 대신 getContext() 또는 getActivity() 사용
            Toast.makeText(getContext(), "현재 기분: " + currentMood, Toast.LENGTH_SHORT).show();
        });

        // 3. 정신건강 진단 카드 클릭
        binding.cardDiagnosis.setOnClickListener(v -> {
            // Intent의 this 대신 getActivity() 사용
            Intent intent = new Intent(getActivity(), DiagnosisActivity.class);
            startActivity(intent);
        });

        // 4. 힐링 콘텐츠 카드 클릭
        binding.cardHealing.setOnClickListener(v -> {
            Toast.makeText(getContext(), "힐링 콘텐츠 클릭", Toast.LENGTH_SHORT).show();
        });

        // 5. 긴급 전화 버튼
        binding.btnEmergencyCall.setOnClickListener(v -> {
            Toast.makeText(getContext(), "1393 전화 연결", Toast.LENGTH_SHORT).show();
        });

        // ▲▲▲ 여기까지가 이동된 로직 ▲▲▲
    }

    // 프래그먼트가 파괴될 때 바인딩 참조 해제 (메모리 누수 방지)
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}