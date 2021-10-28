package dadm.quixada.ufc.basiccomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dadm.quixada.ufc.basiccomponents.R
import dadm.quixada.ufc.basiccomponents.model.Team

class TeamGridAdapter(var context: Context, var arrayList: ArrayList<Team>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return  ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder: ItemHolder = holder as ItemHolder
        val team:Team = arrayList.get(position)
        itemHolder.icon.setImageResource(team.teamIcon!!)
        itemHolder.name.text = team.teamName

        itemHolder.name.setOnClickListener {
            getToastMessage(team.teamName).show()
        }

        itemHolder.icon.setOnClickListener {
            getToastMessage(team.teamName).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    private fun getToastMessage(teamName: String?): Toast {
        return Toast.makeText(context, "Time clicado: " + teamName, Toast.LENGTH_SHORT)
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var icon: ImageView = itemView.findViewById(R.id.teamLogo)
        var name: TextView = itemView.findViewById(R.id.teamName)
    }

}