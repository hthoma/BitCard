package bitcard.cosc431.bitcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bitcard.cosc431.bitcard.maindisplay.user.UserDisplay;

public class User_Activity extends AppCompatActivity {
    Button okbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_);
        Button okbutton;
        okbutton = (Button) findViewById(R.id.button4ok);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vIntent =
                        new Intent(User_Activity.this, UserDisplay.class);
                startActivity(vIntent);
                finish();
            }
        });

    }
}


