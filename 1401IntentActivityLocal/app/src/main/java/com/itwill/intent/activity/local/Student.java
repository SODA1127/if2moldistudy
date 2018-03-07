package com.itwill.intent.activity.local;

import java.io.Serializable;

/**
 * Created by ITWILL on 2018-01-09.
 */

public class Student implements Serializable{
    private  int no;
    private String name;
    private boolean married;

    public Student() {
    }

    public Student(int no, String name, boolean married) {
        this.no = no;
        this.name = name;
        this.married = married;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
