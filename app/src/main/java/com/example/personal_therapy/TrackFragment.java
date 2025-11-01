package com.example.personal_therapy; // 본인의 패키지명

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.personal_therapy.databinding.FragmentTrackBinding;

public class TrackFragment extends Fragment {

    private FragmentTrackBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTrackBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 일간/주간/월간 토글 리스너
        binding.rgPeriodToggle.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbDaily) {
                Toast.makeText(getContext(), "일간 보기", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.rbWeekly) {
                Toast.makeText(getContext(), "주간 보기", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.rbMonthly) {
                Toast.makeText(getContext(), "월간 보기", Toast.LENGTH_SHORT).show();
            }
        });

        // 감정 분포 데이터 설정 (예시)
        // ( drawable에 bg_progress_bar_... 5종류가 모두 생성되었다고 가정 )
        setupEmotionBar(binding.barJoy.getRootView(), "기쁨", 55, R.drawable.bg_progress_bar_joy);
        setupEmotionBar(binding.barSadness.getRootView(), "슬픔", 5, R.drawable.bg_progress_bar_sadness);
        setupEmotionBar(binding.barAnxiety.getRootView(), "불안", 15, R.drawable.bg_progress_bar_anxiety);
        setupEmotionBar(binding.barAnger.getRootView(), "분노", 5, R.drawable.bg_progress_bar_anger);
        setupEmotionBar(binding.barCalm.getRootView(), "평온", 20, R.drawable.bg_progress_bar_calm);
    }

    // 감정 바 UI를 설정하는 헬퍼 메소드
    private void setupEmotionBar(View emotionBarView, String name, int progress, int drawableResId) {
        TextView tvName = emotionBarView.findViewById(R.id.tvEmotionName);
        ProgressBar progressBar = emotionBarView.findViewById(R.id.progressBarEmotion);
        TextView tvPercent = emotionBarView.findViewById(R.id.tvEmotionPercent);

        tvName.setText(name);
        progressBar.setProgress(progress);

        // getContext()를 사용하여 drawable을 가져옵니다.
        if (getContext() != null) {
            progressBar.setProgressDrawable(getContext().getDrawable(drawableResId));
        }

        tvPercent.setText(progress + "%");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // 메모리 누수 방지
    }
}