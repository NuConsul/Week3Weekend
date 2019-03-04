package com.chemwater.week3weekend;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private static final String IMAGE_URL = "http://images.unsplash.com/photo-1433086966358-54859d0ed716?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max" ;

    //List of employees that will be populated int the recycler view
    ArrayList<Employee> employeesArrayList ;

    //Constructor for the Adapter
    public MyRecyclerViewAdapter(ArrayList<Employee> employeesArrayList) {
        this.employeesArrayList = employeesArrayList ;
    }


    //Inflate the xml into active memory (renders)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        /*
        return new instance of the viewholder(We need to inflate(render) the view to passing
        by telling the context of where this is going to be rendered, the layout to inflate, the
        viewgroup to assign it to, and if we need a root level attachment)
         */

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_item, viewGroup, false)) ;
    }


    //Once we have the viewholder, we then populated the data when we bind to the created viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //Get the item's information which we wish to populate for that viewholder
        Employee currentEmployeeBeingPopulated = employeesArrayList.get(position) ;
        //use the passed viewholder to access the items view and populate
        viewHolder.tvEmployeeName.setText(currentEmployeeBeingPopulated.getEmployeeName()) ;
        viewHolder.tvEmployeeBirthDate.setText(currentEmployeeBeingPopulated.getEmployeeBirthDate()) ;
        viewHolder.tvEmployeeWage.setText(currentEmployeeBeingPopulated.getEmployeeWage()) ;
        viewHolder.tvEmployeeHireDate.setText(currentEmployeeBeingPopulated.getEmployeeHireDate()) ;

        //Using glide to associate the web resource image to our imageView
        Glide.with(viewHolder.itemView.getContext())
                .load(IMAGE_URL)
                .into(viewHolder.ivEmployeeImage) ;

        Log.d("TAG", "onBindViewHolder: item being rendered = " + position) ;


    }

    @Override
    public int getItemCount() {
       return employeesArrayList.size() ;
    }





    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmployeeName, tvEmployeeBirthDate, tvEmployeeWage, tvEmployeeHireDate ;
        ImageView ivEmployeeImage ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView) ;
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName) ;
            tvEmployeeBirthDate = itemView.findViewById(R.id.tvEmployeeBirthDate) ;
            tvEmployeeWage = itemView.findViewById(R.id.tvEmployeeWage) ;
            tvEmployeeHireDate = itemView.findViewById(R.id.tvEmployeeHireDate) ;
            ivEmployeeImage = itemView.findViewById(R.id.ivEmployeeImage) ;
        }
    }
}
