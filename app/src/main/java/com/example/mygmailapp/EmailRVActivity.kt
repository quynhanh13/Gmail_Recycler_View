package com.example.mygmailapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygmailapp.RVEmailItemAdapter
import com.example.mygmailapp.EmailModel
import com.example.mygmailapp.R

class EmailRVActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_recycler_view)

        val items = arrayListOf<EmailModel>(
            EmailModel("Sender1", "Hello World","This is the email with recycler view"),
            EmailModel("Sender2", "Hello World","This is the email with recycler view"),
            EmailModel("Sender3", "Hello World","This is the email with recycler view"),
            EmailModel("Sender4", "Hello World","This is the email with recycler view"),
            EmailModel("Sender5", "Hello World","This is the email with recycler view"),
            EmailModel("Sender6", "Hello World","This is the email with recycler view"),
            EmailModel("Sender7", "Hello World","This is the email with recycler view"),
            EmailModel("Sender8", "Hello World","This is the email with recycler view"),
            EmailModel("Sender9", "Hello World","This is the email with recycler view"),
            EmailModel("Sender10", "Hello World","This is the email with recycler view"),
        )

        val adapter = RVEmailItemAdapter(items)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.button_add).setOnClickListener {
            items.add(0, EmailModel("AddEmail", "New email", "Check add new Email"))
            adapter.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }

        findViewById<Button>(R.id.button_remove).setOnClickListener {
            items.removeAt(0)
            adapter.notifyItemRemoved(0)
        }

    }
}