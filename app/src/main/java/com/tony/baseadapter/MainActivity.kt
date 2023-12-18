package com.tony.baseadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.constraintlayout.utils.widget.MockView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val recyclerView = findViewById<RecyclerView>(R.id.rcView)
//        val adapter = ConcreteAdapter(
//            itemClickListener = { item ->
//                // Handle item click
//                // This code will be executed when an item is clicked
//            },
//            layoutResId = R.layout.item_your, // Replace with your item layout
//            bindViewHolder = { holder, item ->
//                // Implement the binding logic for the ViewHolder here
//                // This code will be executed for each item during binding
//                holder.itemView.findViewById<TextView>(R.id.tvTest).text = item.myText
//                holder.itemView.findViewById<TextView>(R.id.tvTest2).text = item.myText + "World"
//            }
//        )
//
//        recyclerView.adapter = adapter
//        adapter.submitList(createMock())

        val recyclerViewText = findViewById<RecyclerView>(R.id.rcView)
//        val recyclerViewImage = findViewById<RecyclerView>(R.id.recyclerImage)

        recyclerViewText.adapter = object : GenericListAdapter<String>(
            R.layout.item_your,
            bind = { item, holder, itemCount ->
                with(holder.itemView) {
                    this.findViewById<TextView>(R.id.tvTest).text =
                        "index: ${holder.adapterPosition} $item - itemCount: $itemCount "
                }

            }
        ) {}.apply {
            submitList(
                ("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                        "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. " +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                        "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.").split(
                    "."
                )
            )
        }

    }
}