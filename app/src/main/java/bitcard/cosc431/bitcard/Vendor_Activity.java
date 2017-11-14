package bitcard.cosc431.bitcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bitcard.cosc431.bitcard.maindisplay.vendor.VendorDisplay;

public class Vendor_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        Button okbutton;
        okbutton = (Button)findViewById(R.id.gotitvendor);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vIntent =
                        new Intent(Vendor_Activity.this,VendorDisplay.class);
                startActivity(vIntent);
                finish();
            }
        });

    }

}
