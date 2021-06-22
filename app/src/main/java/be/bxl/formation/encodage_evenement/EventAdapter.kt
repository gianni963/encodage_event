package be.bxl.formation.encodage_evenement

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(private val events: MutableList<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>(){

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_event,
                parent,
                false
            )
        )
    }
    fun addEvent(event :  Event){
        events.add(event)
        notifyItemInserted(events.size -1 )
    }

    fun deleteEvents(){
        events.removeAll {event ->
            event.isChecked
        }

        NotifyDataSetChanged()
    }


    private fun toggleStrike(TvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked){
            tvEventTitle.paintFlags = tvEventTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvEventTitle.paintFlags = tvEventTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val curTodo = events[position]
        holder.itemView.apply {
            val tvEventTitle
            tvEventTitle.text = curEvent.title
            cbDone.isChecked =  curEvent.isChecked
            toggleStrike(tvEventTitle, curEvent.isChecked)
            cbDone.setOnCheckedChangeListener{_, isChecked ->
                toggleStrike(tvEventTitle,isChecked)
                curEvent.isChecked =  !curEvent.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }
}

private fun <E> MutableList<E>.removeAll(predicate: (E) -> Unit) {

}
