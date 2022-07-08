package com.android.alarmwithwidget

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION
import android.provider.Settings.canDrawOverlays
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*


val REQUEST_CODE = 1234

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkDrawOverlayPermission()
        init()
    }

    private fun checkDrawOverlayPermission() {

        // Checks if app already has permission to draw overlays
        if (!canDrawOverlays(this)) {

            // If not, form up an Intent to launch the permission request
            val setdialog = AlertDialog.Builder(this)
            setdialog.setTitle("Hi.")
                .setMessage("Please allow drawing over other apps. If not, you can't use this app.")
                .setPositiveButton("OK") { _, _ ->
                    startActivity(Intent(ACTION_MANAGE_OVERLAY_PERMISSION))

                }
                .setNegativeButton("Nope") { _, _ ->
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show()
                    finish()
                    //확인필요
                }
                .create()
                .show()
        }
    }

    fun init(){
        buttonSettings.setOnClickListener {
            startSettingActivity()
        }

        var currentTime = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy.MM.dd")
        val timeFormat = SimpleDateFormat("HH:mm")

        val year = currentTime.get(YEAR).toString()
        val month = currentTime.get(MONTH).toString()
        val day = currentTime.get(DAY_OF_MONTH).toString()


        textCurrentDate.text = dateFormat.format(currentTime)
        textCurrentTime.text = timeFormat.format(currentTime).toString() + currentTime.get(AM_PM)
        //확인필요
    }

    private fun startSettingActivity(){
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
    }
}