package com.example.onlinegrocerymargav;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddGrocery extends Activity {

    EditText etAddGName,etAddGPrice,etAddGStock,etAddGUnit;
    Button btAddImage,btAddGrocery;
    ImageView imageView,imgGrocery;
    Uri imgPath;
    String gName, gUnit;
    int gPrice, gStock;
    String imgUrl;
    DatabaseReference dbRef = null;
    StorageReference storeImg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        etAddGName = findViewById(R.id.etGroceryAdminAddName);
        etAddGPrice = findViewById(R.id.etGroceryAdminAddPrice);
        etAddGStock = findViewById(R.id.etGroceryAdminAddStock);
        etAddGUnit = findViewById(R.id.etGroceryAdminAddUnit);

        btAddImage = findViewById(R.id.btGroceryAdminAddImage);
        btAddGrocery = findViewById(R.id.btGroceryAdminAddItem);

        imgGrocery = findViewById(R.id.imgGrocery);


        btAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(ii,121);
            }
        });

        btAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gName = etAddGName.getText().toString();
                gPrice = Integer.parseInt(etAddGPrice.getText().toString());
                gStock = Integer.parseInt(etAddGStock.getText().toString());
                gUnit = etAddGUnit.getText().toString();
                dbRef = FirebaseDatabase.getInstance().getReference("grocery");
                storeImg = FirebaseStorage.getInstance().getReferenceFromUrl("gs://onlicerymargav.appspot.com");

                final StorageReference imgPhoto = storeImg.child(gName);
                final String gId = dbRef.push().getKey();

                imgPhoto.putFile(imgPath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        imgPhoto.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Grocery gr = new Grocery(gId,uri.toString(),gName,gPrice,gStock,gUnit);
                                dbRef.child(gId).setValue(gr);

                                Toast.makeText(getApplicationContext(),"GROCERY ADDED",Toast.LENGTH_LONG);

                                etAddGName.setText("");
                                etAddGPrice.setText("");
                                etAddGStock.setText("");
                                etAddGUnit.setText("");
                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"FAIL TO UPLOAD"+e.getMessage(),Toast.LENGTH_LONG);
                    }
                });

            }
        });
    }

    public void onActivityResult(int req,int res,Intent data)
    {
        imgPath = data.getData();
        imgGrocery.setImageURI(imgPath);
    }
}