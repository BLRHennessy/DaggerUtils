package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.GeneralActivityScope
import by.makarevich.daggerutils.utils.DialogManager
import dagger.Module
import dagger.Provides

@Module
class DialogModule {

    @Provides
    @GeneralActivityScope
    fun provideDialogManager() = DialogManager()
}