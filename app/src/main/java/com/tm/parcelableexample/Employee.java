package com.tm.parcelableexample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kyawsanwin on 7/8/15.
 */
public class Employee implements Parcelable {
    private String name;
    private String position;
    private String department;
    private String email;
    private String phone;

    public Employee(){}

    public Employee(String name, String position, String department, String email, String phone) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.position);
        dest.writeString(this.department);
        dest.writeString(this.email);
        dest.writeString(this.phone);
    }

    protected Employee(Parcel in) {
        this.name = in.readString();
        this.position = in.readString();
        this.department = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
