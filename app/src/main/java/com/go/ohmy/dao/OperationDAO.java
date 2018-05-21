package com.go.ohmy.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.go.ohmy.entity.Operation;

import java.util.List;

@Dao
public interface OperationDAO {

    @Insert
    void insert(Operation operation);

    @Query("DELETE FROM operation")
    void deleteAll();

    @Query("SELECT * FROM operation ORDER BY applyDate DESC")
    LiveData<List<Operation>> getAllOperations();

}
