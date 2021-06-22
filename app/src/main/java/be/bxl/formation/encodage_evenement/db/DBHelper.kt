package be.bxl.formation.encodage_evenement.db

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper (val context : Context) :
    SQLiteOpenHelper(context, DbInfo.DB_NAME, null, DbInfo.DB_VERSION){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DbInfo.Product.REQUEST_CREATE)
    }

    // Méthode appelé automatiquement si l'app  contient une version précédente de la base de donnée
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Pour la mise a jour de la DB, solution simple => On detruit et on recrée
        db.execSQL(DbInfo.Event.REQUEST_DELETE)
        onCreate(db)

        // Note : pour les données sensible -> Faite une mise a jour avec des ALTER TABLE ;)
    }
}