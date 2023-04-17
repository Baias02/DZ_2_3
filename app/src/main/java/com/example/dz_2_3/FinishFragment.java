package com.example.dz_2_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ResourceBundle;

public class FinishFragment extends Fragment {
    TextView PlaceName, PlaceSurName, PlaceAge, PlaceFloor, PlaceStudy, PlaceWork;
    String name, surName, age, floor, study, work;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViewId();
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
            surName = bundle.getString("surname");
            age = bundle.getString("age");
            floor = bundle.getString("floor");
            study = bundle.getString("study");
            work = bundle.getString("work");
            PlaceName.setText(name);
            PlaceSurName.setText(surName);
            PlaceAge.setText(age);
            PlaceFloor.setText(floor);
            PlaceStudy.setText(study);
            PlaceWork.setText(work);
        }
    }

    private void iniViewId() {
        PlaceName = requireActivity().findViewById(R.id.place_name);
        PlaceSurName = requireActivity().findViewById(R.id.place_surname);
        PlaceAge = requireActivity().findViewById(R.id.place_age);
        PlaceFloor = requireActivity().findViewById(R.id.place_floor);
        PlaceStudy = requireActivity().findViewById(R.id.place_study);
        PlaceWork = requireActivity().findViewById(R.id.place_work);
    }
}