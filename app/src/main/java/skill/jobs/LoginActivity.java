package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button skipLogin = findViewById(R.id.skip_login);
        skipLogin.setOnClickListener(this);

        Button btnRegistration = findViewById(R.id.btRegistration);
        btnRegistration.setOnClickListener(this);

        Button loginButton = findViewById(R.id.btn_sign_in);
        loginButton.setOnClickListener(this);
    }

    public void btnSignInClicked(View view) {
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

        }
    }
}
