package bitcard.cosc431.bitcard.maindisplay.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bitcard.cosc431.bitcard.R;



public class UserDisplay extends AppCompatActivity implements View.OnClickListener {

    Button addqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_display);
    }

    private void bindView() {
        addqr = (Button) findViewById(R.id.getQr);
        addqr.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getQr:
                Intent nuIntent =
                        new Intent(UserDisplay.this,QrReader.class);
                startActivity(nuIntent);
                break;


        }
    }
}
