package newsproject.newstime.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import newsproject.newstime.BuildConfig
import newsproject.newstime.data.source.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import zerobranch.androidremotedebugger.logging.NetLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Named("searchFilms")
    @Provides
    @Singleton
    fun filmsApi(): Api = Retrofit
        .Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)

    @Provides
    @Singleton
    fun booksApi(): Api = Retrofit
        .Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)

    @Named("accountApi")
    @Provides
    @Singleton
    fun accountApi(okHttpClient: OkHttpClient): Api = Retrofit
        .Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
        .create(Api::class.java)

    @Provides
    @Singleton
    fun okHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.header("Authorization", BuildConfig.HEADER_ID)
                chain.proceed(requestBuilder.build())
            }
            .addInterceptor(NetLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("MySettings", MODE_PRIVATE)
}