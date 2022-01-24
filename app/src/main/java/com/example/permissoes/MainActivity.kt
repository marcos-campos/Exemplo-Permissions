package com.example.permissoes

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissoes()
    }
    private fun permissoes() {

        val btnFoto = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingActionButton2)
        btnFoto.setOnClickListener {

            permitirTirarFoto()

        }

        val btnCompartilhar = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingActionButton)
        btnCompartilhar.setOnClickListener {

            permissaoAcessoFoto()
            
            }

        }
    }


    private fun permissaoAcessoFoto(){

        val permissaoAcesso = Manifest.permission.WRITE_EXTERNAL_STORAGE

        val verificarJaPermitido = ContextCompat.checkSelfPermission(this, permissaoAcesso)

        if (verificarJaPermitido != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(permissaoAcesso), 2)
        }else{
            Toast.makeText(this, "Permissão para compartilhamento já conceida", Toast.LENGTH_SHORT).show()

        }

    }

    private fun permitirTirarFoto(){

        val permitirFoto = Manifest.permission.CAMERA

        val verificarSeJaFoiPermitido = ContextCompat.checkSelfPermission(this, permitirFoto)

        if (verificarSeJaFoiPermitido != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(permitirFoto), 1)

        }else{

            Toast.makeText(this, "Permissão de acesso a camera já concecida", Toast.LENGTH_SHORT).show()

        }
    }

}