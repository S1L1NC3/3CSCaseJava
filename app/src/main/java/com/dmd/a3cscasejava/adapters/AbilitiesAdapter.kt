package com.dmd.a3cscasejava.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.dmd.a3cscasejava.R
import com.dmd.a3cscasejava.models.Abilities
import com.dmd.a3cscasejava.viewHolder.AbilitiesViewHolder

class AbilitiesAdapter(context: Context, private val dataSource: List<Abilities>) : BaseAdapter(){
    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        val viewHolder: AbilitiesViewHolder
        val rowView: View?

        if (view == null) {
            rowView = layoutInflater.inflate(R.layout.item_ability, viewGroup, false)

            viewHolder = AbilitiesViewHolder(rowView)
            rowView.tag = viewHolder

        } else {
            rowView = view
            viewHolder = rowView.tag as AbilitiesViewHolder
        }

        viewHolder.txtName.text = dataSource[position].ability.name

        return  rowView
    }
}