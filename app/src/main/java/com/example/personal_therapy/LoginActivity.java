package com.example.personal_therapy; // 본인의 패키지명으로 변경하세요

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

// 생성된 ViewBinding 클래스를 임포트합니다. (activity_login.xml -> ActivityLoginBinding)
import com.example.personal_therapy.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    // ViewBinding 변수 선언
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewBinding 초기화 및 화면 설정
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // 이제 binding.을 통해 XML의 ID에 접근할 수 있습니다. (카멜 표기법으로 자동 변환됨)

        // 1. 로그인 버튼 클릭 이벤트
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString();
                String password = binding.etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "이메일과 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: 실제 로그인 로직 구현 (서버 통신 등)
                    performLogin(email, password);
                }
            }
        });

        // 2. 비밀번호 찾기 클릭 이벤트
        binding.tvFindPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 비밀번호 찾기 화면으로 이동
                Toast.makeText(LoginActivity.this, "비밀번호 찾기 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Google 로그인 버튼 클릭 이벤트
        binding.btnGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Google 로그인 로직 구현
                Toast.makeText(LoginActivity.this, "Google 로그인 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });

        // 4. 회원가입 텍스트 클릭 이벤트
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 회원가입 화면으로 이동
                Toast.makeText(LoginActivity.this, "회원가입 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });

        // 5. 게스트로 둘러보기 클릭 이벤트
        binding.tvGuestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 메인 화면 (게스트 모드)으로 이동
                Toast.makeText(LoginActivity.this, "게스트 로그인 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });

        // 6. 비밀번호 보이기/숨기기 (drawableEnd)
        // 이 기능은 EditText의 setOnTouchListener와 inputType 변경을 조합해야 합니다. (조금 더 복잡함)
    }

    private void performLogin(String email, String password) {
        // TODO: 여기에 실제 로그인 인증 로직 (서버 통신)

        // 로그인 성공 시
        Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show();

        // MainActivity로 이동
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

        // 로그인 화면은 종료
        finish();
    }
}