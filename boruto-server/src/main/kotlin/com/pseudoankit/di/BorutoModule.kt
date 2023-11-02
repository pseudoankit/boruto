package com.pseudoankit.di

import com.pseudoankit.repository.HeroRepository
import com.pseudoankit.repository.HeroRepositoryImpl
import org.koin.dsl.module

val borutoModule = module {
    single<HeroRepository> { HeroRepositoryImpl() }
}