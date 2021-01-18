package com.example.databaseroom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogAddUser extends DialogFragment {

    private EditText mFirstName , mLastName;
    private Button mAddButton;
    private OnAddButtonClick mOnAddButtonClick;

    public void setOnAddButtonClick(OnAddButtonClick onAddButtonClick) {
        mOnAddButtonClick = onAddButtonClick;
    }

    public static DialogAddUser newInstance() {
        
        Bundle args = new Bundle();
        
        DialogAddUser fragment = new DialogAddUser();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog_add,null);
        findViews(view);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnAddButtonClick.onAddButton(mFirstName.getText().toString(),mLastName.getText().toString());
                dismiss();
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }

    private void findViews(View view) {
        mFirstName = view.findViewById(R.id.first_name_dialog);
        mLastName = view.findViewById(R.id.last_name_dialog);
        mAddButton = view.findViewById(R.id.add_button_dialog);
    }
}
