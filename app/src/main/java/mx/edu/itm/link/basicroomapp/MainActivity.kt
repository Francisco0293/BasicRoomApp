package mx.edu.itm.link.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import mx.edu.itm.link.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel.saveUser(User(
//            "Userid0001",
//            "name0001",
//            1.71,
//            71.1,
//            "user001@email.com",
//            "passworduser0001"
//        ))

        mainViewModel.getUsers()
        //si es fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this, {usersList ->
            if (!usersList.isNullOrEmpty()){
                for (user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        })
    }
}