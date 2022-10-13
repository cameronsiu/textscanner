package com.example.textscanner;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayText#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayText extends Fragment implements View.OnClickListener {

    private static final String TEXT = "scanned_text";
    View view;
    Button button_capture, button_gallery, button_copy;
    EditText editText_data;

    public static DisplayText newInstance(String text) {
        DisplayText fragment = new DisplayText();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_display_text, container, false);
        button_capture = (Button) view.findViewById(R.id.button_capture);
        button_gallery = (Button) view.findViewById(R.id.button_gallery);
        button_copy = (Button) view.findViewById(R.id.button_copy);
        button_copy.setOnClickListener(this);
        editText_data = (EditText) view.findViewById(R.id.edittext_data);
        if (getArguments() != null) {
            editText_data.setText(getArguments().getString(TEXT));
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_copy:
                copyToClipBoard();
                break;
        }
    }

    public void copyToClipBoard() {
        String scanned_text = editText_data.getText().toString();
        ClipboardManager clipBoard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied data", scanned_text);
        clipBoard.setPrimaryClip(clip);
        Toast.makeText(getActivity(), "Copied to clipboard!", Toast.LENGTH_SHORT);
    }
}