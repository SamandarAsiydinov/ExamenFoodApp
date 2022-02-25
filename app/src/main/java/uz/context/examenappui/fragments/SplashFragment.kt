package uz.context.examenappui.fragments

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.context.examenappui.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val time = object : CountDownTimer(2000,3000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (onBoardingFinished()) {
                    findNavController().navigate(R.id.splash_to_home)
                } else {
                    findNavController().navigate(R.id.splash_to_view_pager)
                }
            }
        }
        time.start()

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        return sharedPref.getBoolean("Finished", false)
    }
}