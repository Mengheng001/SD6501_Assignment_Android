package com.example.assignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShareFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.share_fragment,container,false);

        TextView source1 = view.findViewById(R.id.etsource1);
        TextView source2 = view.findViewById(R.id.etsource2);
        TextView source3 = view.findViewById(R.id.etsource3);

        source1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                         gotoUrl("https://www.youtube.com/watch?v=TU-yDCgpbZw");
                                       }
                                   });

        source2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=tZ2YEw6SoBU");
            }
        });

        source3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=8obgNNlj3Eo");
            }
        });


        return view;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
