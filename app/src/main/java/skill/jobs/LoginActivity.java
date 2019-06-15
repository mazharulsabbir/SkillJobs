package skill.jobs;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = findViewById(R.id.textView3);

        String text = "Login or ";

        SpannableString ss;
        ss = new SpannableString(text);

        StyleSpan boldSpan;
        boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        text = "Register to explore all our new service. We offer you the best career solution.";

        boldSpan = new StyleSpan(Typeface.BOLD);
        ss = new SpannableString(text);
        ss.setSpan(boldSpan, 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.append(ss);

        Button Regi_Button;

        Regi_Button = findViewById(R.id.btRegistration);

        Regi_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }

    public void btnSignInClicked(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
