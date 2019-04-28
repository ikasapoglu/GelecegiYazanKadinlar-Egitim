package com.example.irems.myticketapp.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irems.myticketapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ProfileFragment extends Fragment {
    Button btn_photoChange;
    TextView tv_mail;
    ImageView iv_profile;
    private static final int PICK_PHOTO_CODE = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btn_photoChange = view.findViewById(R.id.btn_profile_degistir);
        tv_mail = view.findViewById(R.id.tv_profile_mail);
        iv_profile = view.findViewById(R.id.iv_pp);
        tv_mail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        btn_photoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, PICK_PHOTO_CODE);


            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_CODE)
            if (resultCode == Activity.RESULT_OK) {
                Uri selectedImage = data.getData();
                // System.out.println(selectedImage.getPath()+".jpg");
                UploadImage(selectedImage);

            }
    }

        private void UploadImage(Uri filepath){
            if (filepath != null) {
                final ProgressDialog p = new ProgressDialog(getActivity());
                p.setTitle("Yükleniyor..");
                p.show();

                StorageReference ref = FirebaseStorage.getInstance().getReference(UUID.randomUUID().toString());
                //Uri file = Uri.fromFile(new File(filepath));
                ref.putFile(filepath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        System.out.println("BITTI : " + task.getException());
                        p.dismiss();
                    }
                });
            }

        }
    }
