package com.cleanup.todoc.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.cleanup.todoc.R;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.TaskRepository;

public class DetailTaskActivity extends FragmentActivity {

    private TaskRepository taskRepository;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        Intent bundle = getIntent();
        final int id = bundle.getIntExtra("id", 0);
        Task ts= new Task();

        String nameTache = ts.getName();
        String nameProjet =ts.getProject().getName();
        final Long dateR = ts.getCreationTimestamp();


        final EditText name_task = findViewById(R.id.inom_tache);
        final EditText date_task = findViewById(R.id.idate_creationtache);
        final EditText heure_task = findViewById(R.id.iheure_creation);
        final EditText name_projet = findViewById(R.id.inom_projet);

        Button modif = findViewById(R.id.modif);

        name_task.setText(nameTache);
        date_task.setText(Math.toIntExact(dateR));
        heure_task.setText(Math.toIntExact(dateR));
        name_projet.setText(nameProjet);


        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_task.setText(toString());
                date_task.setText(toString());
                heure_task.setText(toString());
                name_projet.setText(toString());
                Task ts1=new Task(id,Integer.valueOf(String.valueOf(name_projet)),String.valueOf(name_task),dateR);
                taskRepository.updateTask(ts1);

                finish();
            }
        });

    }
}