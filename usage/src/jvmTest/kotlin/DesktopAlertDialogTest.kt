/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntSize
import com.usage.runSimpleComposableWindow
import org.hamcrest.MatcherAssert.assertThat
import org.junit.runners.JUnit4
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalMaterialApi::class)
fun main() {
  var rootSize = IntSize(1024, 768) // default value
  var dialogSize = IntSize(150, 150)
  var location = Offset.Zero
  runSimpleComposableWindow() {
    CompositionLocalProvider(LocalDensity provides Density(1f, 1f)) {
      AlertDialog(
        onDismissRequest = {},
        title = { Text("AlerDialog") },
        text = { Text("Apply?") },
        confirmButton = { Button(onClick = {}) { Text("Apply") } },
        modifier = Modifier.size(dialogSize.width.dp, dialogSize.height.dp)
          .onGloballyPositioned { location = it.positionInRoot() }
      )
    }
  }
}
