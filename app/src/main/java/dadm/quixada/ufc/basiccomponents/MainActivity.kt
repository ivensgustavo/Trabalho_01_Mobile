package dadm.quixada.ufc.basiccomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.annotation.MenuRes


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>
        val items: Array<String> = arrayOf(
            "ToggleButton",
            "EditText",
            "AutoComplete",
            "Spinner",
            "RadioButton",
            "OptionMenu",
            "DropDownMenu",
            "CliqueLongo",
            "ImagemDeFundo",
            "Navegação",
            "ActivitiesMultiplasTabs"
        )

        var listView: ListView = findViewById(R.id.listview)
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, items)

        listView.adapter = arrayAdapter
        
        listView.setOnItemClickListener { adapterView, view, i, l ->
            when(i) {
                0 -> Toast.makeText(this, "Ciclou na opção 1", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Ciclou na opção X", Toast.LENGTH_SHORT).show()
            }
        }

        configureAutoCompleteText()
        configureSpinner()
        configureDropDownMenu()
        configurePopUpMenu()
        configureLongPress()
        configureBtnShowSreenWithBackgroundImage()
        configureBtnShowSreenWithTabs()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.options_menu_camera -> Toast.makeText(this, "Você selecionou Câmera", Toast.LENGTH_SHORT).show()
            R.id.options_menu_settings -> Toast.makeText(this, "Você selecionou Configurações", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Você selecionou Ajuda", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun configureAutoCompleteText() {
        val autoCompleteText: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val teams: Array<String> = resources.getStringArray(R.array.teams)
        val autoCompleteAdapter: ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_list_item_1, teams)
        autoCompleteText.setAdapter(autoCompleteAdapter)
    }

    private fun configureSpinner() {
        val spinner: Spinner = findViewById(R.id.spinner)
        val teams: Array<String> = resources.getStringArray(R.array.teams)
        val spinnerAdapter: ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, teams)
        spinner.adapter = spinnerAdapter
    }

    private fun configureDropDownMenu() {
        val autocompleteDropDownMenu: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView_dropdownMenu)
        val teams: Array<String> = resources.getStringArray(R.array.teams)
        val dropdownAdapter: ArrayAdapter<*> = ArrayAdapter(this, R.layout.dropdown_menu_item, teams)
        autocompleteDropDownMenu.setAdapter(dropdownAdapter)
    }

    private fun configurePopUpMenu() {
        val showMenuButton: Button = findViewById(R.id.btn_showPopupMenu)
        showMenuButton.setOnClickListener { view: View ->
            showPopupMenu(view, R.menu.popup_menu)
        }
    }

    private fun showPopupMenu(view: View, @MenuRes menuLayout: Int) {
        val popupmenu: PopupMenu = PopupMenu(this, view)
        popupmenu.menuInflater.inflate(menuLayout, popupmenu.menu)

        popupmenu.setOnMenuItemClickListener { menuItem ->
            Toast.makeText(this, "Você clicou em " + menuItem.title, Toast.LENGTH_SHORT).show()
            true
        }

        popupmenu.show()
    }

    private fun configureLongPress() {
        val longPressTextView: TextView = findViewById(R.id.longpressView)
        longPressTextView.setOnLongClickListener {
            Toast.makeText(this, "TextView foi pressionado longamente", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun configureBtnShowSreenWithBackgroundImage() {
        val btnShowScreeWithBackgroundImage: Button = findViewById(R.id.btn_showScreenWithBackgroundImage)
        btnShowScreeWithBackgroundImage.setOnClickListener { view: View ->
            val screnWithBackgroundImage = Intent(this,  ScreenWithBackgroundImage::class.java)
            startActivity(screnWithBackgroundImage)
        }
    }

    private fun configureBtnShowSreenWithTabs() {
        val btnShowScreeWithTabs: Button = findViewById(R.id.btn_showScreenWithTabs)
        btnShowScreeWithTabs.setOnClickListener { view: View ->
            val screnWithBackgroundImage = Intent(this,  ScreenWithTabs::class.java)
            startActivity(screnWithBackgroundImage)
        }
    }
}