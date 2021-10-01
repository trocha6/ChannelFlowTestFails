package com.temppackage.viewmodeltest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NumbersProviderTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: NumbersViewModel
    @Before
    fun setUp() {
        viewModel = NumbersViewModel()
    }


    @Test
    fun `provider_provides_10_values`() {
        viewModel.startCollecting()
        mainCoroutineRule.advanceTimeBy(2000)
        val numbers = viewModel.numbers.value

        assertThat(numbers?.size).isEqualTo(10)
    }
}