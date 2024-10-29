package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Ambil data nama makanan dari intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "No Food Selected"
        findViewById<TextView>(R.id.etFoodName).text = foodName

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol untuk konfirmasi order
        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            // Ambil data dari EditText
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val orderingName = findViewById<EditText>(R.id.etName).text.toString()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString()

            // Cek input user
            if (servings.isNotEmpty() && orderingName.isNotEmpty()) {
                // Intent untuk menuju ConfirmationActivity
                val intent = Intent(this, ConfirmationActivity::class.java)
                intent.putExtra("FOOD_NAME", foodName)
                intent.putExtra("SERVINGS", servings)
                intent.putExtra("ORDERING_NAME", orderingName)
                intent.putExtra("NOTES", notes)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
