package ru.embersoft.expandablecardview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DatabaseVersion = 1;
    private static final String DatabaseName = "LocationAssistDB";



    public DBHandler(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query;

        query = "CREATE TABLE Point (" +
                "id             INTEGER PRIMARY KEY," +

                "transformer_sin                    TEXT," +
                "transformer_name                   TEXT," +
                "transformer_capacity               TEXT," +
                "transformer_serial_no              TEXT," +
                "transformer_voltage_ratio          TEXT," +
                "transformer_type                   TEXT," +
                "transformer_installation_type      TEXT," +
                "transformer_no_of_feeders          TEXT," +
                "transformer_year_manufacture       TEXT," +
                "transformer_manufacture            TEXT," +

                "pole_construction           TEXT," +
                "pole_size                   TEXT," +
                "pole_capacity               TEXT," +
                "pole_environment            TEXT," +
                "pole_base            	TEXT," +
                "pole_stay	                 TEXT," +
                "pole_strut	                 TEXT," +
                "pole_flying_stay	         TEXT," +
                "pole_circuits	             TEXT," +

                "circuits1_conductor_id	         TEXT," +
                "circuits1_conductor_type	        TEXT," +
                "no_circuits1_spur	                    TEXT," +
                "circuits1_service_1p_30	        TEXT," +
                "circuits1_service_3p_30	        TEXT," +
                "circuits1_service_3p_60	        TEXT," +
                "connection_type     			TEXT," +
                "account_number     			TEXT," +
                "service_line_type         TEXT," +


                "street_lamps_led            TEXT," +
                "street_lamps_cfl            TEXT," +
                "street_lamps_FL             TEXT," +
                "street_lamps_other          TEXT," +

                "pv_genaration_plant_type                TEXT," +
                "pv_genaration_plant_capacity            TEXT," +
                "genaration_plant_connected_feeder       TEXT," +

                "note                 TEXT," +

                "time_stamp            TEXT," +
                "sync_time             TEXT," +
                "satus	               TEXT" +
                ");";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Point");

    }
}
