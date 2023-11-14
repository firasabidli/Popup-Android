package com.example.popup


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.menu_context)
        // Remplacez R.id.textView par l'ID de votre TextView
        registerForContextMenu(textView)

        textView.setOnClickListener {
            // Afficher le menu contextuel lorsque le TextView est cliqué
            openContextMenu(textView)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true;
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val textView = findViewById<TextView>(R.id.menu_context)
        return when (item.itemId) {
            R.id.blue -> {
                textView.setBackgroundColor(Color.BLUE);
                return true
            }
            R.id.red -> {
                textView.setBackgroundColor(Color.RED);
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }

}

