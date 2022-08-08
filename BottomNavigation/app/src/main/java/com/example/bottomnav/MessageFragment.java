package com.example.bottomnav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MessageFragment extends Fragment {


    View view;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_message, container, false);
        // Inflate the layout for this fragment

        TextView textView=view.findViewById(R.id.tv);

//        Bundle bundle=getArguments();
//        try {
//            String str = bundle.getString("strr");
//        }catch (Exception e){
//            Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
//        }
//        textView.setText(str);

        //new likhe FragmentResult likhlei sob chole asbe
        getParentFragmentManager().setFragmentResultListener("okk", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data=result.getString("strr");
                textView.setText(data);
                Toast.makeText(getContext(),data,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}