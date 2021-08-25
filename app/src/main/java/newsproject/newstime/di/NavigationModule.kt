package newsproject.newstime.di

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class NavigationModule {
    private val cicerone = Cicerone.create()

    @Provides
    @ActivityRetainedScoped
    fun router() = cicerone.router

    @Provides
    @ActivityRetainedScoped
    fun navigation() = cicerone.getNavigatorHolder()
}