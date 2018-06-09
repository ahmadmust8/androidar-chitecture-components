package mustafa.ahmad.com.androidarchitecturecomponents.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import mustafa.ahmad.com.androidarchitecturecomponents.R
import android.widget.Toast
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Repositorys.ItemRepositoryImpl
import android.widget.EditText
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item


class activityAdd : AppCompatActivity() {

    private var title: EditText? = null
    private var body: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)


        title =  findViewById(R.id.title)
        body = findViewById(R.id.body)

        add_btn1.setOnClickListener { view ->
//            Log.e(FragmentActivity.TAG, "_onClickInvoked")
            if (title?.text.isNullOrEmpty()||body?.text.isNullOrEmpty()) return@setOnClickListener

            ItemRepositoryImpl.instance.addItem(Item(title?.text.toString() , body?.text.toString()))
            // show toast
            Toast.makeText(this@activityAdd, "Record Added", Toast.LENGTH_SHORT).show()
            // get back to main activity
            finish()
        }
    }

}
