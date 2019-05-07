package com.yiling.ourstory.model;

import java.util.Date;


public class DaysCalculator {
    private Date togetherTime;
    private int togetherDays;
    private Date birthday;
    private int birthdayDays;
    private int anniversary;

    public DaysCalculator(Date togetherTime, int togetherDays, Date birthday, int birthdayDays, int anniversary) {
        this.togetherTime = togetherTime;
        this.togetherDays = togetherDays;
        this.birthday = birthday;
        this.birthdayDays = birthdayDays;
        this.anniversary = anniversary;
    }

    public DaysCalculator() {

    }

    public Date getTogetherTime() {
        return togetherTime;
    }

    public void setTogetherTime(Date togetherTime) {
        this.togetherTime = togetherTime;
    }

    public int getTogetherDays() {
        return togetherDays;
    }

    public void setTogetherDays(int togetherDays) {
        this.togetherDays = togetherDays;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBirthdayDays() {
        return birthdayDays;
    }

    public void setBirthdayDays(int birthdayDays) {
        this.birthdayDays = birthdayDays;
    }

    public int getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(int anniversary) {
        this.anniversary = anniversary;
    }
}

