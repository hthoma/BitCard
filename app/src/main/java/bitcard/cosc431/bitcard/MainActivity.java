package bitcard.cosc431.bitcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import bitcard.cosc431.bitcard.database.KeyDataSource;
import bitcard.cosc431.bitcard.maindisplay.user.main.MainUser_;
import bitcard.cosc431.bitcard.maindisplay.vendor.VendorDisplay;
import bitcard.cosc431.bitcard.models.KeyClass;

//Harry Thomasian COSC 412
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    KeyDataSource keydata;
    Button vendorbtn, newuserbtn,userbtn;
    ArrayList<KeyClass> keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        keys = new ArrayList<KeyClass>();
        keys = keydata.getAllKeys();
    }

    private void bindView() {
        vendorbtn = (Button)findViewById(R.id.vendorBtn);
        vendorbtn.setOnClickListener(this);
        newuserbtn = (Button)findViewById(R.id.NewUsrbutton);
        newuserbtn.setOnClickListener(this);
        userbtn = (Button)findViewById(R.id.Usrbutton);
        userbtn.setOnClickListener(this);
        keydata = new KeyDataSource(getBaseContext());

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.NewUsrbutton:
                Intent nuIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://www.google.com"));
                nuIntent.putExtra("Message","Previously created wallet detected, loaded into");
                startActivity(nuIntent);
                break;
            case R.id.vendorBtn:
                if(keys.isEmpty())
                {
                    Intent vIntent =
                            new Intent(this,Vendor_Activity.class);
                    startActivity(vIntent);
                }
            else {
                    Intent vIntent =
                            new Intent(this, VendorDisplay.class);
                    vIntent.putExtra("Message","Previously created wallet detected, loaded into");
                    startActivity(vIntent);

                }
                break;
            case R.id.Usrbutton:
                Intent uIntent =
                        new Intent(this,MainUser_.class);
                startActivity(uIntent);

                break;


        }


    }
}
