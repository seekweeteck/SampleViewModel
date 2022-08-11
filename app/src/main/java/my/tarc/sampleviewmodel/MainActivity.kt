package my.tarc.sampleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import my.tarc.sampleviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //TODO : 3 Create instance of ViewModel
    private val viewModel: CounterViewModel by viewModels()
    private var counter2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewCounter2.text = counter2.toString()

        viewModel._counter.observe(this, Observer {
            binding.textViewCounter.text = viewModel._counter.value.toString()
        })

        binding.buttonIncrease.setOnClickListener {
            viewModel.increaseCounter()

            counter2 += 1
            binding.textViewCounter2.text = counter2.toString()
        }

        binding.buttonDecrease.setOnClickListener {
            viewModel.decreaseCounter()

            counter2 -= 1
            binding.textViewCounter2.text = counter2.toString()
        }
    }
}