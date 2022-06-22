package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmailFragment extends Fragment {


    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      //super.onCreate(savedInstanceState);
        //setContentView(R.layout.email_fragment);
        View view = inflater.inflate(R.layout.email_fragment,container,false);

       EditText etTo = view.findViewById(R.id.edit_text_to);
       EditText  etSubject = view.findViewById(R.id.edit_text_subject);
       EditText etMessage = view.findViewById(R.id.edit_text_message);

       Button btnSend = view.findViewById(R.id.button_send);
         btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipientList = etTo.getText().toString();
                String[] recipients = recipientList.split(",");

                String subject = etSubject.getText().toString();
                String message = etMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an email tool"));
            }
        });

        return view;
    }

    private void sendMail(){

    }


}
