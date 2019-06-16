package skill.jobs;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    TextView textView, suTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

         textView = findViewById(R.id.textView3);
         suTextView = findViewById(R.id.textView8);

        StringUrlDesgin();


    }

    private void StringUrlDesgin() {
        String text = "Login or ";
        String sutext = "By clicking the button, I agree to the Terms of Service and Privacy Policy.";

        SpannableString ss=new SpannableString(text);;
        SpannableString su=new SpannableString(sutext);


        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(RegistrationActivity.this, "Terms of Service", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpan2=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(RegistrationActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };


        su.setSpan(clickableSpan1,39,55,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        su.setSpan(clickableSpan2,60,74,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        suTextView.setText(su);
        suTextView.setMovementMethod(LinkMovementMethod.getInstance());


        StyleSpan boldSpan;
        boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        text = "Register to explore all our new service. We offer you the best career solution.";

        boldSpan = new StyleSpan(Typeface.BOLD);
        ss = new SpannableString(text);
        ss.setSpan(boldSpan, 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.append(ss);

    }
}
