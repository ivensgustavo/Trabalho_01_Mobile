package dadm.quixada.ufc.basiccomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dadm.quixada.ufc.basiccomponents.adapters.ViewPageAdapter
import dadm.quixada.ufc.basiccomponents.fragments.FavoriteFragment
import dadm.quixada.ufc.basiccomponents.fragments.HomeFragment
import dadm.quixada.ufc.basiccomponents.fragments.LaundryFragment

class ScreenWithTabs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_with_tabs)

        configureTabs()
    }

    private fun configureTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(FavoriteFragment(), "Favoritos")
        adapter.addFragment(LaundryFragment(), "Laundry")

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_local_laundry_service)
    }
}