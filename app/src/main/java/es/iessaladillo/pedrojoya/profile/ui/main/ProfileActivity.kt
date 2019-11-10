package es.iessaladillo.pedrojoya.profile.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.profile.R
import es.iessaladillo.pedrojoya.profile.data.local.entity.Avatar
import es.iessaladillo.pedrojoya.profile.ui.avatar.AvatarActivity
import es.iessaladillo.pedrojoya.profile.utils.*
import kotlinx.android.synthetic.main.profile_activity.*


class ProfileActivity : AppCompatActivity() {

    private val profileActivityViewModel:ProfileActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        setUpViews()
    }

    override fun onStart() {
        super.onStart()
        remember()
    }

    private fun remember() {
        imgAvatar.setImageResource(ProfileActivityViewModel.avatar.drawable)
        lblAvatar.setText(ProfileActivityViewModel.avatar.name)
        txtName.setText(ProfileActivityViewModel.name)
        txtEmail.setText(ProfileActivityViewModel.email)
        txtAddress.setText(ProfileActivityViewModel.address)
        txtPhonenumber.setText(ProfileActivityViewModel.phoneNumber)
        txtWeb.setText(ProfileActivityViewModel.web)
    }

    private fun setUpViews() {
        imgEmail.setOnClickListener { startActivity(newEmailIntent(txtEmail.text.toString())) }
        imgAddress.setOnClickListener { startActivity(newSearchInMapIntent(txtAddress.text.toString())) }
        imgPhonenumber.setOnClickListener { startActivity(newDialIntent(txtPhonenumber.text.toString())) }
        imgWeb.setOnClickListener { startActivity(newWebSearchIntent(txtPhonenumber.text.toString())) }
        imgAvatar.setOnClickListener { startActivity(Intent(this,AvatarActivity::class.java)) }
        lblAvatar.setText(ProfileActivityViewModel.avatar.name)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.profile_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuSave) {
            if(!txtEmail.text.toString().isValidEmail()){
                txtEmail.setError("Not valid email")
            }
            if(!txtPhonenumber.text.toString().isValidPhone()){
                txtPhonenumber.setError("Not valid Phone")
            }
            if(!txtWeb.text.toString().isValidUrl()){
                txtWeb.setError("Not valid web")
            }
            if (txtEmail.text.toString().isValidEmail()&&txtPhonenumber.text.toString().isValidPhone()&&txtWeb.text.toString().isValidUrl()) {
                save()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun save() {
        ProfileActivityViewModel.saveData(txtName.text.toString(),txtEmail.text.toString(),txtPhonenumber.text.toString(),txtAddress.text.toString(),txtWeb.text.toString())
    }

}
