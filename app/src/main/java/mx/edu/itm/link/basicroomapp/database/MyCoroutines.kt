package mx.edu.itm.link.basicroomapp.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val userDAO: UserDAO) {
    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDAO.save(user.toEntity())
    }

    suspend fun delete(user: User) = withContext(Dispatchers.IO){
        userDAO.delete(user.toEntity())
    }

    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDAO.getUsersFromDatabase().map { eachUserEntity ->
            eachUserEntity.toUser() })
    }
}