package com.example.dz_2_3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SecondFragment extends Fragment {
    AppCompatButton SecondButton;
    EditText editTextAge, editTextFloor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews();
        setClicks();
    }

    private void iniViews() {
        SecondButton = requireActivity().findViewById(R.id.secondButton);
        editTextAge = requireActivity().findViewById(R.id.second_age);
        editTextFloor = requireActivity().findViewById(R.id.second_floor);
    }

    private void setClicks() {
        SecondButton.setOnClickListener(view -> {
            if (!editTextAge.getText().toString().isEmpty() && !editTextFloor.getText().toString().isEmpty()) {
                navigateToThree();
            } else {
                Toast.makeText(getActivity(), "Введите ваш возраст и пол", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigateToThree() {
        String age = editTextAge.getText().toString();
        String floor = editTextFloor.getText().toString();
        Bundle bundle = getArguments();
        bundle.putString("age", age);
        bundle.putString("floor", floor);
        ThreeFragment threeFragment = new ThreeFragment();
        threeFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, threeFragment)
                .addToBackStack(null)
                .commit();
    }
}