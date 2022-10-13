package com.example.textscanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TitleScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleScreen extends Fragment {

    Button button_capture, button_gallery;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_title_screen, container, false);
        button_capture = (Button) view.findViewById(R.id.button_capture);
        button_gallery = (Button) view.findViewById(R.id.button_gallery);
        return view;
    }

//    private File createTempImageFile() throws IOException {
//        // Create an image file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//
//        // Save a file: path for use with ACTION_VIEW intents
//        currentPhotoPath = image.getAbsolutePath();
//        return image;
//    }
//
//    // Captures an image and creates one too (fix it by creating a temp image)
//    public void captureImage(View v) {
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//            File tempImage = null;
//            try {
//                tempImage = createTempImageFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (tempImage != null) {
//                tempURI = FileProvider.getUriForFile(getActivity(), "com.example.android.fileprovider", tempImage);
//                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
//                startCamera.launch(cameraIntent);
//            } else {
//                System.out.println("Temporary image failed to create");
//            }
//        }
//    }

//    public void launchGallery(View v) {
//        getImage.launch("image/*");
//    }

}