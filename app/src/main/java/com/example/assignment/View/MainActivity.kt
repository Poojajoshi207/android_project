package com.example.assignment.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.Adapter.RestaurantLoadStateAdapter
import com.example.assignment.Adapter.RestaurantPagAdapter
import com.example.assignment.R
import com.example.assignment.ViewModel.MainViewModelFactory
import com.example.assignment.ViewModel.RestaurantViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    private var restaurantViewModel: RestaurantViewModel?=null
    private var rvRestaurant: RecyclerView? = null
    private var seekBar:SeekBar?=null
    private var textView:TextView?=null
    private var progressBar:ProgressBar?=null
    private var radius:String="500"
    val adapter = RestaurantPagAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
       initViewModel("500")



    }
    private fun initialization() {
        rvRestaurant = findViewById(R.id.rvRestaurant)
        seekBar = findViewById(R.id.seekbar_radius)
        //textview
        textView = findViewById(R.id.textview)


        rvRestaurant!!.layoutManager = LinearLayoutManager(this)
       val factory = MainViewModelFactory(this)
      //  restaurantViewModel= ViewModelProviders.of(this,factory).get(RestaurantViewModel::class.java)

       rvRestaurant!!.adapter=adapter.withLoadStateHeaderAndFooter(
           header = RestaurantLoadStateAdapter { adapter.retry() },
           footer = RestaurantLoadStateAdapter { adapter.retry() }
       )

      /*  lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadStates ->
               // progressBar?.isVisible = loadStates.refresh is LoadState.Loading
                rvUser?.isVisible=loadStates.refresh is LoadState.Loading

            }
        }
*/

       adapter.addLoadStateListener {loadStates ->
            progressBar?.isVisible = loadStates.refresh is LoadState.Loading
            rvRestaurant?.isVisible=loadStates.refresh is LoadState.NotLoading

            if (rvRestaurant?.isVisible==true){
                progressBar?.isVisible=false
            }
        }

        seekBar?.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1>999){
                    var radius1:Int=p1/1000
                    textView?.text=radius1.toString()+"KM"
                }else{
                    textView?.text=p1.toString()+"M"
                }
               radius=p1.toString()
                initViewModel(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

                initViewModel(radius)
            }

        })

    }


    private fun initViewModel(radius:String) {
        val viewModel  = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewModel.getUserResponseLiveData(radius).collectLatest {
               adapter.submitData(it)
            }
        }
    }

}