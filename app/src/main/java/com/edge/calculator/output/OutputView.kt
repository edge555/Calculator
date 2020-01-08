package com.edge.calculator.output

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.edge.calculator.R
import kotlinx.android.synthetic.main.view_output.view.*

class OutputView (context: Context, attributeSet: AttributeSet?) : LinearLayout(context,attributeSet), OutputInterfaceView{
    init{
        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        LayoutInflater.from(context).inflate(R.layout.view_output,this,true)
    }

    fun addItem(item : String){
        OutputPresenter.add(item)
    }

    fun removeItem(){
        OutputPresenter.remove()
    }

    fun solve(){
        OutputPresenter.solve()

    }

    fun clear(){
        OutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        OutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        OutputPresenter.detach()
    }

    override fun setequation(equation: String) {
        calc_input_equ.text = equation
    }

    override fun setOutcome(outcome: String) {
        calc_input_out.text = outcome
    }
}