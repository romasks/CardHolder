package com.romasks.cardholder.domain.binder

import com.romasks.cardholder.domain.entity.Card

interface ICollectCardsUseCase {
  fun getAllCards(): List<Card>
}