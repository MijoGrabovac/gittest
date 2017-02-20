package com.example.zoran.pointerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by Zoran on 06.02.2017..
 */

public class Gallery extends AppCompatActivity {

    ImageView mImageView;
    private static final int REQUEST_OPEN_RESULT_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        mImageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_OPEN_RESULT_CODE);

    }
    /** REQUEST_OPEN_RESULT_CODE = IMAGE_GALLERY_REQUEST*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resulData) {
        if (requestCode == REQUEST_OPEN_RESULT_CODE && resultCode == RESULT_OK) {
            Uri uri = null;
            if (resulData != null) {
                uri = resulData.getData();
                try {
                    Bitmap bitmap = getBitmapFromUri(uri);
                    mImageView.setImageBitmap(bitmap);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private Bitmap getBitmapFromUri (Uri uri) throws IOException{
        ParcelFileDescriptor parcelFileDescriptor =getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return bitmap;
    }


}