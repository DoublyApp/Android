package com.votives.server;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.votives.R;
import com.votives.objects.ChatMessage;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/13/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	SQLiteDatabase db;

	public DBOpenHelper(Context context) {
		super(context, context.getResources().getString(R.string.database_name), null, DATABASE_VERSION);
		onCreate(getWritableDatabase());
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Users ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , UserName TEXT ");
		sqlA.append(" , DOB DATETIME");
		sqlA.append(" , Gender TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS UsersFriends ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , FriendUserID INTEGER ");
		sqlA.append(" , FriendStatus TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS UserInterests ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append("   UserID INTEGER ");
		sqlA.append(" , InterestID INTEGER ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Interests ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , InterestID INTEGER ");
		sqlA.append(" , InterestName TEXT ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS Messages ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , MessageID INTEGER ");
		sqlA.append(" , SenderID INTEGER ");
		sqlA.append(" , ReceiverID INTEGER ");
		sqlA.append(" , MessageText TEXT ");
		sqlA.append(" , TimeCreated DATETIME ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
		sqlA.append("CREATE TABLE IF NOT EXISTS GPS ");
		sqlA.append("(");
		sqlA.append("   _id INTEGER PRIMARY KEY AUTOINCREMENT ");
		sqlA.append(" , UserID INTEGER ");
		sqlA.append(" , Latitude REAL ");
		sqlA.append(" , Longitude REAL ");
		sqlA.append(")");
		db.execSQL(sqlA.toString());

		sqlA.setLength(0);
	}

/*
	public ArrayList<ChatMessage> getChatMessageGroupList(){
		StringBuilder sqlA = new StringBuilder();
		sqlA.setLength(0);
		sqlA.append("SELECT ");
		// display date/time, name/age/gender, most recent message snippet
		sqlA.append("   Users.Name ");
		sqlA.append(" , Users.DOB ");
		sqlA.append(" , Users.Gender ");
		sqlA.append(" , Messages.TimeCreated ");
		sqlA.append(" , Messages.MessageText ");
		//sqlA.append(" , InterestCount ");
		sqlA.append("FROM Users ");
		sqlA.append("INNER JOIN Messages ON Users.UserID = Messages.ReceiverID ");
		sqlA.append("GROUP BY Users.Name ");

		sqlA.setLength(0);
		sqlA = null;
	}

	public ArrayList<ChatMessage> getChatMessageBySender(int senderID){

	}
*/


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}


}
