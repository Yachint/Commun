package com.yachint.commun.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.balloon.*
import com.yachint.commun.R
import com.yachint.commun.data.model.FilterOption
import com.yachint.commun.databinding.FragmentExploreBinding
import com.yachint.commun.ui.adapters.FilterSearchAdapter
import com.yachint.commun.ui.adapters.RecommendListAdapter
import com.yachint.commun.ui.adapters.SuggestPagerAdapter
import com.yachint.commun.ui.injector.DaggerVMFSearchComponent
import com.yachint.commun.ui.viewmodel.SearchViewModel
import com.yachint.commun.utils.SlidePageTransformer
import com.yachint.commun.utils.VerticalItemDecorator
import com.yachint.commun.utils.ViewPagerEventHandler

class ExploreFragment : Fragment(), OnBalloonClickListener {

    lateinit var binding: FragmentExploreBinding
    lateinit var suggestAdapter: SuggestPagerAdapter
    lateinit var tooltipBalloon: Balloon
    lateinit var filterLayoutManager: LinearLayoutManager
    lateinit var filterAdapter: FilterSearchAdapter
    lateinit var filterOptions: ArrayList<FilterOption>
    lateinit var searchAdapter: RecommendListAdapter
    lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_explore, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val component = DaggerVMFSearchComponent.create()
        val factory = component.getViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)
        setUpObservers()

    }

    fun triggerDataLoad(){
        viewModel.apply {
            getSearchList()
            getSuggestList()
        }
    }

    private fun setUpObservers(){
        viewModel.isLoaded.observe(viewLifecycleOwner, Observer { isLoaded ->
            if(isLoaded){
                initializeUI()
            }
        })
    }

    private fun toggleVisibility(){
        binding.searchShimmer.visibility = View.GONE
        binding.searchContent.visibility = View.VISIBLE
    }

    private fun initializeUI(){
        initializeSuggestPager()
        initializeFilterList()
        initializeSearchList()
        toggleVisibility()
    }

    private fun initializeSearchList(){
        searchAdapter = RecommendListAdapter(requireContext())
        binding.rvSearchList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
        binding.cardSearchList.visibility = View.VISIBLE
    }

    private fun initializeSuggestPager(){
        val verticalOffset = requireContext().resources.getDimension(R.dimen.viewpager_current_item_vertical_margin).toInt()
//        binding.pagerControl.apply {
//            count = 5
//            selection = 1
//        }
        val pagerHandler = ViewPagerEventHandler(binding.suggestViewPager, ::toggleBalloon)

        suggestAdapter = SuggestPagerAdapter(requireContext())
        binding.suggestViewPager.apply {
            adapter = suggestAdapter
            offscreenPageLimit = 3
            setPageTransformer(SlidePageTransformer(3, verticalOffset))
            addItemDecoration(VerticalItemDecorator(verticalOffset, pagerHandler))
        }

        binding.pagerControl.setViewPager2(binding.suggestViewPager)
        binding.frameSuggest.visibility = View.VISIBLE
        binding.pagerControl.visibility = View.VISIBLE
        showBalloon()
    }

    private fun initializeFilterList(){

        filterOptions = arrayListOf(
            FilterOption("All", isSelected = true),
            FilterOption("Communities"),
            FilterOption("Users"),
            FilterOption("Posts")
        )
        filterLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        filterAdapter = FilterSearchAdapter(requireContext(), filterOptions, this)

        binding.rvFilter.apply {
            layoutManager = filterLayoutManager
            adapter = filterAdapter

        }

        binding.rvFilter.visibility = View.VISIBLE
    }

    fun handleFilterClick(position: Int){
        for(i in 0 until filterOptions.size){
            filterOptions[i].isSelected = i == position
        }

        filterAdapter.notifyDataSetChanged()
//        filterAdapter = FilterSearchAdapter(requireContext(), filterOptions, this)
//        binding.rvFilter.adapter = filterAdapter
    }

    fun toggleBalloon(){
        binding.swipeUpAnim.visibility = View.GONE
        tooltipBalloon.dismiss()
    }

    fun showBalloon(){
        tooltipBalloon = createBalloon(requireContext()) {
            setArrowSize(10)
            setHeight(65)
            setArrowPosition(0.8f)
            setArrowOrientationRules(ArrowOrientationRules.ALIGN_ANCHOR)
            paddingLeft = 20
            paddingRight = 20
            setCornerRadius(8f)
            setAlpha(0.9f)
            setText("Swipe up for more suggestions!")
            setTextColorResource(R.color.colorWhite)
//            setIconDrawable(ContextCompat.getDrawable(baseContext, R.drawable.ic_profile))
            setBackgroundColorResource(R.color.colorPrimary)
            setOnBalloonClickListener(this@ExploreFragment)
            setBalloonAnimation(BalloonAnimation.FADE)
            setLifecycleOwner(lifecycleOwner)
        }

        tooltipBalloon.showAlignBottom(binding.suggestViewPager, 370, 0)
    }

    override fun onBalloonClick(view: View) {
        toggleBalloon()
    }

}