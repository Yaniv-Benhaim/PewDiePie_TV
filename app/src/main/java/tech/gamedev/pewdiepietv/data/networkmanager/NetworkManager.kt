package tech.gamedev.pewdiepietv.data.networkmanager

import androidx.paging.PagedList
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import tech.gamedev.pewdiepietv.data.models.Video
import javax.inject.Inject

class NetworkManager() {

    fun provideFirestoreOptions2021(db: FirebaseFirestore): FirestorePagingOptions<Video> {
        val query = db.collection("videos").orderBy("timestamp", Query.Direction.DESCENDING)
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(10)
            .setPageSize(8)
            .build()

        return FirestorePagingOptions.Builder<Video>()
            .setQuery(query, config, Video::class.java)
            .build()
    }
}