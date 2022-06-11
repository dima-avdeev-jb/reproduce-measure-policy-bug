package lib

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy

class ClassWithProperty1 {
    internal /*or public*/ val someProperty = ValueOrInlineClass()

    @Composable
    fun composableFun() {
        Layout(
            measurePolicy = { _, _ ->
                println(someProperty)
                layout(1, 1) {}
            }
        )
    }
}

@kotlin.jvm.JvmInline
value /*or inline*/ class ValueOrInlineClass(val innerValue: String = "")
