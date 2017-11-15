package bitcard.cosc431.bitcard.maindisplay.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bitcard.cosc431.bitcard.R;



public class UserDisplay extends AppCompatActivity implements View.OnClickListener {
    EditText publicKeyTv,amountToSend;
    Button addqr,transaction;
    final int QR_REQ_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_display);
        bindView();
        //Forgive me lord for this if statement
        //TODO: Fix lifecycle garbage
        if(getIntent().getStringExtra("ScannedKey") != null)
            publicKeyTv.setText(getIntent().getStringExtra("ScannedKey"));
    }

    private void bindView() {
        addqr = (Button) findViewById(R.id.getQr);
        addqr.setOnClickListener(this);
        publicKeyTv = (EditText) findViewById(R.id.editTextPK);
        transaction = (Button)findViewById(R.id.sendBtc);
        transaction.setOnClickListener(this);
        amountToSend = (EditText) findViewById(R.id.amountEt);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getQr:
                Intent nuIntent =
                        new Intent(UserDisplay.this, QrReader.class);
                startActivity(nuIntent);
                break;
            case R.id.sendBtc:
                if (Double.parseDouble(amountToSend.getText().toString()) < 1.0032984) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Transaction sent!, waiting for confirmation before funds are removed from your Account",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: Insufficient Funds",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }



        }
    }


}
