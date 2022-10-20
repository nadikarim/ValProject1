package com.nadikarim.valproject1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nadikarim.valproject1.R
import com.nadikarim.valproject1.core.data.Resource
import com.nadikarim.valproject1.core.ui.AgentAdapter
import com.nadikarim.valproject1.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val agentAdapter = AgentAdapter()
//            tourismAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailTourismActivity::class.java)
//                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
//                startActivity(intent)
//            }



            homeViewModel.agent.observe(viewLifecycleOwner) { agent ->
                if (agent != null) {
                    when (agent) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            agentAdapter.setData(agent.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                agent.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvAgent) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = agentAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}