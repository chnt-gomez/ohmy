package com.go.ohmy.repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.go.ohmy.OhMyDatabase;
import com.go.ohmy.dao.OperationDAO;
import com.go.ohmy.entity.Operation;

import java.util.List;

public class OperationRepository {

    private OperationDAO operationDAO;

    private LiveData<List<Operation>> allOperations;

    public OperationRepository(Application application){
        OhMyDatabase db = OhMyDatabase.getInstance(application);
        operationDAO = db.operationDAO();
        allOperations = operationDAO.getAllOperations();
    }

    public LiveData<List<Operation>> getAllOperations(){
        return this.allOperations;
    }

    public void insert (Operation ... params){
        new InsertTask(operationDAO).execute(params);
    }

    private static class InsertTask extends AsyncTask<Operation, Void, Void>{
        private OperationDAO taskDao;

        InsertTask(OperationDAO dao){
            taskDao = dao;
        }

        @Override
        protected Void doInBackground(Operation... operations) {
            for (Operation o : operations){
                taskDao.insert(o);
            }
            return null;
        }
    }

}
