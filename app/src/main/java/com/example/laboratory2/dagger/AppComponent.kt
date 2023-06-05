package com.example.laboratory2.dagger

import com.example.laboratory2.ViewModel
import com.example.laboratory2.api.ApiService
import com.example.laboratory2.dagger.repository.Repository
import com.example.laboratory2.dagger.repository.RepositoryImpl
import com.example.laboratory2.dagger.usecase.UseCase
import com.example.laboratory2.dagger.usecase.UseCaseImpl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Component(modules = [
    NetworkModule ::class,
    UseCaseModule::class,
    RepositoryModule::class])
interface AppComponent {
    fun inject(repositoryImpl: RepositoryImpl)
    fun inject(viewModel: ViewModel)
    fun apiService() : ApiService
    fun repository() : Repository
    fun useCase() : UseCase
}

@Module
object NetworkModule  {
    val API_URL = "https://develtop.ru/study/"

    @Provides
    fun provideApiService(): ApiService  = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create()
}

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindUseCase(useCaseImpl: UseCaseImpl): UseCase
}

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}