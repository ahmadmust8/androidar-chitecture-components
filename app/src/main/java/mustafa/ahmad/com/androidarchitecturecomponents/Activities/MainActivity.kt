package mustafa.ahmad.com.androidarchitecturecomponents.Activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import mustafa.ahmad.com.androidarchitecturecomponents.R
import android.support.v7.widget.RecyclerView
import mustafa.ahmad.com.androidarchitecturecomponents.ViewModel.MainActivityViewModel
import mustafa.ahmad.com.androidarchitecturecomponents.Activities.Adapters.RecyclerViewAdapter
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Repositorys.ItemRepositoryImpl
import mustafa.ahmad.com.androidarchitecturecomponents.R.id.add_btn
import mustafa.ahmad.com.androidarchitecturecomponents.R.id.toolbar
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var list: List<Item>
    private lateinit var mViewModel: MainActivityViewModel
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        recyclerView = findViewById(R.id.recyclerview)

        list = ArrayList()
        adapter =  RecyclerViewAdapter(list)


        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mViewModel.getListItems().observe(this , Observer {
            // update DataSet
//            Log.e(TAG,"_AdapterIsUpdatedFromViewModel");
            (list as ArrayList<Item>).clear()
            (list as ArrayList<Item>).addAll(mViewModel.getListItems().value as ArrayList<Item>)
            adapter?.notifyDataSetChanged()
        })

        add_btn.setOnClickListener {
            val intent = Intent(this, activityAdd::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.delet_all ->{
                doAsync {
                    if (list[0] == null) return@doAsync

                    for (i in 0 until list.size) {
                        ItemRepositoryImpl.instance.deleteItem(list[i])
                    }
                    Toast.makeText(this@MainActivity, "All Records Are Deleted!", Toast.LENGTH_SHORT).show()
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
