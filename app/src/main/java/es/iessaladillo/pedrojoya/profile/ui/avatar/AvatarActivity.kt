package es.iessaladillo.pedrojoya.profile.ui.avatar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.R
import es.iessaladillo.pedrojoya.profile.data.local.Database
import es.iessaladillo.pedrojoya.profile.data.local.entity.Avatar
import es.iessaladillo.pedrojoya.profile.ui.main.ProfileActivityViewModel
import kotlinx.android.synthetic.main.avatar_activity.*

class AvatarActivity : AppCompatActivity() {


    private var id:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avatar_activity)
        setUpViews()
    }

    private fun setUpViews() {
        checkBoxBulbasaur.setOnCheckedChangeListener { _, b ->
            if (b) {
                checkBoxChikorita.isChecked = false
                checkBoxCubone.isChecked = false
                checkBoxFeebas.isChecked = false
                checkBoxGiratina.isChecked = false
                checkBoxGyarados.isChecked = false
                checkBoxPikachu.isChecked = false
                checkBoxPachirisu.isChecked = false
                checkBoxJiggly.isChecked = false
                id=1
            }
        }
        checkBoxChikorita.setOnCheckedChangeListener { _, b ->
            if (b) {
                checkBoxBulbasaur.isChecked = false
                checkBoxCubone.isChecked = false
                checkBoxFeebas.isChecked = false
                checkBoxGiratina.isChecked = false
                checkBoxGyarados.isChecked = false
                checkBoxPikachu.isChecked = false
                checkBoxPachirisu.isChecked = false
                checkBoxJiggly.isChecked = false
                id=2
            }
        }
        checkBoxCubone.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxJiggly.isChecked = false
            id=3
            }
        }
        checkBoxFeebas.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxJiggly.isChecked = false
            id=4
            }
        }
        checkBoxGiratina.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxJiggly.isChecked = false
            id=5
            }
        }
        checkBoxGyarados.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxJiggly.isChecked = false
            id=6
            }
        }
        checkBoxPikachu.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxJiggly.isChecked = false
            id=0
            }
        }
        checkBoxJiggly.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxPachirisu.isChecked = false
            checkBoxBulbasaur.isChecked = false
            id=7
            }
        }
        checkBoxPachirisu.setOnCheckedChangeListener { _, b -> if (b) {
            checkBoxChikorita.isChecked = false
            checkBoxCubone.isChecked = false
            checkBoxFeebas.isChecked = false
            checkBoxGiratina.isChecked = false
            checkBoxGyarados.isChecked = false
            checkBoxPikachu.isChecked = false
            checkBoxBulbasaur.isChecked = false
            checkBoxJiggly.isChecked = false
            id=8
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.avatar_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuSelect) {
            if(id!=-1) {
                ProfileActivityViewModel.saveAvatar(id)
                onBackPressed()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        const val EXTRA_AVATAR = "EXTRA_AVATAR"

    }

}


