package mx.edu.itm.link.basicroomapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.edu.itm.link.basicroomapp.database.DatabaseManager
import mx.edu.itm.link.basicroomapp.database.MyCoroutines
import mx.edu.itm.link.basicroomapp.database.User

class MainViewModel: ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch {
            val userDAO = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDAO).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            val userDAO = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDAO).delete(user)
        }
    }

    val savedUsers = MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch {
            val userDAO = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDAO).getUsers().value
        }
    }
}