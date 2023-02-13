package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.model.Projects

class ProjectsAdapter(val projects: List<Projects>) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_project, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.bind(project)
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameProject = view.findViewById<TextView>(R.id.txt_name_project)
        val imageProject = view.findViewById<ImageView>(R.id.image_project)
        val descriptionProject = view.findViewById<TextView>(R.id.txt_description)
        val directionProject = view.findViewById<TextView>(R.id.txt_direction)

       fun bind(project: Projects) {

            nameProject.text = project.nameProject
            //imageProject.id = project.imageProject
            Glide.with(imageProject.context).load(project.imageProject).into(imageProject)
            descriptionProject.text = project.description
            directionProject.text = project.direction
        }
    }
}