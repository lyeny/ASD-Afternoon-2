package com.example.asd.hotels.DB_TABLE

object DBName {

    const val DATABASE_NAME: String = "ASD_HOTELS.db"
    const val HOTEL_TABLE_NAME: String = "hotel"
    const val CUSTOMER_TABLE_NAME: String = "customer"
    const val RATING_TABLE_NAME: String = "rating"
    const val CATEGORY_TABLE_NAME: String = "category"
    const val LOCATION_TABLE_NAME: String = "location"
    const val ACTIVITY_TABLE_NAME: String = "activity"
    const val ACTIVITY_AVAILABILITY_TABLE_NAME: String = "activity_availability"
    const val USER_TABLE_NAME: String = "user"
    const val PHOTOGALLERY_TABLE_NAME: String = "photogallery"
    const val DATABASE_VERSION: Int = 1

    const val HOTEL_ID_COLUMN = "hotel_id"
    const val HOTEL_NAME_COLUMN = "hotel_name"
    const val HOTEL_CAPACITY_COLUMN = "hotel_capacity"
    const val HOTEL_PRICE_COLUMN = "hotel_price"
    const val HOTEL_DESCRIPTION_COLUMN = "hotel_description"

    const val HOTEL_CATEGORY_ID_COLUMN = "category_id"
    const val HOTEL_CATEGORY_NAME_COLUMN = "category_name"

    const val HOTEL_LOCATION_ID_COLUMN = "location_id"
    const val HOTEL_LOCATION_NAME_COLUMN = "location_name"

    const val HOTEL_PHOTOGALLERY_ID_COLUMN = "photogallery_id"
    const val HOTEL_PHOTOGALLERY_DIRECTION_COLUMN = "photogallery_directory"

    const val HOTEL_CUSTOMER_ID_COLUMN = "customer_id"
    const val HOTEL_CUSTOMER_NAME_COLUMN = "customer_name"
    const val HOTEL_CUSTOMER_STAR_COLUMN = "star"
    const val HOTEL_CUSTOMER_COMMENT_COLUMN = "comment"

    const val HOTEL_USER_ID_COLUMN = "user_id"
    const val HOTEL_USER_NAME_COLUMN = "user_name"
    const val HOTEL_USER_PASSW_COLUMN = "user_password"
    const val HOTEL_USER_ADMIN_COLUMN = "user_isadmin"

    const val HOTEL_ACTIVITY_ID_COLUMN = "activity_id"
    const val HOTEL_ACTIVITY_NAME_COLUMN = "activity_name"

    const val HOTEL_ACTIVITY_AVAILABILITY_ID_COLUMN = "activity_id"
    const val HOTEL_ACTIVITY_AVAILABILITY_HOTEL_ID_COLUMN = "hotel_id"


    const val CREATE_HOTEL_TABLE = "CREATE TABLE $HOTEL_TABLE_NAME( " +
            "$HOTEL_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_CATEGORY_ID_COLUMN INTEGER, " +
            "$HOTEL_LOCATION_ID_COLUMN INTEGER, " +
            "$HOTEL_NAME_COLUMN TEXT NOT NULL, " +
            "$HOTEL_CAPACITY_COLUMN INTEGER NOT NULL," +
            "$HOTEL_PRICE_COLUMN INTEGER NOT NULL, " +
            "$HOTEL_DESCRIPTION_COLUMN TEXT NOT NULL, " +
            "$HOTEL_PHOTOGALLERY_ID_COLUMN INTEGER, " +
            " FOREIGN KEY ($HOTEL_CATEGORY_ID_COLUMN) REFERENCES $CATEGORY_TABLE_NAME" +
            "($HOTEL_CATEGORY_ID_COLUMN), " +
            " FOREIGN KEY ($HOTEL_LOCATION_ID_COLUMN) REFERENCES $LOCATION_TABLE_NAME " +
            "($HOTEL_LOCATION_ID_COLUMN), " +
            " FOREIGN KEY ($HOTEL_PHOTOGALLERY_ID_COLUMN) REFERENCES $PHOTOGALLERY_TABLE_NAME " +
            "($HOTEL_PHOTOGALLERY_ID_COLUMN));"

