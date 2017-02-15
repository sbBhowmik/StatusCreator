package com.rupik.fbstatuscreator;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.appodeal.ads.Appodeal;
import com.mvc.imagepicker.ImagePicker;
import com.vstechlab.easyfonts.EasyFonts;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import me.priyesh.chroma.ChromaDialog;
import me.priyesh.chroma.ColorMode;
import me.priyesh.chroma.ColorSelectListener;


public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;
    private static final int  MY_PERMISSIONS_REQUEST_READ_STORAGE = 1;
    private static final int  MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 2;

    private EditText mEditor;

    ImageButton bgSelector1;
    ImageButton bgSelector2;
    ImageButton bgSelector3;
    ImageButton bgSelector4;
    ImageButton bgSelector5;
    ImageButton bgSelector6;
    ImageButton bgSelector7;

    boolean isBold;
    boolean isItalics;



    //https://github.com/wasabeef/richeditor-android/blob/master/sample/src/main/java/jp/wasabeef/sample/MainActivity.java
//    private RichEditor mEditor;


    int textColor = Color.parseColor("#ffffff");

    @Override
    public void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissionReadStorage(this, this);


        String appKey = "530fc2c42a02ea25302330d43d2a41e3c86c5f1d4a22c391";
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.BANNER | Appodeal.MREC);

        Appodeal.show(this, Appodeal.BANNER_TOP);
        Appodeal.show(this, Appodeal.BANNER_BOTTOM);


        mEditor = (EditText) findViewById(R.id.editor);
        mEditor.bringToFront();

        ImagePicker.setMinQuality(600, 600);

//        int colors[] = { 0xff255779, 0xffa6c0cd };

        int colors[] = { Color.parseColor("#f4aa42"), Color.parseColor("#f48642"), Color.parseColor("#f46242"), Color.parseColor("#f45642") };

        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(Color.parseColor("#b17ce2"));
        gd.setColors(colors);
        mEditor.setBackground(gd);

