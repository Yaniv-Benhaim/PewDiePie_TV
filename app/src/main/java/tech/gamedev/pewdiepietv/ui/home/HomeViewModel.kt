package tech.gamedev.pewdiepietv.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import tech.gamedev.pewdiepietv.data.networkmanager.NetworkManager
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val networkManager: NetworkManager, private val db: FirebaseFirestore) : ViewModel() {

    fun get2021VideoOptions() = networkManager.provideFirestoreOptions2021(db)


}