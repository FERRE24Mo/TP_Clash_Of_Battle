import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tp_clash_of_battle.database.PlayerDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Player::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDAO
    companion object {

        var INSTANCE: AppDatabase? = null
        fun init(context: Context){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "la_base_de_donnees"
            )
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        var dao = INSTANCE?.playerDao();
                        GlobalScope.launch {
                            for (trip in defaultTrips){
                                dao?.insert(trip)
                            }
                        }
                    }
                }).build()
        }
    }
}