package be.bxl.formation.encodage_evenement.db

class DbInfo {

    val DB_NAME = "my_db"
    val DB_VERSION = 1

    object Event {
        // Nom de la table
        const val TABLE_NAME = "event"

        // Nom des colonnes
        const val COLUMN_ID = "_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_ISDONE= "isdone"

        // Requetes
        const val REQUEST_CREATE = ("CREATE TABLE " + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT NOT NULL, "
                + COLUMN_ISDONE + " TEXT "
                + ");")
        const val REQUEST_DELETE = "DROP TABLE " + TABLE_NAME + ";"
    }
}