package com.edge.calculator

import com.edge.calculator.output.OutputInterfaceView
import com.edge.calculator.output.OutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class OuputTest{
    private val mnPresenter = OutputPresenter
    private val mnMockView = Mockito.mock(OutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`(){
        mnPresenter.attach(mnMockView)

        mnPresenter.add("1")
        then(mnMockView).should().setequation("1")
        mnPresenter.add("+")
        then(mnMockView).should().setequation("1+")
        mnPresenter.add("1")
        then(mnMockView).should().setequation("1+1")
        then(mnMockView).should().setOutcome("1")
    }
}