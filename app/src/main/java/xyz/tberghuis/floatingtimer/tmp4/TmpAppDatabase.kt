package xyz.tberghuis.floatingtimer.tmp4

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [TmpSavedTimer::class], version = 1, exportSchema = true,
  autoMigrations = [
//    AutoMigration(from = 1, to = 2)
  ]
)
abstract class TmpAppDatabase : RoomDatabase() {
  abstract fun tmpSavedTimerDao(): TmpSavedTimerDao
}