package xyz.tberghuis.floatingtimer.tmp4

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
data class TmpSavedTimer(
  @PrimaryKey val id: Int,
  @ColumnInfo(name = "timer_type") val timerType: String,
  @ColumnInfo(name = "timer_shape") val timerShape: String
)

@Dao
interface TmpSavedTimerDao {
  @Query("SELECT * FROM TmpSavedTimer")
  fun getAll(): List<TmpSavedTimer>

  @Insert
  fun insertAll(vararg timers: TmpSavedTimer)

  @Delete
  fun delete(timer: TmpSavedTimer)
}