package ph.edu.dlsu.mobidev.communipic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Cristopher on 11/16/2016.
 */

public class PicturesSQLHelper extends SQLiteOpenHelper{

    public final static String SCHEMA = "picture";
    public final static int VERSION = 1;

    public PicturesSQLHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Picture.TABLE
                + " (" + Picture.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Picture.NAME + " TEXT, "
                + Picture.PICTUREKEY + " INTEGER, "
                + Picture.CATEGORY + " TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + Picture.TABLE + ";";
        db.execSQL(sql);
        onCreate(db);
    }

    // TODO INSERT

    public void insertPicture(Picture picture){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Picture.NAME, picture.getName());
        cv.put(Picture.CATEGORY, picture.getCategory());
        cv.put(Picture.PICTUREKEY, picture.getPictureKey());

        db.insert(Picture.TABLE, null, cv);
    }

    // TODO UPDATE

    public void updatePicture(Picture picture){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Picture.NAME, picture.getName());
        cv.put(Picture.CATEGORY, picture.getCategory());
        cv.put(Picture.PICTUREKEY, picture.getPictureKey());

        db.update(Picture.TABLE, cv, Picture.ID + " =? ",
                new String[]{picture.getId() + ""});

    }

    // TODO DELETE

    public void deletePicture(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Picture.TABLE, Picture.ID + " =? ",
                new String[]{id+""});
    }

    // TODO RETRIEVECONTACT

    public Picture retrievePicture(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Picture.TABLE,
                null,
                " " + Picture.ID + " =? ",
                new String[]{ id+"" },
                null,
                null,
                null
        );

        Picture picture = null;

        if(c.moveToFirst()){
            picture = new Picture();
            picture.setId(c.getInt(c.getColumnIndex(Picture.ID)));
            picture.setName(c.getString(c.getColumnIndex(Picture.NAME)));
            picture.setPictureKey(c.getInt(c.getColumnIndex(Picture.PICTUREKEY)));
            picture.setId(c.getInt(c.getColumnIndex(Picture.ID)));
        }

        return picture;
    }

    // TODO RETRIEVEALLCONTAC

    public Cursor retrieveAllPicturesCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                Picture.TABLE,
                null, // *
                null, // selection string
                null, // selection args
                null, // group by
                null, // having
                null  // order by
        );
    }

    public ArrayList<Picture> retrieveAllPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                Picture.TABLE,
                null, // *
                null, // selection string
                null, // selection args
                null, // group by
                null, // having
                null  // order by
        );

        if(c.moveToFirst()){
            do{
                Picture picture = new Picture();

                picture.setId(c.getInt(c.getColumnIndex(Picture.ID)));
                picture.setName(c.getString(c.getColumnIndex(Picture.NAME)));
                picture.setPictureKey(c.getInt(c.getColumnIndex(Picture.PICTUREKEY)));
                picture.setId(c.getInt(c.getColumnIndex(Picture.ID)));
            }while (c.moveToFirst());
        }

        return pictures;
    }
}
