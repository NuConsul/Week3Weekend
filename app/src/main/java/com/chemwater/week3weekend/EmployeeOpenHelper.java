package com.chemwater.week3weekend;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper ;
import android.content.Context ;
import android.database.sqlite.SQLiteDatabase ;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import java.util.ArrayList;

import static com.chemwater.week3weekend.EmployeeDatabaseContract.DATABASE_NAME;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.DATABASE_VERSION;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_EMPLOYEE_NAME ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_BIRTH_DATE ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_WAGE ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_HIRE_DATE ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_EMPLOYEE_IMAGE ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.COLUMN_ID ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.TABLE_NAME ;
import static com.chemwater.week3weekend.EmployeeDatabaseContract.getWhereClauseById ;

public class EmployeeOpenHelper extends SQLiteOpenHelper {



    EmployeeOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION ) ;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        /*database.execSQL("CREATE TABLE EMPLOYEE ("
                            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "EMPLOYEE_NAME TEXT, "
                            + "EMPLOYEE_BIRTH_DATE TEXT, "
                            + "EMPLOYEE_WAGE TEXT, "
                            + "EMPLOYEE_HIRE_DATE TEXT, "
                            + "EMPLOYEE_IMAGE INTEGER)") ;*/
        database.execSQL(EmployeeDatabaseContract.createQuery()) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onCreate(database) ;
    }

    //Insert a employee into the database
    public long insertEmployeeIntoDatabase(@NonNull Employee employee) {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase() ;
        //Data container used for database key value pairs
        ContentValues contentValues = new ContentValues() ;

        //insert key value pairs into the contentValues container
        contentValues.put(COLUMN_EMPLOYEE_NAME, employee.getEmployeeName()) ;
        contentValues.put(COLUMN_BIRTH_DATE, employee.getEmployeeBirthDate()) ;
        contentValues.put(COLUMN_WAGE, employee.getEmployeeWage()) ;
        contentValues.put(COLUMN_HIRE_DATE, employee.getEmployeeHireDate()) ;
        contentValues.put(COLUMN_EMPLOYEE_IMAGE, employee.getEmployeeImage()) ;

        //insert the employee into the table using contentValues
        return writeableDatabase.insert(TABLE_NAME, null, contentValues) ;
    }

    //Get All Employee from Database and return an ArrayList
    public ArrayList<Employee> getAllEmployeeFromDatabase() {
        ArrayList<Employee> returnEmployeeList = new ArrayList<>() ;
        SQLiteDatabase readableDatabase = this.getReadableDatabase() ;
        //Get results from query and hold in cursor(iterable object for database operations)
        Cursor cursor = readableDatabase.rawQuery(EmployeeDatabaseContract.getAllEmployeesQuery(), null) ;
        //Check to see if we have any results
        if(cursor.moveToFirst()) {
            //while we have results, get the values and place in list
            do {
                //get values
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) ;
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NAME)) ;
                String birthDate = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTH_DATE)) ;
                String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE)) ;
                String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE)) ;
                String image = cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_IMAGE)) ;

                //add to list
                returnEmployeeList.add(new Employee(name, birthDate, wage, hireDate, image, id))  ;
            } while (cursor.moveToNext()) ;
            //return the result in a list
        }

        cursor.close() ;
        return returnEmployeeList ;
    }

    //Get One entry from database
    public Employee getEmployeeById(int id) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase() ;
        //Employee to return
        Employee returnEmployee = new Employee()  ;
        //cursor to hold results
        Cursor cursor = readableDatabase.rawQuery(EmployeeDatabaseContract.getOneEmployeeById(id), null) ;
        if(cursor.moveToFirst()) {
            int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) ;
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_NAME)) ;
            String birthDate = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTH_DATE)) ;
            String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE)) ;
            String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE)) ;
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_EMPLOYEE_IMAGE)) ;

            //set return employee
            returnEmployee = new Employee(name, birthDate, wage, hireDate, image, idFromDB) ;
        }

        cursor.close() ;
        return returnEmployee ;
    }

    //update an item in the database
    public long updateEmployeeInDatabase(@NonNull Employee newEmployeeInfo) {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase() ;
        //Data container used for database key value pairs
        ContentValues contentValues = new ContentValues() ;

        //insert key values pairs into the contentValues container
        contentValues.put(COLUMN_EMPLOYEE_NAME, newEmployeeInfo.getEmployeeImage()) ;
        contentValues.put(COLUMN_BIRTH_DATE, newEmployeeInfo.getEmployeeBirthDate()) ;
        contentValues.put(COLUMN_WAGE, newEmployeeInfo.getEmployeeWage()) ;
        contentValues.put(COLUMN_HIRE_DATE, newEmployeeInfo.getEmployeeHireDate()) ;
        contentValues.put(COLUMN_EMPLOYEE_IMAGE, newEmployeeInfo.getEmployeeImage()) ;

        return writeableDatabase.update(TABLE_NAME, contentValues, getWhereClauseById(),
                new String[]{String.valueOf(newEmployeeInfo.getId())}) ;
    }

    //delete entry(or entries) from the database
    public long deleteFromDatabaseById(String[] id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase() ;
        return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseById() + id[0], null) ;
    }

}
