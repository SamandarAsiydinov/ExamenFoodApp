package uz.context.examenappui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import uz.context.examenappui.R
import uz.context.examenappui.adapter.ViewPagerAdapter

class ViewPagerFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        val dots: DotsIndicator = view.findViewById(R.id.dots)
        val skipText: TextView = view.findViewById(R.id.text_skip)
        val nextText: TextView = view.findViewById(R.id.text_next)
        val finishText: TextView = view.findViewById(R.id.text_finish)

        skipText.setOnClickListener {
            findNavController().navigate(R.id.view_pager_to_home)
        }

        nextText.setOnClickListener {
            viewPager.currentItem++
            if (viewPager.currentItem == 3) {
                finishText.isVisible = true
                nextText.isVisible = false
            } else {
                finishText.isVisible = false
                nextText.isVisible = true
            }
        }
        finishText.setOnClickListener {
            findNavController().navigate(R.id.view_pager_to_home)
            onBoardingFinished()
        }

        viewPager = view.findViewById(R.id.view_page_2)
        val fragmentList = arrayListOf(
            FavoriteFragment(),
            CameraFragment(),
            ChatFragment(),
            NotificationFragment()
        )

        val adapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        viewPager.adapter = adapter
        dots.setViewPager2(viewPager)
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}