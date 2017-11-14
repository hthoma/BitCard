package bitcard.cosc431.bitcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
//Harry Thomasian COSC 412
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button vendorbtn, newuserbtn,userbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    private void bindView() {
        vendorbtn = (Button)findViewById(R.id.vendorBtn);
        vendorbtn.setOnClickListener(this);
        newuserbtn = (Button)findViewById(R.id.NewUsrbutton);
        newuserbtn.setOnClickListener(this);
        userbtn = (Button)findViewById(R.id.Usrbutton);
        userbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.NewUsrbutton:
                Intent nuIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://www.google.com"));
                startActivity(nuIntent);
                break;
            case R.id.vendorBtn:
                Intent vIntent =
                        new Intent(this,Vendor_Activity.class);
                startActivity(vIntent);

                break;
            case R.id.Usrbutton:
                Intent uIntent =
                        new Intent(this,User_Activity.class);
                startActivity(uIntent);

                break;


        }


    }
}