//        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Pacifico.ttf");
        mEditor.setTypeface(EasyFonts.captureIt2(this));

        final ImageButton boldBtn = (ImageButton)findViewById(R.id.boldBtn);
        boldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBold)
                {
                    isBold = false;
                    boldBtn.setImageResource(R.drawable.bold_normal);
                }
                else {
                    isBold = true;
                    boldBtn.setImageResource(R.drawable.bold_selected);
                }

                setStyle();
            }
        });

        final ImageButton ItalicsBtn = (ImageButton)findViewById(R.id.ItalicsBtn);
        ItalicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isItalics)
                {
                    isItalics = false;
                    ItalicsBtn.setImageResource(R.drawable.italics_normal);
                }
                else {
                    isItalics = true;
                    ItalicsBtn.setImageResource(R.drawable.italics_selected);
                }
                setStyle();
            }
        });

        ImageButton BlueColorBtn = (ImageButton)findViewById(R.id.BlueColorBtn);
        BlueColorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new ChromaDialog.Builder()
                        .initialColor(textColor)
                        .colorMode(ColorMode.RGB) // There's also ARGB and HSV
                        .onColorSelected(new ColorSelectListener() {
                            @Override public void onColorSelected(int color) {
                                mEditor.setTextColor(color);
                                textColor = color;
                            }
                        })
                        .create()
                        .show(getSupportFragmentManager(), "ChromaDialog");

            }
        });

        ImageButton fontSelectionBtn = (ImageButton) findViewById(R.id.FontPickerBtn) ;
        fontSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FontSelectionActivity.class);
                startActivityForResult(i, 101);
            }
        });

        ImageButton bgSelectionBtn = (ImageButton)findViewById(R.id.BgPickerBtn);
        bgSelectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BackgroundSelectionActivity.class);
                startActivityForResult(i, 102);
            }
        });

        ImageButton shareBtn = (ImageButton)findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //take screenshot
                RelativeLayout editTextRelativeLayoutID = (RelativeLayout)findViewById(R.id.editTextRelativeLayoutID);
                bitmap = Bitmap.createBitmap(
                        editTextRelativeLayoutID.getWidth(),
                        editTextRelativeLayoutID.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(bitmap);
                editTextRelativeLayoutID.draw(c);
                //

//                Appodeal.show(MainActivity.this, Appodeal.MREC);
//                Appodeal.show(MainActivity.this, Appodeal.INTERSTITIAL);

                shareImage();
                //

            }
        });

        bgSelector1 = (ImageButton)findViewById(R.id.bgSelector1);
        bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
        bgSelector1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg1(false,false));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                //
            }
        });

        bgSelector2 = (ImageButton)findViewById(R.id.bgSelector2);
        bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
        bgSelector2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg2(false,false));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
            }
        });

        bgSelector3 = (ImageButton)findViewById(R.id.bgSelector3);
        bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
        bgSelector3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg3(false,false));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
            }
        });

        bgSelector4 = (ImageButton)findViewById(R.id.bgSelector4);
        bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
        bgSelector4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg4(false,false));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
            }
        });

        bgSelector5 = (ImageButton)findViewById(R.id.bgSelector5);
        bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
        bgSelector5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg5(false,false));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
            }
        });

        bgSelector6 = (ImageButton)findViewById(R.id.bgSelector6);
        bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
        bgSelector6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg6(false,false));
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(true, true));

                //
                //
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
                //
            }
        });

        bgSelector7 = (ImageButton)findViewById(R.id.bgSelector7);
        bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(false, true));
        bgSelector7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.setBackground(new Utilities().getDrawableButtonBg7(false,false));
                bgSelector7.setBackground(new Utilities().getDrawableButtonBg7(true, true));

                //
                bgSelector6.setBackground(new Utilities().getDrawableButtonBg6(false, true));
                bgSelector5.setBackground(new Utilities().getDrawableButtonBg5(false, true));
                bgSelector4.setBackground(new Utilities().getDrawableButtonBg4(false, true));
                bgSelector3.setBackground(new Utilities().getDrawableButtonBg3(false, true));
                bgSelector2.setBackground(new Utilities().getDrawableButtonBg2(false, true));
                bgSelector1.setBackground(new Utilities().getDrawableButtonBg1(false, true));
                //
            }
        });

        ImageButton imagePickerBtn = (ImageButton)findViewById(R.id.imagePickerBtn);
        imagePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.pickImage(MainActivity.this, "Select Image:");
            }
        });

        ImageButton downloadBtn = (ImageButton)findViewById(R.id.downloadBtn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    saveImageToExternal();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            int position = data.getIntExtra("Position",0);
            ArrayList<Font> fontsArrayList = new Utilities().fontsArrayList(this);
            Font font = fontsArrayList.get(position);
            mEditor.setTypeface(font.getFontTypeface());
        }
        else if (requestCode == 102 && resultCode == RESULT_OK && data != null) {
            int position = data.getIntExtra("Position",0);
            int bgList[] = new Utilities().populateBgDataset();
            mEditor.setBackgroundResource(bgList[position]);
        }
        else {
            Bitmap imageSelected = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
//            Drawable d = new BitmapDrawable(getResources(), imageSelected);
            mEditor.setBackgroundColor(Color.TRANSPARENT);
            ImageView editTextBGImageId = (ImageView)findViewById(R.id.editTextBGImageId);
            editTextBGImageId.setImageBitmap(imageSelected);
        }
    }

    void setStyle()
    {

        if(isBold && isItalics)
        {
            mEditor.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        else if(isBold)
        {
            mEditor.setTypeface(null, Typeface.BOLD);
        }
        else if(isItalics)
        {
            mEditor.setTypeface(null, Typeface.ITALIC);
        }
        else {
            mEditor.setTypeface(null, Typeface.NORMAL);
        }
    }



    public void saveImageToExternal() throws IOException {

        //take screenshot
        RelativeLayout editTextRelativeLayoutID = (RelativeLayout)findViewById(R.id.editTextRelativeLayoutID);
        bitmap = Bitmap.createBitmap(
                editTextRelativeLayoutID.getWidth(),
                editTextRelativeLayoutID.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        editTextRelativeLayoutID.draw(c);

        final String imgName = "Status" + new Date().toString();

        //

//Create Path to save Image
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "Status Designer"); //Creates app specific folder
        path.mkdirs();
        File imageFile = new File(path, imgName + ".png"); // Imagename.png
        FileOutputStream out = new FileOutputStream(imageFile);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // Compress Image
            out.flush();
            out.close();

            // Tell the media scanner about the new file so that it is
            // immediately available to the user.
            MediaScannerConnection.scanFile(this, new String[]{imageFile.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                    Toast.makeText(MainActivity.this, imgName+" Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            throw new IOException();
        }
    }

    void shareImage()
    {
        Intent shareIntent = new Intent();


        String filePath = Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg";
        File f = new File(filePath);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fo);
            fo.write(bytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //
//        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Test Mail");
//        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Launcher");
        shareIntent.setType("image/*");
//        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(filePath));
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "Post Your Status"));
    }

    public void checkPermissionReadStorage(Context context, Activity activity){
        if (ContextCompat.checkSelfPermission(context,      Manifest.permission.READ_EXTERNAL_STORAGE) !=     PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        else {
            checkPermissionWriteStorage(MainActivity.this, MainActivity.this);
        }
    }

    public void checkPermissionWriteStorage(Context context, Activity activity){
        if (ContextCompat.checkSelfPermission(context,      Manifest.permission.WRITE_EXTERNAL_STORAGE) !=     PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_STORAGE: {
                //premission to read storage
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    checkPermissionWriteStorage(MainActivity.this, MainActivity.this);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "We Need permission Storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_WRITE_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    shareImage();
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
