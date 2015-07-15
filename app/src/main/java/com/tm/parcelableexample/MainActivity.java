package com.tm.parcelableexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {
    
    @Bind(R.id.name) EditText name;
    @Bind(R.id.position) EditText position;
    @Bind(R.id.department) EditText department;
    @Bind(R.id.email) EditText email;
    @Bind(R.id.phone) EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @OnClick(R.id.submit)
    void submit(View view) {

        Employee employee = new Employee();
        employee.setName(name.getText().toString());
        employee.setPosition(position.getText().toString());
        employee.setDepartment(department.getText().toString());
        employee.setEmail(email.getText().toString());
        employee.setPhone(phone.getText().toString());

        Intent intent = new Intent(MainActivity.this, EmployeeDetail.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }
}
