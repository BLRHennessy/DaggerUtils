package by.makarevich.daggerutils.dagger

import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class GeneralActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope