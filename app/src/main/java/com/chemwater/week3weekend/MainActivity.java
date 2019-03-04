package com.chemwater.week3weekend;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity /*implements FragmentThree.OnFragmentThreeInteractionListener*/ {

    FragmentOne fragmentOne ;
    FragmentTwo fragmentTwo ;
    FragmentThree fragmentThree ;
    FragmentManager fragmentManager ;

    EmployeeOpenHelper employeeOpenHelper ;

    public static final String  FRAGMENT_ONE_TAG = "fragment_one" ;
    public static final String  FRAGMENT_TWO_TAG = "fragment_two" ;
    public static final String  FRAGMENT_THREE_TAG = "fragment_three" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        //instantiate the employee Database
        employeeOpenHelper = new EmployeeOpenHelper(this) ;

        fragmentOne = FragmentOne.newInstance() ;
        fragmentTwo = FragmentTwo.newInstance() ;
        fragmentThree = FragmentThree.newInstance() ;
        //Fragment Manager
        fragmentManager = getSupportFragmentManager() ;
        //use fragment manager to begin fragment transaction, replace the frag in layout with
        //fragment we want there, add it to back stack with a tag, and commit the transaction
        fragmentManager.beginTransaction()
                .replace(R.id.firstFragment, fragmentOne)
                .addToBackStack(FRAGMENT_ONE_TAG)
                .commit() ;

        fragmentManager.beginTransaction()
                .replace(R.id.secondFragment, fragmentTwo)
                .addToBackStack(FRAGMENT_TWO_TAG)
                .commit() ;

        fragmentManager.beginTransaction()
                .replace(R.id.thirdFragment, fragmentThree)
                .addToBackStack(FRAGMENT_THREE_TAG)
                .commit() ;
    }

    /*
    @Override
    public void notifyMainActivityToNotifyRecyclerChange() {
    }*/
}
