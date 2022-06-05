package abdulahad.imfast.io.lekuet.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import abdulahad.imfast.io.lekuet.R;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView leProfessor, leAssociates, assistantProf, leLecturer;
    private LinearLayout professorNoData, associateNoData, assistantProfNoData, lecturerNodata;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upadate_faculty);

        professorNoData = findViewById(R.id.professorNoData);
        associateNoData = findViewById(R.id.associateNoData);
        assistantProfNoData = findViewById(R.id.assistantProfNoData);
        lecturerNodata = findViewById(R.id.lecturerNodata);

        leProfessor = findViewById(R.id.leProfessor);
        leAssociates = findViewById(R.id.leAssociates);
        assistantProf = findViewById(R.id.assistantProf);
        leLecturer = findViewById(R.id.leLecturer);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        professors();
        associateProfessors();
        assistantProfessors();
        lecturers();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
    }

    private void professors() {

        dbRef = reference.child("Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    professorNoData.setVisibility(View.VISIBLE);
                    leProfessor.setVisibility(View.GONE);
                }else {
                    professorNoData.setVisibility(View.GONE);
                    leProfessor.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    leProfessor.setHasFixedSize(true);
                    leProfessor.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Professor");
                    leProfessor.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void associateProfessors() {

        dbRef = reference.child("Associate Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    associateNoData.setVisibility(View.VISIBLE);
                    leAssociates.setVisibility(View.GONE);
                }else {
                    associateNoData.setVisibility(View.GONE);
                    leAssociates.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    leAssociates.setHasFixedSize(true);
                    leAssociates.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Associate Professor");
                    leAssociates.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void assistantProfessors() {

        dbRef = reference.child("Assistant Professor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    assistantProfNoData.setVisibility(View.VISIBLE);
                    assistantProf.setVisibility(View.GONE);
                }else {
                    assistantProfNoData.setVisibility(View.GONE);
                    assistantProf.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    assistantProf.setHasFixedSize(true);
                    assistantProf.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "Assistant Professor");
                    assistantProf.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void lecturers() {

        dbRef = reference.child("Lecturer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    lecturerNodata.setVisibility(View.VISIBLE);
                    leLecturer.setVisibility(View.GONE);
                }else {
                    lecturerNodata.setVisibility(View.GONE);
                    leLecturer.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    leLecturer.setHasFixedSize(true);
                    leLecturer.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "Lecturer");
                    leLecturer.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}