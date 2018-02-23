package mx.itesm.dognoscis;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static mx.itesm.dognoscis.photoActivity.PROPERTIES_FILE;

public class HistoryActivity extends AppCompatActivity {
    ImageView image;
    TextView text;
    int quantity;
    Uri imageUri;
    Properties properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        image = findViewById(R.id.imageView2);
        text = findViewById(R.id.textView2);
        properties = new Properties();

        try{
            FileInputStream fis = openFileInput(PROPERTIES_FILE);
            properties.loadFromXML(fis);
            fis.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        quantity = Integer.parseInt(properties.getProperty("quantity"));
        text.setText(properties.getProperty(String.valueOf(quantity)));
        image.setImageURI(Uri.parse(properties.getProperty(String.valueOf(quantity)+"uri")));
    }
}
