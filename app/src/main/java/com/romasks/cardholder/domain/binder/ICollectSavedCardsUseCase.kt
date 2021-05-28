package com.romasks.cardholder.domain.binder

import com.romasks.cardholder.domain.entity.SavedCard
import kotlinx.coroutines.flow.Flow

interface ICollectSavedCardsUseCase {
  fun getSavedCards(): Flow<List<SavedCard>>
}