package com.example.personal_therapy; // 본인의 패키지명으로 변경

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.personal_therapy.databinding.ActivityDiagnosisBinding; // ViewBinding 임포트

public class DiagnosisActivity extends AppCompatActivity {

    private ActivityDiagnosisBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiagnosisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 뒤로가기 버튼 클릭 -> 현재 액티비티 종료
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 2. 우울증 카드 클릭
        binding.scrollView.findViewById(R.id.cardDepression).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 우울증 진단 화면으로 이동
                Toast.makeText(DiagnosisActivity.this, "우울증 진단 시작", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. 불안장애 카드 클릭
        binding.scrollView.findViewById(R.id.cardAnxiety).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 불안장애 진단 화면으로 이동
                Toast.makeText(DiagnosisActivity.this, "불안장애 진단 시작", Toast.LENGTH_SHORT).show();
            }
        });

        // 4. 스트레스 카드 클릭
        binding.scrollView.findViewById(R.id.cardStress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 스트레스 진단 화면으로 이동
                Toast.makeText(DiagnosisActivity.this, "스트레스 진단 시작", Toast.LENGTH_SHORT).show();
            }
        });

        // 5. 자살위험성 카드 클릭
        binding.scrollView.findViewById(R.id.cardSuicide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 자살위험성 평가 화면으로 이동
                Toast.makeText(DiagnosisActivity.this, "자살위험성 평가 시작", Toast.LENGTH_SHORT).show();
            }
        });
    }
}