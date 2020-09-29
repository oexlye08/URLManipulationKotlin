package id.my.okisulton.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.my.okisulton.myapplication.model.Post
import id.my.okisulton.myapplication.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.http.POST

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        /** GET POST*/
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer { response->
//            if (response.isSuccessful){
//                Log.d("Response", response.body()?.UserId.toString())
//                Log.d("Response", response.body()?.id.toString())
//                Log.d("Response", response.body()?.title!!)
//                Log.d("Response", response.body()?.body!!)
//                textView.text = response.body()?.title!!
//            }else{
//                Log.d("Response", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        /** PUSH POST*/
//        val myPost = Post(1,1,"Oki", "Android developer")
//        viewModel.pushPost(myPost)
//        viewModel.myResponse.observe(this, Observer { response->
//            if (response.isSuccessful){
//                Log.d("Response", response.body()?.toString())
//                Log.d("Response", response.code()?.toString())
//                Log.d("Response", response.message())
//
//
//            }else{
//                Log.d("Response", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        /** PUSH POST2*/
//        viewModel.pushPost2(2,2,"oki", "Android Developer")
////        viewModel.myResponse.observe(this, Observer { response->
////            if (response.isSuccessful){
////                Log.d("Response", response.body()?.toString())
////                Log.d("Response", response.code()?.toString())
////                Log.d("Response", response.message().toString())
////
////
////            }else{
////                Log.d("Response", response.code().toString())
////                textView.text = response.code().toString()
////            }
////        })

        /** GET POST HEADER*/
//        viewModel.getPostHeader()
//        viewModel.myResponse.observe(this, Observer { response->
//            if (response.isSuccessful){
//                Log.d("Response", response.body()?.toString())
//                Log.d("Response", response.code()?.toString())
//                Log.d("Response", response.headers().toString())
//
//
//            }else{
//                Log.d("Response", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        /** GET POST HEADER2*/
        viewModel.getPostHeader2("111222")
        viewModel.myResponse.observe(this, Observer { response->
            if (response.isSuccessful){
                Log.d("Response", response.body()?.toString())
                Log.d("Response", response.code()?.toString())
                Log.d("Response", response.headers().toString())


            }else{
                Log.d("Response", response.code().toString())
                textView.text = response.code().toString()
            }
        })

        button.setOnClickListener{
//            getPost() // ..../posts/2
//            getCustomePosts() // ...../posts?=userId=3
//            getCustomeMapPosts() // ...../posts?=userId=3&_sort=id&_order=desc
//            getCustomeMapPosts2() // ...../posts?=userId=3&_sort=id&_order=desc
        }

        button2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getCustomeMapPosts2() {
        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"
        val myNumber = editTextNumber.text.toString()
        viewModel.getCustomMapPost2(Integer.parseInt(myNumber), options)
        viewModel.myCustomMapPost2.observe(this, Observer { response->
            if (response.isSuccessful){


                textView.text = response.body()?.toString()
                response.body()?.forEach{
                    Log.d("Response", it.userId.toString())
                    Log.d("Response", it.id.toString())
                    Log.d("Response", it.title)
                    Log.d("Response", it.body)
                    Log.d("Response", "-----------------------------------------------------")
                }


            }else{
                Log.d("Response", response.code().toString())
                textView.text = response.code().toString()
            }
        })
    }

    private fun getCustomeMapPosts() {
        val myNumber = editTextNumber.text.toString()
        viewModel.getCustomMapPost(Integer.parseInt(myNumber), "id", "desc")
        viewModel.myCustomMapPost.observe(this, Observer { response->
            if (response.isSuccessful){


                textView.text = response.body()?.toString()
                response.body()?.forEach{
                    Log.d("Response", it.userId.toString())
                    Log.d("Response", it.id.toString())
                    Log.d("Response", it.title)
                    Log.d("Response", it.body)
                    Log.d("Response", "-----------------------------------------------------")
                }


            }else{
                Log.d("Response", response.code().toString())
                textView.text = response.code().toString()
            }
        })
    }

    private fun getCustomePosts() {
        val myNumber = editTextNumber.text.toString()
        viewModel.getCustomPost(Integer.parseInt(myNumber))
        viewModel.myCustomPost.observe(this, Observer { response->
            if (response.isSuccessful){


                textView.text = response.body()?.toString()
                response.body()?.forEach{
                    Log.d("Response", it.userId.toString())
                    Log.d("Response", it.id.toString())
                    Log.d("Response", it.title)
                    Log.d("Response", it.body)
                    Log.d("Response", "-----------------------------------------------------")
                }


            }else{
                Log.d("Response", response.code().toString())
                textView.text = response.code().toString()
            }
        })
    }

    private fun getPost() {
        val myNumber = editTextNumber.text.toString()
        viewModel.getPost2(Integer.parseInt(myNumber))
        viewModel.myResponse2.observe(this, Observer { response->
            if (response.isSuccessful){

                Log.d("Response", response.body().toString())
                textView.text = response.body()?.toString()
            }else{
                Log.d("Response", response.code().toString())
                textView.text = response.code().toString()
            }
        })
    }
}