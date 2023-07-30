package xyz.tberghuis.floatingtimer.service.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import xyz.tberghuis.floatingtimer.TIMER_SIZE_DP
import kotlin.math.min
import xyz.tberghuis.floatingtimer.PROGRESS_ARC_WIDTH
import xyz.tberghuis.floatingtimer.common.TimeDisplay
import xyz.tberghuis.floatingtimer.composables.Trash
import xyz.tberghuis.floatingtimer.service.ServiceState

// this is only displayed in fullscreen overlay when isDragging=true
@Composable
fun CountdownOverlay(state: ServiceState) {
  val countdownState = state.countdownState
  val overlayState = countdownState.overlayState
  // should i use derivedStateOf ???
  // i don't understand the benefit

  val context = LocalContext.current

  Box(Modifier.onGloballyPositioned {
    val density = context.resources.displayMetrics.density
    val timerSizePx = (TIMER_SIZE_DP * density).toInt()
    val x = min(overlayState.timerOffset.x, state.screenWidthPx - timerSizePx)
    val y = min(overlayState.timerOffset.y, state.screenHeightPx - timerSizePx)
    overlayState.timerOffset = IntOffset(x, y)
  }) {
    val modifier = Modifier.offset {
      overlayState.timerOffset
    }
    CountdownBubble(modifier, countdownState)
  }

  Column(
    Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Trash(overlayState)
  }
}

@Composable
fun CountdownBubble(modifier: Modifier, countdownState: CountdownState) {
  val timeLeftFraction = countdownState.countdownSeconds / countdownState.durationSeconds.toFloat()
  Box(
    modifier = Modifier
      .then(modifier)
      .size(TIMER_SIZE_DP.dp)
      .padding(PROGRESS_ARC_WIDTH / 2)
      .zIndex(1f),
    contentAlignment = Alignment.Center
  ) {
    ProgressArc(timeLeftFraction)
    TimeDisplay(countdownState.countdownSeconds)
  }
}