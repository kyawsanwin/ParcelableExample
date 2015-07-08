package com.tm.parcelableexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText name, position, department, email, phone;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        position = (EditText) findViewById(R.id.position);
        department = (EditText) findViewById(R.id.department);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);

        btnSubmit = (Button) findViewById(R.id.submit);

        btnSubmit.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {

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
