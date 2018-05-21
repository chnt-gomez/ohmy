package com.go.ohmy.balance;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.go.ohmy.entity.Operation;
import com.go.ohmy.repo.OperationRepository;

import java.util.List;

public class BalanceViewModel extends AndroidViewModel {

    private OperationRepository operationRepository;
    private LiveData<List<Operation>> allOperations;

    public BalanceViewModel(@NonNull Application application) {
        super(application);
        operationRepository = new OperationRepository(application);
        allOperations = operationRepository.getAllOperations();
    }

    public LiveData<List<Operation>> getAllOperations(){
        return this.allOperations;
    }

    public void insert(Operation ... operations){
        operationRepository.insert(operations);
    }
}
