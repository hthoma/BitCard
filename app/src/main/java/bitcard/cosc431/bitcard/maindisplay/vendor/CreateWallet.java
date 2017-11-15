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

import bitcard.cosc431.bitcard.R;

public class CreateWallet extends AppCompatActivity implements View.OnClickListener {

    TextView address, key;
    Intent sendKeyOpen;
    String yourkey, youraddress;

    Wallet wallet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_wallet);

        wallet = new Wallet(TestNet2Params.get());
        ECKey b = wallet.currentReceiveKey();
        Address c = wallet.freshReceiveAddress();

        youraddress = c.toString();
        yourkey = b.getPrivateKeyAsHex();
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
                startActivity(sendKeyOpen);
                finish();
                break;

        }
    }
}
