package com.musahundur.instagramclonejava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class FeedActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_post){
            //Go Upload Activity
            Intent intentAddPost = new Intent(FeedActivity.this, UploadActivity.class);
            startActivity(intentAddPost);
        } else if(item.getItemId() == R.id.signout){
            auth.signOut();
            //Sign Out
            Intent intentSignOut = new Intent(FeedActivity.this, MainActivity.class);
            startActivity(intentSignOut);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}