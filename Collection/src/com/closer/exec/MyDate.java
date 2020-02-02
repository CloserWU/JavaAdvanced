package com.closer.exec;

/**
 * <p>MyDate</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-02 20:55
 */
public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        MyDate date1 = (MyDate) o;
        MyDate date2 = this;
        if (date1.getYear()  != date2.getYear()) {
            return date1.getYear() - date2.getYear();
        }
        if (date1.getMonth()  != date2.getMonth()) {
            return date1.getMonth() - date2.getMonth();
        }
        return date1.getDay() - date2.getDay();
    }
}

