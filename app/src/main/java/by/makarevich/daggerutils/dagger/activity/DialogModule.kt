package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.utils.DialogManager
import dagger.Module
import dagger.Provides

@Module
class DialogModule {

    @Provides
    @ActivityScope
    fun provideDialogManager() = DialogManager()
}