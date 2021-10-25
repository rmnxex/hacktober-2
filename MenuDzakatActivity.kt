package com.blogsetyaaji.dashboardislami.menus.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogsetyaaji.dashboardislami.databinding.ActivityMenuDzakatBinding
import java.text.NumberFormat
import java.util.*
import android.text.TextUtils
import android.view.MenuItem
import android.widget.Toast



class MenuDzakatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuDzakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuDzakatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarZakat)
        initView()
    }

    private fun initView() {
        binding.button.setOnClickListener {
            // cek jika kolom zakat masih kosong
            if (TextUtils.isEmpty(binding.etAmountZakat.text)){
                Toast.makeText(this,
                    "Harta tidak boleh kosong",
                    Toast.LENGTH_LONG
                ).show()
            }else if (binding.etAmountZakat.getNumericValue().toInt() >= 85000000){
                val formatAmount = NumberFormat
                    .getNumberInstance(Locale("id", "ID"))
                    .format(binding.etAmountZakat.getNumericValue())

                binding.tvHartaAmount.text = "Rp $formatAmount"

                // rumus menghitung zakat : total harta * 2.5/100
                val zakat = binding.etAmountZakat.getNumericValue().toInt() * (2.5 / 100)
                val formatZakat = NumberFormat
                    .getNumberInstance(Locale("id", "ID"))
                    .format(zakat)

                binding.tvAmountZakat.text = "Rp $formatZakat"
            } else {
                Toast.makeText(this,
                    "Total harta belum mencapai nisab (85gr emas)",
                    Toast.LENGTH_LONG
                ).show()
                binding.tvAmountZakat.text = "Rp 0"
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
