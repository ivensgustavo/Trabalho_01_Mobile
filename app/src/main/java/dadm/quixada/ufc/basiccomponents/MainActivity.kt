package dadm.quixada.ufc.basiccomponents

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.annotation.MenuRes
import androidx.core.view.get


class MainActivity : AppCompatActivity() {

    lateinit var audio: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureToggleButton()
        configureAutoCompleteText()
        configureSpinner()
        configureRadioButtons()
        configureDropDownMenu()
        configurePopUpMenu()
        configureLongPress()
        configureBtnShowSreenWithBackgroundImage()
        configureBtnShowSreenWithTabs()
        configureBtnShowScreenWithGrid()
        configureBtnShowScreenWithListView()
        configureBtnsAudio()
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

    private fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun configureToggleButton() {
        val toggleButton: ToggleButton = findViewById(R.id.togglebutton)

        toggleButton.setOnClickListener {
            showToastMessage("Toggle button " + toggleButton.text)
        }
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

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, l: Long) {
                showToastMessage("Selecionou "+teams[position]+ " na spinner list")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun configureRadioButtons() {
        val radios: RadioGroup = findViewById(R.id.radioGroup)
        var radioSelected: RadioButton
        radios.setOnCheckedChangeListener { radioGroup, _ ->
            radioSelected = findViewById(radioGroup.checkedRadioButtonId)
            showToastMessage("Selecionou " + radioSelected.text.toString() + " no radio group")
        }
    }

    private fun configureDropDownMenu() {
        val autocompleteDropDownMenu: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView_dropdownMenu)
        val teams: Array<String> = resources.getStringArray(R.array.teams)
        val dropdownAdapter: ArrayAdapter<*> = ArrayAdapter(this, R.layout.dropdown_menu_item, teams)
        autocompleteDropDownMenu.setAdapter(dropdownAdapter)
        
        autocompleteDropDownMenu.setOnItemClickListener { _, _, pos, _ ->
            showToastMessage("Selecionou " + teams[pos] + " no dropdow menu")
        }
    }

    private fun configurePopUpMenu() {
        val showMenuButton: Button = findViewById(R.id.btn_showPopupMenu)
        showMenuButton.setOnClickListener { view: View ->
            showPopupMenu(view, R.menu.popup_menu)
        }
    }

    private fun showPopupMenu(view: View, @MenuRes menuLayout: Int) {
        val popupmenu = PopupMenu(this, view)
        popupmenu.menuInflater.inflate(menuLayout, popupmenu.menu)

        popupmenu.setOnMenuItemClickListener { menuItem ->
            showToastMessage("Você clicou em " + menuItem.title + "no popup menu")
            true
        }

        popupmenu.show()
    }

    private fun configureLongPress() {
        val longPressTextView: TextView = findViewById(R.id.longpressView)
        longPressTextView.setOnLongClickListener {
            showToastMessage("Text view foi pressionada longamente")
            true
        }
    }

    private fun configureBtnShowSreenWithBackgroundImage() {
        val btnShowScreeWithBackgroundImage: Button = findViewById(R.id.btn_showScreenWithBackgroundImage)
        btnShowScreeWithBackgroundImage.setOnClickListener {
            val screnWithBackgroundImage = Intent(this,  ScreenWithBackgroundImage::class.java)
            startActivity(screnWithBackgroundImage)
        }
    }

    private fun configureBtnShowSreenWithTabs() {
        val btnShowScreeWithTabs: Button = findViewById(R.id.btn_showScreenWithTabs)
        btnShowScreeWithTabs.setOnClickListener {
            val screnWithBackgroundImage = Intent(this,  ScreenWithTabs::class.java)
            startActivity(screnWithBackgroundImage)
        }
    }

    private fun configureBtnShowScreenWithGrid() {
        val btnShowScreenWithGrid: Button = findViewById(R.id.btn_showScreenWithGrid)
        btnShowScreenWithGrid.setOnClickListener {
            val screenWithGrid = Intent(this, ScreenWithGrid::class.java)
            startActivity(screenWithGrid)
        }
    }

    private fun configureBtnShowScreenWithListView() {
        val btnShowScreenWithListView: Button = findViewById(R.id.btn_showScreenListView)
        btnShowScreenWithListView.setOnClickListener {
            val screenWithListView = Intent(this, ScreenWithListView::class.java)
            startActivity(screenWithListView)
        }
    }

    private fun configureBtnsAudio() {
        audio = MediaPlayer.create(this, R.raw.coracao_cachorro)
        val btnPlayAudio: Button = findViewById(R.id.btn_playAudio)
        val btnPauseAudio: Button = findViewById(R.id.btn_pauseAudio)

        btnPlayAudio.setOnClickListener {
            audio.start()
        }

        btnPauseAudio.setOnClickListener {
            audio.pause()
        }
    }
}