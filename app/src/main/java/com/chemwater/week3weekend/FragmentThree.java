package com.chemwater.week3weekend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class FragmentThree extends Fragment implements View.OnClickListener {

    EditText etEmployeeName, etEmployeeBirthDate, etEmployeeWage, etEmployeeHireDate, etEmployeeImage ;
    Button btnUpdate, btnDelete ;
    EditText  etIdNumber ;

    private OnFragmentThreeInteractionListener mListener  ;

    public FragmentThree() {
        // Required empty public constructor
    }



    public static FragmentThree newInstance() {
        FragmentThree fragment = new FragmentThree();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //myRecyclerViewAdapter = new MyRecyclerViewAdapter() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState) ;

        etEmployeeName = view.findViewById(R.id.etEmployeeNameThree) ;
        etEmployeeBirthDate = view.findViewById(R.id.etEmployeeBirthDateThree) ;
        etEmployeeWage = view.findViewById(R.id.etEmployeeWageThree) ;
        etEmployeeHireDate = view.findViewById(R.id.etEmployeeHireDateThree) ;
        etEmployeeImage = view.findViewById(R.id.etEmployeeImageThree) ;
        etIdNumber = view.findViewById(R.id.employeeIdNumber) ;
        btnUpdate = view.findViewById(R.id.btnThatUpdates) ;
        btnDelete = view.findViewById(R.id.btnThatDeletes) ;
        btnUpdate.setOnClickListener(this) ;
        btnDelete.setOnClickListener(this) ;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            /*
            case R.id.btnThatUpdates:
            if(etEmployeeName.getText() != null && etEmployeeBirthDate.getText() != null &&
                    etEmployeeWage.getText() != null && etEmployeeHireDate.getText() != null
                    && etEmployeeImage.getText() != null) {
                //Get our database helper
                EmployeeOpenHelper employeeOpenHelper = new EmployeeOpenHelper(getContext()) ;


                //Retrieve the car which has the same id as the one which we want to edit
                int employeeId = Integer.parseInt(etIdNumber.getText().toString()) ;
                Employee employeeToEdit = employeeOpenHelper.getEmployeeById(employeeId) ;
                //set the name to the new value for the car we want to edit
                employeeToEdit.setEmployeeName(etEmployeeName.getText().toString()) ;
                employeeToEdit.setEmployeeBirthDate(etEmployeeBirthDate.getText().toString()) ;
                employeeToEdit.setEmployeeWage(etEmployeeWage.getText().toString()) ;
                employeeToEdit.setEmployeeHireDate(etEmployeeHireDate.getText().toString()) ;
                employeeToEdit.setEmployeeImageString(etEmployeeImage.getText().toString()) ;


                //update the database with new value(s)
                employeeOpenHelper.updateEmployeeInDatabase(employeeToEdit) ;

                //Have to find a way to update recycler view. Or notify recycler view when database updated
                mListener.notifyMainActivityToNotifyRecyclerChange() ;

            }
            break ;
            case R.id.btnThatDeletes:
                if(etEmployeeName.getText() != null && etEmployeeBirthDate.getText() != null &&
                etEmployeeWage.getText() != null && etEmployeeHireDate.getText() != null
                && etEmployeeImage.getText() != null) {
                    //Get Database Helper
                    EmployeeOpenHelper employeeDBHelper = new EmployeeOpenHelper(getContext()) ;
                    //Get Id
                    String employeeIdToDelete = etIdNumber.getText().toString() ;
                    //Delete item with id from Database
                    String[] idsToDelete = new String[]{employeeIdToDelete} ;
                    Log.d("TAG", "onClick: DELETEING " + employeeIdToDelete) ;
                    employeeDBHelper.deleteFromDatabaseById(idsToDelete) ;

                    ArrayList<Employee> employeeList = employeeDBHelper.getAllEmployeeFromDatabase() ;
                    for(Employee currentEmployee : employeeList) {
                        Log.d("TAG", currentEmployee.toString()) ;
                    }
                }
                break ;
                */
                /*
            String nameInput = etEmployeeName.getText().toString() ;
            String birthDateInput = etEmployeeBirthDate.getText().toString() ;
            String wageInput = etEmployeeWage.getText().toString() ;
            String hireDateInput = etEmployeeHireDate.getText().toString() ;
            String employeeImageUriInput = etEmployeeImage.getText().toString() ;


            //SENT ONE STRING JUST TO TEST
            mListener.onSendNewEmployeeToBase(nameInput) ;
            */
        }
    }

    public interface OnFragmentThreeInteractionListener {
        void notifyMainActivityToNotifyRecyclerChange() ;
    }

    /*
    public interface OnFragmentTwoInteractionListener {
        void onSendNewEmployeeToBase(String newEmployeePassed) ;
    }*/



}
