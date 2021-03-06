package com.example.watopoly.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watopoly.R;
import com.example.watopoly.model.Property;

import java.util.ArrayList;

public class DialogViewProperty extends DialogFragment {

    private Property property;
    private int width;
    private int height;
    public DialogViewProperty(Property property) {
        this.property = property;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.dialog_preview_property, null);

        FragmentManager fm = getFragmentManager();
        PropertyFragment fragment = (PropertyFragment) fm.findFragmentById(R.id.previewPropertyFragment); //get large prop
        fragment.setProperty(property);

        View view = root.findViewById(R.id.previewPropertyFragment);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        width = layoutParams.width;
        height = layoutParams.height;
        builder.setView(root);
        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.previewPropertyFragment);
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }
}
