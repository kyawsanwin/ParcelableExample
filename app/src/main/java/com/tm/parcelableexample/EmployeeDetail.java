package com.tm.parcelableexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class EmployeeDetail extends Activity {

    TextView name, positoin, department, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        name = (TextView) findViewById(R.id.name);
        positoin = (TextView) findViewById(R.id.position);
        department = (TextView) findViewById(R.id.department);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);

        Intent intent = getIntent();
        Employee employee = intent.getParcelableExtra("employee");

        name.setText(employee.getName());
        positoin.setText(employee.getPosition());
        department.setText(employee.getDepartment());
        email.setText(employee.getEmail());
        phone.setText(employee.getPhone());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employee_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
