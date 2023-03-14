package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.Projects
import com.example.myapplication.ui.adapter.ProjectsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TwoFragment : Fragment(R.layout.fragment_two), ProjectsAdapter.OnProjectClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = requireActivity().findViewById<RecyclerView>(R.id.rv_list_project)

        //exampleListProject()
        exampleListProject {
            recycler.adapter = ProjectsAdapter(it, this@TwoFragment)
        }
    }

    private fun exampleListProject(callback: (result: List<Projects>) -> Unit) {

        GlobalScope.launch(Dispatchers.Main) {

            val project1 = Projects(
                "San Lorenzo 1",
                R.drawable.ic_launcher_background,
                "150 departamentos",
                "Av. Sanlorenzo s/n"
            )
            val project2 = Projects(
                "San Lorenzo 2",
                R.drawable.ic_launcher_background,
                "40 departamentos",
                "Av Sanlorenzo 1990"
            )
            val project3 = Projects(
                "San Lorenzo 3",
                R.drawable.ic_launcher_background,
                "100 departamentos",
                "Av Salorenzo 15640"
            )
            val project4 = Projects(
                "Eugenia",
                R.drawable.ic_launcher_background,
                "15 departamentos",
                "Metro Eugenia"
            )
            val project5 = Projects(
                "Atlalilco",
                R.drawable.ic_launcher_background,
                "25 departamentos",
                "Avenida Iztapalapa"
            )
            val project6 = Projects(
                "Moctezuma",
                R.drawable.ic_launcher_background,
                "20 departamentos",
                "Metro moctezuma"
            )

            callback(
                listOf(
                    project1,
                    project2,
                    project3,
                    project4,
                    project5,
                    project6
                )
            )

        }

    }

    override fun onProjectClick(projects: Projects) {
        Log.d("VAAP", "onProjectClick: $projects")
        findNavController().navigate(R.id.detailProjectFragment)
    }

}