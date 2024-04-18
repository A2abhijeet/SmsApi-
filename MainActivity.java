package com.example.smsapi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
 Button button ; EditText phno;
 EditText msg;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 button = (Button) findViewById(R.id.button);
 phno = (EditText) findViewById(R.id.editTextText);
 msg = (EditText) findViewById(R.id.editTextText2);
 button.setOnClickListener(new View.OnClickListener(){
 public void onClick(View view){
 sendSMSMessage ();
 } }); }
 protected void sendSMSMessage() {
 String phoneNo = phno.getText().toString();
 String message = msg.getText().toString();
 try{
 SmsManager smsManager = SmsManager.getDefault();
 if(phoneNo.length()==10){
 Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
 }
 else{
 Toast.makeText(this,"Invalid number", 
Toast.LENGTH_SHORT).show();
 return;
 }

 smsManager.sendTextMessage(phoneNo, null, 
message,null,null);
 Toast.makeText(getApplicationContext(), "SMS sent.", 
Toast.LENGTH_LONG). show();
}
 catch (Exception e) {
 Toast.makeText(getApplicationContext(), "SMS failed, please 
try again.", Toast.LENGTH_LONG).show();
 e.printStackTrace();
}}}
