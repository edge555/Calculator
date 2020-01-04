package com.edge.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_input.view.*

class InputView(context: Context,attributeSet: AttributeSet?) : RelativeLayout(context,attributeSet){
    init{
        LayoutInflater.from(context).inflate(R.layout.view_input,this,true);

        attributeSet?.run {
            val typedArray = context.obtainStyledAttributes(attributeSet,R.styleable.InputView)
            val textResource = typedArray.getString(R.styleable.InputView_item_text)
            val iconResource = typedArray.getResourceId(R.styleable.InputView_item_icon,-1)

            when{
                iconResource != -1 -> {
                    inp_ele_text.visibility = View.GONE
                    inp_ele_image.apply {
                        visibility = View.VISIBLE
                        setImageResource(iconResource)
                    }
                }
                !textResource.isNullOrEmpty() -> {
                    inp_ele_image.visibility = View.GONE
                    inp_ele_text.apply {
                        visibility = View.VISIBLE
                        text = textResource
                    }
                }
                else -> {
                    inp_ele_image.visibility = View.GONE
                    inp_ele_text.visibility = View.GONE
                }
            }
            typedArray.recycle()
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        inp_ele_click.setOnClickListener(l)
    }
}