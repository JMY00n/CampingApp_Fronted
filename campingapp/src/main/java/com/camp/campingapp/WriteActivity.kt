package com.camp.campingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.camp.campingapp.databinding.ActivityWriteBinding
import com.camp.campingapp.util.dateToString
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import java.io.File
import java.util.Date


class WriteActivity : AppCompatActivity() {
    val db = Firebase.firestore

    lateinit var binding: ActivityWriteBinding
    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postbtn.setOnClickListener {
            val data = mapOf(
                "title" to binding.title.text.toString(),
                "content" to binding.addEditView.text.toString(),
                "date" to dateToString(Date())
            )
            db.collection("Boards")
                .add(data)
                .addOnSuccessListener {
                    Toast.makeText(this, "게시글 작성 완료", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "error!!", Toast.LENGTH_SHORT).show()
                }
        }

    }

//    val requestLauncher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult())
//    {
//        if(it.resultCode === android.app.Activity.RESULT_OK){
//            Glide
//                .with(getApplicationContext())
//                .load(it.data?.data)
//                .apply(RequestOptions().override(250, 200))
//                .centerCrop()
//                .into(binding.addImageView)
//
//            val cursor = contentResolver.query(it.data?.data as Uri,
//                arrayOf<String>(MediaStore.Images.Media.DATA), null, null, null);
//            cursor?.moveToFirst().let {
//                filePath=cursor?.getString(0) as String
//            }
//        }
//    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        menuInflater.inflate(R.menu.menu_write, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId === R.id.menu_add_gallery){
//            val intent = Intent(Intent.ACTION_PICK)
//            intent.setDataAndType(
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                "image/*"
//            )
//            requestLauncher.launch(intent)
//        }else if(item.itemId === R.id.menu_add_save){
//            if(binding.addEditView.text.isNotEmpty()){
//                saveStore()
//                Toast.makeText(this, "작성 완료.", Toast.LENGTH_SHORT).show()
//            }else {
//                Toast.makeText(this, "글을 입력해 주세요.", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
    }

//    private fun saveStore(){
//        val data = mapOf(
//            "content" to binding.addEditView.text.toString(),
//            "date" to dateToString(Date())
//        )
//        MyApplication.db.collection("boards")
//            .add(data)
//            .addOnSuccessListener {
//                uploadImage(it.id)
//            }
//            .addOnFailureListener{
//                Log.d("kkang", "data save error", it)
//            }
//    }
//    private fun uploadImage(docId: String){
//        val storage = MyApplication.storage
//        val storageRef = storage.reference
//        val imgRef = storageRef.child("images/${docId}.jpg")
//
//        val file = Uri.fromFile(File(filePath))
//        imgRef.putFile(file)
//            .addOnSuccessListener {
//                Toast.makeText(this, "save ok..", Toast.LENGTH_SHORT).show()
//                finish()
//            }
//            .addOnFailureListener{
//                Log.d("kkang", "file save error", it)
//            }
//
//    }
