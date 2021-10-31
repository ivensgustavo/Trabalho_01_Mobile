package dadm.quixada.ufc.basiccomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ScreenWithListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_with_list_view)

        val arrayAdapter: ArrayAdapter<*>
        val items: Array<String> = resources.getStringArray(R.array.teams)

        val listView: ListView = findViewById(R.id.listview)
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, items)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            when(i) {
                0 -> Toast.makeText(this, "Ciclou no item Flamengo", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this, "Ciclou no item Palmeiras", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Ciclou no item Corinthians", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "Ciclou no item Santos", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "Ciclou no item Fluminense", Toast.LENGTH_SHORT).show()

                else -> Toast.makeText(this, "Ciclou na opção X", Toast.LENGTH_SHORT).show()
            }
        }
    }
}