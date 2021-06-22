package be.bxl.formation.encodage_evenement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: EventAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter
        eventAdapter = EventAdapter(mutableListOf())
        rvEventItems.adapter = EventAdapter
        tvEventItems.layoutManager = LinearLayoutManager(this)

        rvEventItems.adapter = todoAdapter
        rvTEventItems.layoutManager = LinearLayoutManager(this)

        btnAddEvent.setOnClickListener{
            var eventTitle = etEventTitle.text.toString()

            if(EventTitle.isNotEmpty()) {
                val event = Event(eventTitle)
                eventAdapter.addEvent
                etEventTitle.text.clear()
            }
        }
        btnDeleteEvents.setOnclickListener{
            todoAdapter.deleteEvents()
        }

    }
}