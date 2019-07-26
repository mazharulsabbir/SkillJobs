package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);

        Button skipLogin = findViewById(R.id.skip_login);
        skipLogin.setOnClickListener(this);

        Button btnRegistration = findViewById(R.id.btRegistration);
        btnRegistration.setOnClickListener(this);

        Button loginButton = findViewById(R.id.btn_sign_in);
        loginButton.setOnClickListener(this);
    }
    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.skip_login:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.btRegistration:
                Intent sharedIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(sharedIntent);
                break;

            case R.id.btn_sign_in:
                if (!validateEmail() | !validatePassword()) {
                    return;
                }

                String userEmail = textInputEmail.getEditText().getText().toString();
                String userPassword = textInputPassword.getEditText().getText().toString();

                Toast.makeText(this, "No User Found. Try Another!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
