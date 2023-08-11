package com.camp.campingapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.camp.campingapp.databinding.ActivityMainBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import org.checkerframework.checker.units.qual.A


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val view = binding.root
        setContentView(view)

        val slidePanel = binding.mainFrame                      // SlidingUpPanel
        slidePanel.addPanelSlideListener(PanelEventListener())  // 이벤트 리스너 추가

        // 패널 열고 닫기
        binding.btnToggle.setOnClickListener {
            val state = slidePanel.panelState
            // 닫힌 상태일 경우 열기
            if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                slidePanel.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            }
            // 열린 상태일 경우 닫기
            else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
                slidePanel.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
            }
        }

        // 캠핑장
        binding.btnmenu1.setOnClickListener {
            val intent = Intent(this@MainActivity, CampDoNmActivity::class.java)
            startActivity(intent)
        }
        // 예약
        binding.btnmenu2.setOnClickListener {
            val intent = Intent(this@MainActivity, HostListActivity::class.java)
            startActivity(intent)
        }
        // 축제
        binding.btnmenu3.setOnClickListener {
            val intent = Intent(this@MainActivity, Board::class.java)
            startActivity(intent)
        }
        // 커뮤니티
        binding.btnmenu4.setOnClickListener {
            val intent = Intent(this@MainActivity, TourActivity::class.java)
            startActivity(intent)
        }

    }

    inner class PanelEventListener : SlidingUpPanelLayout.PanelSlideListener {
        // 패널이 슬라이드 중일 때
        override fun onPanelSlide(panel: View?, slideOffset: Float) {
//            binding.tvSlideOffset.text = slideOffset.toString()
        }

        // 패널의 상태가 변했을 때
        override fun onPanelStateChanged(
            panel: View?,
            previousState: SlidingUpPanelLayout.PanelState?,
            newState: SlidingUpPanelLayout.PanelState?
        ) {
            if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
//                binding.btnToggle.text = "열기"
            } else if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
//                binding.btnToggle.text = "닫기"
            }
        }
    }
}
