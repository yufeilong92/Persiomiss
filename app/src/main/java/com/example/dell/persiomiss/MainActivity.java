package com.example.dell.persiomiss;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestion();
    }

    private void requestion() {
        if (EasyPermissions.hasPermissions(this, DataPersmission.Persmission)) {
            strat();
        } else {
            PermissionRequest build = new PermissionRequest.Builder(this, 0, DataPersmission.Persmission)
                    .setRationale("请允许使用该app申请的权限，否则，该APP无法正常使用")
                    .setNegativeButtonText(R.string.cancel)
                    .setPositiveButtonText(R.string.sure)
                    .build();
            EasyPermissions.requestPermissions(build);
        }
    }

    public void strat() {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
          this.finish();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {//成功
        List<String> mDATA = Arrays.asList(DataPersmission.Persmission);
        if (perms.contains(mDATA)) {
            strat();

        } else {
            requestion();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {//失败
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setPositiveButton(R.string.sure)
                    .setNegativeButton(R.string.cancel)
                    .setRationale("请允许使用该app申请的权限，否则，该APP无法正常使用")
                    .build()
                    .show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE){
            requestion();
        }
    }
}
