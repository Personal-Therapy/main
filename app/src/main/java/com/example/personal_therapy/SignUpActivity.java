package com.example.personal_therapy; // 본인의 패키지명으로 변경

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.personal_therapy.databinding.ActivitySignupBinding; // ViewBinding 임포트

import java.util.ArrayList;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 출생년도 스피너 설정
        setupBirthYearSpinner();

        // 2. 회원가입 버튼 클릭 이벤트
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // TODO: 실제 회원가입 로직 구현
                    performSignUp();
                }
            }
        });

        // 3. '로그인' 텍스트 클릭 이벤트 (현재 화면 닫기)
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티(회원가입) 종료
            }
        });
    }

    // 출생년도 스피너를 설정하는 메소드
    private void setupBirthYearSpinner() {
        ArrayList<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        years.add("출생년도 선택"); // 힌트 텍스트

        // 예: 100년 전부터 현재까지 (만 14세 이상 등 정책에 맞게 조절)
        for (int i = currentYear - 14; i >= currentYear - 100; i--) {
            years.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerBirthYear.setAdapter(adapter);
    }

    // 입력 유효성 검사 (간단한 예시)
    private boolean validateInput() {
        String name = binding.etName.getText().toString().trim();
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        String passwordConfirm = binding.etPasswordConfirm.getText().toString().trim();
        int selectedGenderId = binding.rgGender.getCheckedRadioButtonId();
        String birthYear = binding.spinnerBirthYear.getSelectedItem().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(passwordConfirm)) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (birthYear.equals("출생년도 선택")) {
            Toast.makeText(this, "출생년도를 선택하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (selectedGenderId == -1) { // 아무것도 선택되지 않음
            Toast.makeText(this, "성별을 선택하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!binding.cbTerms.isChecked()) {
            Toast.makeText(this, "이용약관에 동의해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!binding.cbPrivacy.isChecked()) {
            Toast.makeText(this, "개인정보 처리방침에 동의해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    // 실제 회원가입 처리
    private void performSignUp() {
        // TODO: 서버로 데이터 전송 (API 호출)
        Toast.makeText(this, "회원가입 성공 (구현 필요)", Toast.LENGTH_SHORT).show();
    }
}