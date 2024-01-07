package xyz.tberghuis.floatingtimer.tmp3

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TmpNavigateResult(
  vm: TmpNavigateResultVm = viewModel()
) {
  Column {
    Text("tmp nav result ${vm.fdfsd}")
  }
}

class TmpNavigateResultVm : ViewModel() {
  val fdfsd = "fdsfs"
}