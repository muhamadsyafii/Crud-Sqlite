package com.devsyafii.crudsqlite.ui.Read;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> itemListStudent;
    private onItemClickCallback onItemClickCallback;
    Context context;

    public interface onItemClickCallback {
        void onItemClicked(Student data);
    }

    public void setOnItemClickCallback(onItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public StudentAdapter(Context context, List<Student> itemListStudent) {
        this.context = context;
        this.itemListStudent = itemListStudent;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentAdapter.ViewHolder holder, final int position) {
        Student student = itemListStudent.get(position);
        holder.id.setText(student.getId());
        holder.name.setText(student.getName());
        holder.classes.setText(student.getClasses());
        holder.ivProfile.setImageResource(R.drawable.sqliteimage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Get Position : " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//                onItemClickCallback.onItemClicked(itemListStudent.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemListStudent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, classes;
        ImageView ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name);
            classes = itemView.findViewById(R.id.tv_class);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }
    }
}
