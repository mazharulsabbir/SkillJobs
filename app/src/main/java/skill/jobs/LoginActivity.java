package skill.jobs;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = findViewById(R.id.textView3);

        Button skipLogin = findViewById(R.id.skip_login);
        skipLogin.setOnClickListener(this);

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
                Button btnRegistration = findViewById(R.id.btRegistration);
                //ImageView appLogo = findViewById(R.id.imageView);
                TextView txtPartner = findViewById(R.id.textView2);
                TextView txtHeading = findViewById(R.id.txt_heading);
                TextView textView = findViewById(R.id.textView3);

                Intent sharedIntent = new Intent(LoginActivity.this, RegistrationActivity.class);

                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(textView, "txt_login_or_register");
                //pairs[1] = new Pair<View, String>(appLogo, "ic_app_logo");
                pairs[1] = new Pair<View, String>(txtPartner, "txt_partner");
                pairs[2] = new Pair<View, String>(btnRegistration, "btn_register");
                pairs[3] = new Pair<View, String>(txtHeading, "txt_headings");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());

                }
            }
        });
    }

    public void btnSignInClicked(View view) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skip_login:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
