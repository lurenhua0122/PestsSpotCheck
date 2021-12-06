package cn.com.aiton.pestsspotcheck

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import cn.com.aiton.pestsspotcheck.databinding.SpinnerLayoutBinding

/**
 * Adapter to display both a string and icon beside each other in a spinner.
 * Used here to populate the options for LocationDisplay.AutoPanMode.
 */
class SpinnerAdapter(
    context: Activity,
    id: Int,
    private val list: ArrayList<ItemData>
) :
    ArrayAdapter<ItemData?>(context, id, list as List<ItemData?>) {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val spinnerLayoutBinding = SpinnerLayoutBinding.inflate(this.inflater)
        val imageView = spinnerLayoutBinding.locationPointImageView
        imageView.setImageResource(list[position].imageId)
        val textView = spinnerLayoutBinding.locationTextView
        textView.text = list[position].text
        return spinnerLayoutBinding.root
    }

    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        return getView(position, convertView, parent)
    }
}

data class ItemData(val text: String, val imageId: Int)