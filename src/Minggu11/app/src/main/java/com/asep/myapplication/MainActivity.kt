import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asep.myapplication.User
import com.asep.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var user: User
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = User("John Doe", 30)

        binding.user = user
    }
}