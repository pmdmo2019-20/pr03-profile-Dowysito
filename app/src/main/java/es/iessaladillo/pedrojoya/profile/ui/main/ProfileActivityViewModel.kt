package es.iessaladillo.pedrojoya.profile.ui.main

import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.profile.data.local.Database
import es.iessaladillo.pedrojoya.profile.data.local.Database.queryDefaultAvatar
import es.iessaladillo.pedrojoya.profile.data.local.entity.Avatar

class ProfileActivityViewModel(): ViewModel() {

//    fun saveData(name:String,email:String,phoneNumber:String,address:String,web:String){
//        this.name=name
//        this.email=email
//        Companion.phoneNumber=phoneNumber
//        this.address=address
//        this.web=web
//    }

    companion object {

        var avatar: Avatar =  queryDefaultAvatar()
            private set
        var name:String=""
            private set
        var email:String=""
            private set
        var address:String=""
            private set
        var web:String=""
            private set
        var phoneNumber:String=""
            private set



        fun saveData(toString: String, toString1: String, toString2: String, toString3: String, toString4: String) {
            name=toString
            email=toString1
            phoneNumber =toString2
            address=toString3
            web=toString4
        }

        fun saveAvatar(id:Int) {
            avatar= Database.queryAllAvatars().get(id)
        }
    }
}