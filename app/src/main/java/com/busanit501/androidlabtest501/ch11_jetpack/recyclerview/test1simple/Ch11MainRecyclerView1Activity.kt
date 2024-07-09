package com.busanit501.androidlabtest501.ch11_jetpack.recyclerview.test1simple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch3_4_5.data
import com.busanit501.androidlabtest501.databinding.ActivityCh11MainRecyclerView1Binding

// 순서1, 리사이클러뷰 출력할 빈 도화지 역할.
class Ch11MainRecyclerView1Activity : AppCompatActivity() {
    lateinit var binding: ActivityCh11MainRecyclerView1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh11MainRecyclerView1Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch11_main_recycler_view1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //샘플 더미 데이터 넣기.
        val datas = mutableListOf<String>()
        for(i in 1..10) {
            datas.add("오늘 점심 뭐먹지 ? $i")
        }

        //리사이클러뷰 , 어떤 모양으로 배치할지 정하기.
        // 세로 방향, 가로 방향, 지그재그, 그리드 등.
        val layoutManager = LinearLayoutManager(this@Ch11MainRecyclerView1Activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.ch11RecyclerSample1.layoutManager = layoutManager

        // 어댑터 붙이기.
        binding.ch11RecyclerSample1.adapter = Ch11MyAdapterSample(datas)



    } //onCreate
}