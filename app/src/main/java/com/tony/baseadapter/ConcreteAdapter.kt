package com.tony.baseadapter

class ConcreteAdapter(
    itemClickListener: (MyDataClass) -> Unit,
    layoutResId: Int,
    bindViewHolder: (BaseAdapter<MyDataClass>.ItemViewHolder, MyDataClass) -> Unit
) : BaseAdapter<MyDataClass>(itemClickListener, layoutResId, bindViewHolder)

data class MyDataClass(
    val myText: String = "Hello"
)

fun createMock(): MutableList<MyDataClass> =
    mutableListOf(
        MyDataClass("Text 1"),
        MyDataClass("Text 2"),
        MyDataClass("Text 3"),
        MyDataClass("Text 4"),
        MyDataClass("Text 5"),
        MyDataClass("Text 6"),
        MyDataClass("Text 7"),
        MyDataClass("Text 8"),
    )