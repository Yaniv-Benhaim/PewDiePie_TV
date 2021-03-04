package tech.gamedev.pewdiepietv.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import tech.gamedev.pewdiepietv.R
import tech.gamedev.pewdiepietv.adapters.FeaturedItemsAdapter
import tech.gamedev.pewdiepietv.adapters.VideoAdapter
import tech.gamedev.pewdiepietv.data.models.Video
import tech.gamedev.pewdiepietv.databinding.FragmentHomeBinding
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var videoAdapter: VideoAdapter
    @Inject
    lateinit var featuredAdapter: FeaturedItemsAdapter

    @Inject
    lateinit var glide: RequestManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        setupFeaturedRV()
        setup2021RV()
    }

    private fun setupFeaturedRV() = binding.vpFeatured.apply {
        layoutDirection = View.LAYOUT_DIRECTION_LTR
        adapter = featuredAdapter
        featuredAdapter.startListening()
    }

    private fun setup2021RV() = binding.rv2021.apply {
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        videoAdapter = VideoAdapter(homeViewModel.get2021VideoOptions(), glide)
        adapter = videoAdapter
        videoAdapter.startListening()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        featuredAdapter.stopListening()
        videoAdapter.stopListening()
    }


}