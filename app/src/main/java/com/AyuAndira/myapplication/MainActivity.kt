package com.AyuAndira.myapplication


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.AyuAndira.myapplication.adapter.AdapterTeamBola
import com.AyuAndira.myapplication.databinding.ActivityMainBinding
import com.AyuAndira.myapplication.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Jung Sang-jin",R.drawable.haen, "Actor", "178cm","Seoul, Korea Selatan","1 April 1988"))
        listPemain.add(Pemain("Jennie Kim",R.drawable.jenie, "Penyanyi BLACKPINK", "175cm","Anyang,Korea Selatan","16 Januari 1996"))
        listPemain.add(Pemain("Kim Ji-soo",R.drawable.jhiso, "Penyanyi BLACKPINK", "170cm","Gunpo, Korea Selatan","January 3, 1995"))
        listPemain.add(Pemain("Pranpriya Manobal",R.drawable.lisa, "Penyanyi BLACKPINK", "177cm","Buriram, Thailand"," March 27, 1997"))
        listPemain.add(Pemain("Roseanne Park",R.drawable.rose, "Penyanyi BLACKPINK", "175cm","Auckland, New Zealand"," 11 February 1997"))

        binding.list.adapter = AdapterTeamBola(this, listPemain,object : AdapterTeamBola.OnClikListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtnama)

                    val profesi = this.findViewById<TextView>(R.id.txtprofesi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    profesi.text = "${item?.profesi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"


                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })
    }
}