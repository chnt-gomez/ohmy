package com.go.ohmy.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int accountId;

    @ColumnInfo(name = "alias")
    private String alias;

    @ColumnInfo(name = "balance")
    private float balance;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "interest_rate")
    private float interestRate;

    @ColumnInfo(name = "delay_fee")
    private float delayFee;

    @ColumnInfo(name = "cut_date")
    private long cutDate;

    @ColumnInfo(name = "anual_fee")
    private float anualFee;

    @ColumnInfo(name = "status")
    private boolean active;
}
