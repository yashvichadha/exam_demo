package com.example.exam_demo.database;



import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.exam_demo.model.user;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {



    private static final String DB_NAME= "Examdemo.db";
    private static final int DB_VERSION= 1;

    public static  final String TABLE_NAME= "listStudent";


    public static final String NAME_COL="name";
    public static final String EMAIL_COL="email";
    public static final String MOBILE_COL="mobilenumber ";
    public static final String PASSWORD_col="password";
    public static final String ID_col="id";




    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable = "CREATE TABLE  "+ TABLE_NAME+"("+
                ID_col+ " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                NAME_COL+ " VARCHAR(50) ,"+
                EMAIL_COL+ " VARCHAR(100) ,"+
                MOBILE_COL+ " INTEGER," +
                PASSWORD_col+" VARCHAR(30) "+")";

        db.execSQL(createTable);


    }
    public DbHandler(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

//add new user
    public void addNewUSER (user User )
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL,User.getName());
        values.put(EMAIL_COL,User.getEmail());
        values.put(MOBILE_COL,User.getPhoneno());
        values.put(PASSWORD_col,User.getPassword());

        db.insert (TABLE_NAME,null,values);

        db.close();

    }


    //get all data

    @SuppressLint("Range")
    public List<user> getAllUser()
    {

        String[]columns={
                ID_col,
                NAME_COL,
                EMAIL_COL,
                MOBILE_COL,
                PASSWORD_col
        };

        String sortOrder= NAME_COL+ "ASC";
        List<user>userList= new ArrayList<user>();
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.query(TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst())
        {
            do {
                user User = new user();
                User.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_col))));
                User.setName(cursor.getString(cursor.getColumnIndex(NAME_COL)));
                User.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL_COL)));
                User.setPhoneno(cursor.getString(cursor.getColumnIndex(MOBILE_COL)));
                User.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD_col)));

                userList.add(User);

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return userList;
    }



// check user exists
    //email

    public boolean checkuser(String email)
    {
        String[] columns={ID_col};
        SQLiteDatabase db= this.getReadableDatabase();

        String selection= EMAIL_COL+"=?";

        String[] selectionArgs= {email};


        Cursor cursor=db.query(TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorcount=cursor.getCount();
        cursor.close();
       // db.close();
        if (cursorcount>0){
            return  true;

        }
        return false;

    }


    //check user exists
    //email password


    public boolean checkuser(String email, String password)
    {
        String[] columns={ID_col};

        SQLiteDatabase db= this.getReadableDatabase();

        String selection= EMAIL_COL + " = ?" + " AND " + PASSWORD_col + " = ?";
        String[] selectionargs= {email,password};

        Cursor cursor= db.query(TABLE_NAME,
                columns,
                selection,
                selectionargs,
                null,
                null,
                null);


        int cursorcount=cursor.getCount();

        cursor.close();
       db.close();
        if (cursorcount>0){
            return true;
        }
        return false;
    }










   /* public void addNewUSER (String uname, String uEmail, String uMobile, String uPassword )
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, uname);
        values.put(EMAIL_COL,uEmail);
        values.put(MOBILE_COL, uMobile);
        values.put(PASSWORD_col, uPassword);

        db.insert (TABLE_NAME,null,values);

    }

    */



    /*public String getloginData(String uemail, String upass) {

        SQLiteDatabase db = getReadableDatabase();
        String[] colums = new String[]{EMAIL_COL, PASSWORD_col};
        Cursor cursor = db.query(TABLE_NAME, colums, null, null, null, null, null);


       // int iId = cursor.getColumnIndex(ID_col);
        //int iname = cursor.getColumnIndex(NAME_COL);
        int iemail = cursor.getColumnIndex(EMAIL_COL);
        //int imobile = cursor.getColumnIndex(MOBILE_COL);
        int ipassward = cursor.getColumnIndex(PASSWORD_col);


        String result = "";


        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            result = result +
                   // "Id :" + cursor.getString(iId) + "\n" +
                    //"Name :" + cursor.getString(iname) + "\n" +
                    "Email :" + cursor.getString(iemail) + "\n" +
                    //"Mobile :" + cursor.getString(imobile) + "\n" +
                    "Passward :" + cursor.getString(ipassward) + "\n\n";


        }

        return result;
    }

     */

   /*
   public String getData(){


        SQLiteDatabase db = getReadableDatabase();
        String[] colums= new String[]{ID_col,NAME_COL,EMAIL_COL,MOBILE_COL,PASSWORD_col};
        Cursor cursor= db.query(TABLE_NAME,colums,null,null,null,null,null);


        int iId=cursor.getColumnIndex(ID_col);
        int iname=cursor.getColumnIndex(NAME_COL);
        int iemail=cursor.getColumnIndex(EMAIL_COL);
        int imobile=cursor.getColumnIndex(MOBILE_COL);
        int ipassward = cursor.getColumnIndex(PASSWORD_col);



        String result="";



        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {
            result=result+
                    "Id :"+cursor.getString(iId)+"\n"+
                    "Name :"+cursor.getString(iname)+"\n"+
                    "Email :"+cursor.getString(iemail)+"\n"+
                    "Mobile :"+cursor.getString(imobile)+"\n"+
                    "Passward :"+cursor.getString(ipassward)+"\n\n";


        }

        return result;

}

    */





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }
}
