package xyz.tberghuis.floatingtimer.tmp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TmpVm(private val application: Application) : AndroidViewModel(application) {
//  var timerSizeFactor by mutableFloatStateOf(1f)


  var timerSizeScaleFactor by mutableFloatStateOf(0f)

  val isRunningStateFlow = MutableStateFlow(false)
}