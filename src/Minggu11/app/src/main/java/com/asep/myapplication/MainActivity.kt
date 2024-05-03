import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asep.myapplication.MainViewModel
import com.asep.myapplication.User
import com.asep.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var user: User
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = User("John Doe", 30)

        binding.user = user

        binding.textViewData.text = viewModel.getData()

        // Menambahkan listener untuk buttonUpdate
        binding.buttonUpdate.setOnClickListener {
            viewModel.updateData("New Data")
            binding.textViewData.text = viewModel.getData()
        }
    }
}