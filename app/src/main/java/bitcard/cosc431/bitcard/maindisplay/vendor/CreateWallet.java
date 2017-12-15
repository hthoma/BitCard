package bitcard.cosc431.bitcard.maindisplay.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.params.TestNet2Params;
import org.bitcoinj.wallet.Wallet;

import java.util.ArrayList;

import bitcard.cosc431.bitcard.R;
import bitcard.cosc431.bitcard.database.KeyDataSource;
import bitcard.cosc431.bitcard.models.KeyClass;

public class CreateWallet extends AppCompatActivity implements View.OnClickListener {

    TextView address, key;
    Intent sendKeyOpen;
    String yourkey, youraddress;
    KeyDataSource keydata;
    Wallet wallet;
    ArrayList<KeyClass> keys = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_wallet);
        keydata = new KeyDataSource(getBaseContext());
        wallet = new Wallet(TestNet2Params.get());
        ECKey b = wallet.currentReceiveKey();
        Address c = wallet.freshReceiveAddress();
        keys = keydata.getAllKeys();
        if(keys.isEmpty()) {
            youraddress = c.toString();
            yourkey = b.getPrivateKeyAsHex();
            keydata.addKeyClass(new KeyClass(youraddress));
            address = (TextView) findViewById(R.id.publicKeyTv);
            key = (TextView) findViewById(R.id.privatekeyTv);
            address.setText(youraddress);
            key.setText(yourkey);
        }
        else
            youraddress = keys.get(0).getPublickey();
            yourkey = "We do not save private key data, hope you wrote it down!";
        address = (TextView) findViewById(R.id.publicKeyTv);
        key = (TextView) findViewById(R.id.privatekeyTv);
        address.setText(youraddress);
        key.setText(yourkey);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.keypushBtn:

                sendKeyOpen = new Intent(this, VendorDisplay.class);
               sendKeyOpen.putExtra("privatekey",yourkey);
                sendKeyOpen.putExtra("publickey",youraddress);
                sendKeyOpen.putExtra("test",wallet.getBalance().toFriendlyString());
                sendKeyOpen.putExtra("Message","Wallet created!");
                startActivity(sendKeyOpen);
                finish();
                break;

        }
    }
}
