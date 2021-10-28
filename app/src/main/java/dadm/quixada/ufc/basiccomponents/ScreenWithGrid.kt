package dadm.quixada.ufc.basiccomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dadm.quixada.ufc.basiccomponents.adapters.TeamGridAdapter
import dadm.quixada.ufc.basiccomponents.model.Team

class ScreenWithGrid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_with_grid)

        val recyclerView: RecyclerView = findViewById(R.id.recylerView)
        val gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)

        val teamList:ArrayList<Team> = setTeamList()
        val teamAdapter = TeamGridAdapter(applicationContext, teamList)
        recyclerView.adapter = teamAdapter

    }

    private fun setTeamList(): ArrayList<Team>{
        val teams: ArrayList<Team> = ArrayList()

        teams.add(Team(R.drawable.logo_flamengo, "Flamengo"))
        teams.add(Team(R.drawable.logo_atletico_mineiro, "Atlético Mineiro"))
        teams.add(Team(R.drawable.logo_palmeiras, "Palmeiras"))
        teams.add(Team(R.drawable.logo_sao_paulo, "São Paulo"))
        teams.add(Team(R.drawable.logo_fortaleza, "Fortaleza"))
        teams.add(Team(R.drawable.logo_ceara, "Ceará"))
        teams.add(Team(R.drawable.logo_fluminense, "Fluminense"))
        teams.add(Team(R.drawable.logo_santos, "Santos"))
        teams.add(Team(R.drawable.logo_sport, "Sport"))

        return teams
    }
}