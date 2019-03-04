package com.chemwater.week3weekend;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull ;
import android.support.annotation.Nullable ;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button ;
import android.widget.EditText ;

import java.util.ArrayList;


public class FragmentTwo extends Fragment implements View.OnClickListener {

    EditText etEmployeeName, etEmployeeBirthDate, etEmployeeWage, etEmployeeHireDate, etEmployeeImage ;
    Button btnSendNewEmployee ;

    //Employee Database declaration
    EmployeeOpenHelper employeeOpenHelper ;

    private OnFragmentTwoInteractionListener mListener;


    public FragmentTwo() {
        // Required empty public constructor
    }


    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        employeeOpenHelper = new EmployeeOpenHelper(getContext()) ;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState) ;

        etEmployeeName = view.findViewById(R.id.etEmployeeName) ;
        etEmployeeBirthDate = view.findViewById(R.id.etEmployeeBirthDate) ;
        etEmployeeWage = view.findViewById(R.id.etEmployeeWage) ;
        etEmployeeHireDate = view.findViewById(R.id.etEmployeeHireDate) ;
        etEmployeeImage = view.findViewById(R.id.etEmployeeImage) ;
        btnSendNewEmployee = view.findViewById(R.id.btnSend) ;

        btnSendNewEmployee.setOnClickListener(this) ;


    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context) ;
        if (context instanceof OnFragmentTwoInteractionListener) {
            mListener = (OnFragmentTwoInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentTwoInteractionListener");
        }
    }*/


    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    //
    //Save Employee database and print list of all employee currently in DB to log
    //
    public void saveEmployeeToDBandSeeLog(@NonNull Employee employee) {
        //Save employee to database
        employeeOpenHelper.insertEmployeeIntoDatabase(employee) ;
        //get all current cars in database and log them
        ArrayList<Employee> employeeList = employeeOpenHelper.getAllEmployeeFromDatabase() ;
        for(Employee currentEmployee : employeeList) {
            Log.d("TAG", currentEmployee.toString()) ;
        }
    }

    @Override
    public void onClick(View view) {
        //if (mListener != null) {

            if(etEmployeeName.getText() != null && etEmployeeBirthDate.getText() != null &&
                    etEmployeeWage.getText() != null && etEmployeeHireDate.getText() != null
                    && etEmployeeImage.getText() != null) {
                //Get string from Edit Text
                String nameInput = etEmployeeName.getText().toString() ;
                String birthDateInput = etEmployeeBirthDate.getText().toString() ;
                String wageInput = etEmployeeWage.getText().toString() ;
                String hireDateInput = etEmployeeHireDate.getText().toString() ;
                String employeeImageUriInput = etEmployeeImage.getText().toString() ;




                /*SENT ONE STRING JUST TO TEST*/
                //mListener.onSendNewEmployeeToBase(nameInput) ;


                //Get our database helper
                Employee newEmployee = new Employee(nameInput,
                        birthDateInput,
                        wageInput, hireDateInput,
                        employeeImageUriInput) ;





                saveEmployeeToDBandSeeLog(newEmployee) ;
            }




        //}
    }


    public interface OnFragmentTwoInteractionListener {

        void onSendNewEmployeeToBase(String newEmployeePassed) ;

    }
}
