package com.example.koylinfasten.testClasses

import androidx.lifecycle.ViewModel
import com.example.koylinfasten.ViewModels.QuoteModel
import org.junit.Before
import org.junit.Test

class QuoteTestClass {

    private lateinit var viewModel: QuoteModel

    // Before keyword makes sure this runs before every test case
    @Before
    fun setup(){
        viewModel = QuoteModel()
    }



    @Test
    fun authorNameTest(){
        viewModel.authorGet()
        assert(!viewModel.stg.isEmpty())
    }

    @Test
    fun quoteTest(){
        viewModel.authorGet()
        assert(!viewModel.stg2.isEmpty())
    }
}