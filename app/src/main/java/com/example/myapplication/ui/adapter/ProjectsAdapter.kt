package com.example.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.TwoFragment
import com.example.myapplication.core.BaseViewHolder
import com.example.myapplication.data.model.Projects
import com.example.myapplication.databinding.ItemProjectBinding
import com.example.myapplication.presentation.ProjectViewModel

class ProjectsAdapter(
    private val projectsList: List<Projects>,
    private val itemClickListener: OnProjectClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    /*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
    }*/

    interface  OnProjectClickListener{
        fun onProjectClick(projects: Projects)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemProjectBinding.inflate(
            LayoutInflater
                .from(
                    parent
                        .context
                ), parent, false
        )
        val holder = ProjectViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
            itemClickListener.onProjectClick(projectsList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ProjectViewHolder -> holder.bind(projectsList[position])
        }
    }

    override fun getItemCount(): Int {
        return projectsList.size
    }

    private  inner class ProjectViewHolder(
        val binding: ItemProjectBinding,
        val context: Context
        ): BaseViewHolder<Projects>(binding.root){
        val nameProject = binding.txtNameProject.findViewById<TextView>(R.id.txt_name_project)
        val imageProject = binding.imageProject.findViewById<ImageView>(R.id.image_project)
        val descriptionProject = binding.txtDescription.findViewById<TextView>(R.id.txt_description)
        val directionProject = binding.txtDirection.findViewById<TextView>(R.id.txt_direction)
        override fun bind(item: Projects) {
            nameProject.text = item.nameProject
            //imageProject.id = project.imageProject
            Glide.with(context).load(item.imageProject).into(imageProject)
            descriptionProject.text = item.description
            directionProject.text = item.direction
        }
    }
}