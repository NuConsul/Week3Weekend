package com.chemwater.week3weekend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView ;
import android.support.v7.widget.RecyclerView ;
import android.support.v7.widget.LinearLayoutManager ;

import java.util.ArrayList ;


public class FragmentOne extends Fragment implements FragmentThree.OnFragmentThreeInteractionListener {
    RecyclerView recyclerView ;
    MyRecyclerViewAdapter myRecyclerViewAdapter ;
    EmployeeOpenHelper employeeOpenHelper ;


    //declare views
    TextView tvEmployeeName, tvEmployeeBirthDate, tvEmployeeWage, tvEmployeeHireDate ;
    ImageView ivEmployeeImage ;


    public FragmentOne() {
        //Required emptly public constructor
    }


    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne() ;
        return fragment ;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState) ;
        tvEmployeeName = view.findViewById(R.id.tvEmployeeName) ;
        tvEmployeeBirthDate = view.findViewById(R.id.tvEmployeeBirthDate) ;
        tvEmployeeWage = view.findViewById(R.id.tvEmployeeWage) ;
        tvEmployeeHireDate = view.findViewById(R.id.tvEmployeeHireDate) ;
        ivEmployeeImage = view.findViewById(R.id.ivEmployeeImage) ;



        //Bind RecyclerView
        recyclerView = view.findViewById(R.id.rvRecyclerView) ;

        //Recycler View needs 2 items
        // 1. Layout Manager (Can be customized, but we generally use a default)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext()) ;
        recyclerView.setLayoutManager(layoutManager) ;

        //2. RecyclerView adapter (We write this)
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(generateListOfEmployee()) ;
        recyclerView.setAdapter(myRecyclerViewAdapter) ;
    }

    private ArrayList<Employee> generateListOfEmployee() {
        //ArrayList<Employee> employeeArrayList = new ArrayList<>() ;
        employeeOpenHelper = new EmployeeOpenHelper(getContext()) ;



        /*

        MADE ANOTHER CONSTRUCTOR THAT DOES NOT THE ID


         */
        /*
        employeeArrayList.add(new Employee("Gerald", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Spalding", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Lebron", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Pippen", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Jordan", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Ewing", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Gasol", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Nowitski", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Carter", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Jackson", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Green", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Curry", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        employeeArrayList.add(new Employee("Igadoula", "Feb 2 2012", "10,00", "Dec 5 2018", R.drawable.pic_one)) ;
        */
        return employeeOpenHelper.getAllEmployeeFromDatabase();

        //return employeeArrayList ;
    }


    @Override
    public void notifyMainActivityToNotifyRecyclerChange() {
        myRecyclerViewAdapter.notifyDataSetChanged() ;
    }
}