    const val CREATE_CUSTOMER_TABLE: String = "CREATE TABLE $CUSTOMER_TABLE_NAME " +
            "($HOTEL_CUSTOMER_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_USER_ID_COLUMN INTEGER, " +
            "$HOTEL_CUSTOMER_NAME_COLUMN TEXT NOT NULL," +
            "FOREIGN KEY ($HOTEL_USER_ID_COLUMN) REFERENCES $USER_TABLE_NAME" +
            "($HOTEL_USER_ID_COLUMN));"

    const val CREATE_RATING_TABLE: String = "CREATE TABLE $RATING_TABLE_NAME " +
            "($HOTEL_CATEGORY_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_CUSTOMER_ID_COLUMN INTEGER, " +
            "$HOTEL_ID_COLUMN INTEGER, " +
            "$HOTEL_CUSTOMER_STAR_COLUMN INTEGER, " +
            "$HOTEL_CUSTOMER_COMMENT_COLUMN  TEXT," +
            "FOREIGN KEY ($HOTEL_ID_COLUMN) REFERENCES $HOTEL_TABLE_NAME " +
            "($HOTEL_ID_COLUMN)," +
            "FOREIGN KEY ($HOTEL_CUSTOMER_ID_COLUMN) REFERENCES $CUSTOMER_TABLE_NAME " +
            "($HOTEL_CUSTOMER_ID_COLUMN));"

    const val CREATE_CATEGORY_TABLE: String = "CREATE TABLE $CATEGORY_TABLE_NAME " +
            "($HOTEL_CATEGORY_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_CATEGORY_NAME_COLUMN TEXT NOT NULL);"

    const val CREATE_LOCATION_TABLE: String = "CREATE TABLE $LOCATION_TABLE_NAME " +
            "($HOTEL_LOCATION_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_LOCATION_NAME_COLUMN TEXT NOT NULL);"

    const val CREATE_ACTIVITY_TABLE: String = "CREATE TABLE $ACTIVITY_TABLE_NAME " +
            "($HOTEL_ACTIVITY_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_ACTIVITY_NAME_COLUMN TEXT NOT NULL);"

    const val CREATE_ACTIVITY_AVAILABILITY_TABLE: String =
        "CREATE TABLE $ACTIVITY_AVAILABILITY_TABLE_NAME " +
                "($HOTEL_ACTIVITY_AVAILABILITY_ID_COLUMN INTEGER, " +
                "$HOTEL_ACTIVITY_AVAILABILITY_HOTEL_ID_COLUMN INTEGER," +
                "FOREIGN KEY ($HOTEL_ACTIVITY_AVAILABILITY_ID_COLUMN) REFERENCES " +
                "$ACTIVITY_TABLE_NAME " +
                "($HOTEL_ACTIVITY_ID_COLUMN)," +
                "FOREIGN KEY ($HOTEL_ACTIVITY_AVAILABILITY_HOTEL_ID_COLUMN)" +
                "REFERENCES $HOTEL_TABLE_NAME " +
                "($HOTEL_ID_COLUMN));"

    const val CREATE_USER_TABLE: String = "CREATE TABLE $USER_TABLE_NAME " +
            "($HOTEL_USER_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_USER_NAME_COLUMN TEXT NOT NULL, " +
            "$HOTEL_USER_PASSW_COLUMN TEXT NOT NULL, " +
            "$HOTEL_USER_ADMIN_COLUMN BOOLEAN);"

    const val CREATE_PHOTOGALLERY_TABLE: String = "CREATE TABLE $PHOTOGALLERY_TABLE_NAME " +
            "($HOTEL_PHOTOGALLERY_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$HOTEL_PHOTOGALLERY_DIRECTION_COLUMN TEXT NOT NULL);"


    const val CREATE_ALL_TABLES = CREATE_HOTEL_TABLE +
            CREATE_CUSTOMER_TABLE + CREATE_RATING_TABLE + CREATE_CATEGORY_TABLE +
            CREATE_ACTIVITY_TABLE + CREATE_ACTIVITY_AVAILABILITY_TABLE +
            CREATE_USER_TABLE + CREATE_PHOTOGALLERY_TABLE + CREATE_LOCATION_TABLE


    const val SQL_DELETE_ENTRIES: String = "DROP TABLE IF EXISTS ${HOTEL_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${CUSTOMER_TABLE_NAME}; " +
            " DROP TABLE IF EXISTS ${RATING_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${CATEGORY_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${ACTIVITY_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${ACTIVITY_AVAILABILITY_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${USER_TABLE_NAME};" +
            " DROP TABLE IF EXISTS ${PHOTOGALLERY_TABLE_NAME};"
}