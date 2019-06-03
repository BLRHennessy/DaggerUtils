package by.makarevich.daggerutils.dagger

import dagger.Module
import dagger.Provides

@Module
class SubPresenterModule {
    @Provides
    fun provideString(): String = "123"
}