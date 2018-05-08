package com.mengqd.easypermisssions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mengqd.mperimission.AbstractDefaultPermissionCallback;
import com.mengqd.mperimission.EasyPermissions;
import com.mengqd.mperimission.PermissionCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyPermissions.createBuilder(this)
                .requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION})
                .requestCode(10)
                .setPermissionCallback(new PermissionCallback() {
                    @Override
                    public void onPermissionsAllGranted(int requestCode, List<String> permissions) {
                        Toast.makeText(getApplicationContext(), "通过", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionsTemporaryDenied(int requestCode, List<String> permissions) {

                    }

                    @Override
                    public void onPermissionsForeverDenied(int requestCode, List<String> permissions) {

                    }
                }).build();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
