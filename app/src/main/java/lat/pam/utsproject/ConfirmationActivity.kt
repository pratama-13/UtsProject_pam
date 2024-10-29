package lat.pam.utsproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "N/A"
        val servings = intent.getStringExtra("SERVINGS") ?: "N/A"
        val orderName = intent.getStringExtra("ORDER_NAME") ?: "N/A"
        val notes = intent.getStringExtra("NOTES") ?: "N/A"

        // Set data ke TextView
        findViewById<TextView>(R.id.foodNameConfirmation).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.servingsConfirmation).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.orderingNameConfirmation).text = "Ordering Name: $orderName"
        findViewById<TextView>(R.id.notesConfirmation).text = "Additional Notes: $notes"

        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
