package com.go.ohmy.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "card")
public class Card {

    @PrimaryKey (autoGenerate = false)
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo (name = "alias")
    private String alias;


}
