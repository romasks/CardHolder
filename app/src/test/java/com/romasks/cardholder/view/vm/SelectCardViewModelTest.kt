package com.romasks.cardholder.view.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.romasks.cardholder.data.repository.FakeCardsRepository
import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import com.romasks.cardholder.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class SelectCardViewModelTest {

  private lateinit var viewModel: SelectCardViewModel

  private val mainThreadSurrogate = newSingleThreadContext("UI Thread")

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @Before
  fun setUp() {
    Dispatchers.setMain(mainThreadSurrogate)
//    collectCardsUseCase = Mockito.mock(CollectCardsUseCase::class.java)
//    Mockito.`when`(collectCardsUseCase.getAllCards()).thenReturn(cardsList)
    val repository = FakeCardsRepository()
    val useCase = CollectCardsUseCase(repository)
    viewModel = SelectCardViewModel(useCase)
  }

  @After
  fun tearDown() {
    Dispatchers.resetMain()
    mainThreadSurrogate.close()
  }

  @Test
  fun getCards_updateLiveData() {
    assertThat(viewModel.cards.getOrAwaitValue()).isEqualTo(cardsList)
  }

}