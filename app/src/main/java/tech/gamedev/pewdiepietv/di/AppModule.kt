package tech.gamedev.pewdiepietv.di

import android.content.Context
import androidx.paging.PagedList
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.gamedev.pewdiepietv.R
import tech.gamedev.pewdiepietv.adapters.FeaturedItemsAdapter
import tech.gamedev.pewdiepietv.adapters.VideoAdapter
import tech.gamedev.pewdiepietv.data.models.Video
import tech.gamedev.pewdiepietv.data.networkmanager.NetworkManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.img_splash_background)
            .error(R.drawable.img_splash_background)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

    @Provides
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideFirestoreOptions(db: FirebaseFirestore): FirestorePagingOptions<Video> {
        val query = db.collection("videos")
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return FirestorePagingOptions.Builder<Video>()
            .setQuery(query, config, Video::class.java)
            .build()
    }

    @Singleton
    @Provides
    fun provideFeaturedAdapter(options: FirestorePagingOptions<Video>, glide: RequestManager) = FeaturedItemsAdapter(options, glide)

    @Singleton
    @Provides
    fun provideVideoAdapter(options: FirestorePagingOptions<Video>, glide: RequestManager) = VideoAdapter(options, glide)

    @Singleton
    @Provides
    fun provideNetworkManager() = NetworkManager()


}