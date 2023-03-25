package com.simple.examapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class ImageDetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView share;
    private static final String DRAWABLE_RESOURE = "resource";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        imageView = (ImageView)findViewById(R.id.shareimage);
        share = (ImageView) findViewById(R.id.share);

        int drawbleResource = getIntent().getIntExtra(DRAWABLE_RESOURE, 0);
        imageView.setImageResource(drawbleResource);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Now share image function will be called
                // here we  will be passing the text to share
                // Getting drawable value from image
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                shareImageandText(bitmap);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    private void shareImageandText(Bitmap bitmap) {
        Uri uri = getmageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image");

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

        // setting type to image
        intent.setType("image/png");

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    // Retrieving the url to share
    private Uri getmageToShare(Bitmap bitmap) {
        File imagefolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "shared_image.png");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(this, "com.anni.shareimage.fileprovider", file);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }
}