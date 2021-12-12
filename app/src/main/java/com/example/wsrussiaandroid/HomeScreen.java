package com.example.wsrussiaandroid;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Calendar;

public class HomeScreen extends Fragment {
    ListView listview;
    String[] title={"One Toyota Hilux F24 Testing","Two Toyota Hilux F24 Testing","Three Toyota Hilux F24 Testing","Four Toyota Hilux F24 Testing"};
    String[] subTitle={"11/12/2021","21/0/1223","3/3/444","12/4/3030"};
    EditText startDate, endDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home_screen, container, false);
        listview=view.findViewById(R.id.listview);
        startDate=view.findViewById(R.id.edtStartDate);
        view.findViewById(R.id.floatingButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new AddAsset();
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainfragment,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker1(view);
            }
        });
        endDate=view.findViewById(R.id.edtEndDate);
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker2(view);
            }
        });
        CustomListViewAdapter customListViewAdapter=new CustomListViewAdapter(getActivity(),title,subTitle);
        listview.setAdapter(customListViewAdapter);
        return view;
    }

    public void openDatePicker1(View view) {
        Calendar calendar=Calendar.getInstance();
        int year,month,day;
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },year,month,day);
        datePickerDialog.show();
    }

    public void openDatePicker2(View view) {
        Calendar calendar=Calendar.getInstance();
        int year,month,day;
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },year,month,day);
        datePickerDialog.show();
    }
}