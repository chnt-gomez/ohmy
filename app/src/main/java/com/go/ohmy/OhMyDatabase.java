package com.go.ohmy;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.go.ohmy.dao.OperationDAO;
import com.go.ohmy.entity.Operation;

@Database(entities = {Operation.class}, version = 1)
public abstract class OhMyDatabase extends RoomDatabase{

    private static OhMyDatabase INSTANCE;

    public static OhMyDatabase getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (OhMyDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        OhMyDatabase.class, "oh_my_database").build();
            }
        }
        return INSTANCE;
    }

    public abstract OperationDAO operationDAO();

}
