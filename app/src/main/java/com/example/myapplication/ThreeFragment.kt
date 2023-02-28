package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.helper.ExampleHelper
import kotlin.math.log

class ThreeFragment : Fragment(R.layout.fragment_three) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ExampleHelper.getInstance().getResponseExample(1){ result, isSucces ->
            if (isSucces){
                Log.d("VAAP", "onViewCreated: $result")
            }else{
                Log.d("VAAP", "onViewCreated: $result")
            }

        }

    }

}