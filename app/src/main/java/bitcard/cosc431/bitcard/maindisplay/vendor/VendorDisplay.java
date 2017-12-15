package bitcard.cosc431.bitcard.maindisplay.vendor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;

import bitcard.cosc431.bitcard.R;
import bitcard.cosc431.bitcard.database.KeyDataSource;
import bitcard.cosc431.bitcard.maindisplay.PriceIndex;
import bitcard.cosc431.bitcard.models.KeyClass;

public class VendorDisplay extends AppCompatActivity implements View.OnClickListener {
ImageView QRcode;
    TextView amount;
    String pubCode;
    Button getTransactions,getPrice;
    KeyDataSource keydata;
    ArrayList<KeyClass> keys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_display);
        keydata = new KeyDataSource(getBaseContext());
        keys = keydata.getAllKeys();
        pubCode = keys.get(0).getPublickey();
        Intent i = getIntent();
        getTransactions = (Button)findViewById(R.id.transactions);
        getTransactions.setOnClickListener(this);
        getPrice = (Button)findViewById(R.id.pricecheck);
        getPrice.setOnClickListener(this);
        Toast.makeText(this,i.getStringExtra("Message"),Toast.LENGTH_LONG).show();
        getTransactions.setText("Get Transactions");
        QRcode = (ImageView)findViewById(R.id.QRView);
        createQR();



    }

    private void createQR(){

        String text= pubCode;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,400,400);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            QRcode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.transactions:
                Intent nuIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://blockchain.info/address/" + pubCode));
                nuIntent.putExtra("Message","Previously created wallet detected, loaded into");
                startActivity(nuIntent);
                break;
            case R.id.pricecheck:

                    Intent vIntent =
                            new Intent(this,PriceIndex.class);
                    startActivity(vIntent);

                break;



        }


    }
}
