package databeam.databeamui;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import databeam.databeamui.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class DatabeamMain extends AppCompatActivity {
    private static final int REQUEST_WRITE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databeam_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE);

        RadioButton rb1 = (RadioButton) findViewById(R.id.form1);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://cdn.shopify.com/s/files/1/1190/4748/t/10/assets/logo.png?17130455079152253059";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setDescription("Hello");
                request.setTitle("Hello.png");
                // in order for this if to run, you must use the android 3.2 to compile your app
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Hello.png");

                // get download service and enqueue file
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                startActivity(new Intent(DatabeamMain.this, DatabeamDisplayForm1.class));
            }
                               });

        RadioButton rb2 = (RadioButton) findViewById(R.id.directdeposit);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.chase.com/content/dam/chasecom/en/checking/documents/45969_directdeposit.pdf";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setDescription("Direct Deposit Form");
                request.setTitle("directdeposit.pdf");
                // in order for this if to run, you must use the android 3.2 to compile your app
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "directdeposit.pdf");

                // get download service and enqueue file
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                startActivity(new Intent(DatabeamMain.this, DatabeamDisplayForm2.class));
            }
        });
    }

}
