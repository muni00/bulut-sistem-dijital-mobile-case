package com.muazzeznihalbahadir.bulutbilisimmobilecase.view

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.muazzeznihalbahadir.bulutbilisimmobilecase.R
import com.muazzeznihalbahadir.bulutbilisimmobilecase.databinding.FragmentIlanDetayBinding
import com.squareup.picasso.Picasso
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class IlanDetayFragment : Fragment() {
    private lateinit var binding: FragmentIlanDetayBinding
    private var imageUri: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ilan_detay,container,false)
        var paraBirimleri = resources.getStringArray(R.array.paraBirimleri)
        (activity as AppCompatActivity).supportActionBar?.title = "İlan Datay"
        val adapter = activity?.applicationContext?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,paraBirimleri) }
        binding.spnrBirim.adapter = adapter
        binding.txtAciklama.filters = arrayOf<InputFilter>(MinMaxFilter(50, 2000))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.onIzlemeGecis)
           // val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
           // getActivity()?.startActivityForResult(gallery, 100)

        }
        binding.kontrol.setOnClickListener {
          //  var donus = isOnline("https://stackoverflow.com/questions/1560788/how-to-check-internet-access-on-android-inetaddress-never-times-out")
//
          //  if (donus == true){
          //      Log.v(TAG, "var**********************************************************");
          //  }

        }
    }
    override  open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100) {
            imageUri = data?.data
            //binding.imageView2.setImageURI(imageUri)
            Picasso.get().load(imageUri).resize(60,60).into(binding.imageView2)

        }
    }

    fun isOnline(url:String): Boolean {
            try {
                val url = URL(url)
                val urlc = url.openConnection() as HttpURLConnection
                urlc.connectTimeout = 3000
                urlc.connect()
                if (urlc.responseCode == 200) {
                    return true
                }
            } catch (e1: MalformedURLException) {
                // TODO Auto-generated catch block
                e1.printStackTrace()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        return false
    }

    inner class MinMaxFilter() : InputFilter {
        private var intMin: Int = 0
        private var intMax: Int = 0

        // Initialized
        constructor(minValue: Int, maxValue: Int) : this() {
            this.intMin = minValue
            this.intMax = maxValue
        }

        override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dStart: Int, dEnd: Int): CharSequence? {
            try {
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(intMin, intMax, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }
        // Check if input c is in between min a and max b and
        // returns corresponding boolean
        private fun isInRange(a: Int, b: Int, c: Int): Boolean {
            return if (b > a) c in a..b else c in b..a
        }
    }

}