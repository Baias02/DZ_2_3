package com.example.dz_2_3;

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

public class FirsFragment extends Fragment {
    AppCompatButton button;
    EditText editName, editSurname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews();
        setClicks();
    }

    private void iniViews() {
        button = requireActivity().findViewById(R.id.firsButton);
        editName = requireActivity().findViewById(R.id.edit_name);
        editSurname = requireActivity().findViewById(R.id.edit_surname);
    }

    private void setClicks() {
        button.setOnClickListener(view -> {
            if (!editName.getText().toString().isEmpty() && !editSurname.getText().toString().isEmpty()) {
                navigateToSecond();
            } else {
                Toast.makeText(getActivity(), "Введите ваше имя и фамилию", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToSecond() {
        String name = editName.getText().toString();
        String surname = editSurname.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("surname", surname);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit();
    }

}