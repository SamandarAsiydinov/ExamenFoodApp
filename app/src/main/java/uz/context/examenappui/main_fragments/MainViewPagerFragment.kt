package uz.context.examenappui.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.context.examenappui.R
import uz.context.examenappui.adapter.ViewPagerAdapter
import uz.context.examenappui.adapter.ViewPagerMainAdapter

class MainViewPagerFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var viewPagerAdapter: ViewPagerMainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_view_pager, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.view_page_2_main)
        bottomNav = view.findViewById(R.id.bottom_nav)

        viewPagerAdapter =
            ViewPagerMainAdapter(initFragments(), requireActivity().supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> viewPager.currentItem = 0
                R.id.collectionFragment -> viewPager.currentItem = 1
                R.id.messageFragment -> viewPager.currentItem = 2
                R.id.searchFragment -> viewPager.currentItem = 3
            }
            true
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            HomeFragment(),
            CollectionsFragment(),
            MessageFragment(),
            SearchFragment()
        )
    }
}