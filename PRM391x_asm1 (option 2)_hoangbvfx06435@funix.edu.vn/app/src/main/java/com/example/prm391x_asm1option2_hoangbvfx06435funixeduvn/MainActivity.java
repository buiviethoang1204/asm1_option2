package com.example.prm391x_asm1option2_hoangbvfx06435funixeduvn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarMain;
    GridView gridViewAnimal;
    ArrayList<Animal> arrayListAnimals;
    AnimalAdapter animalAdapter;
    ImageView imgIcon;
    int type, vitri;
    boolean fav;
    String name;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);

        gridViewAnimal = (GridView) findViewById(R.id.gridViewAnimal);
        arrayListAnimals = new ArrayList<>();
        addAnimal();

        animalAdapter = new AnimalAdapter(this, R.layout.list_animals, arrayListAnimals);
        gridViewAnimal.setAdapter(animalAdapter);

        gridViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0: {

                        type = R.drawable.bg_meo;
                        fav = true;
                        name = "Cat";
                        text = getString(R.string.text_cat);
                        showDetail(type, fav, name, text);

                    }
                    break;
                    case 1: {

                        type = R.drawable.bg_cho;
                        fav = true;
                        name = "Dog";
                        text = getString(R.string.text_dog);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 2: {
                        type = R.drawable.bg_caheo;
                        fav = true;
                        name = "Dolphin";
                        text = getString(R.string.text_dolphin);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 3: {
                        type = R.drawable.bg_huoucaoco;
                        fav = true;
                        name = "Giraffe";
                        text = getString(R.string.text_giraffe);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 4: {
                        type = R.drawable.bg_gautruc;
                        fav = true;
                        name = "Panda";
                        text = getString(R.string.text_panda);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 5: {
                        type = R.drawable.bg_heo;
                        fav = true;
                        name = "Pig";
                        text = getString(R.string.text_pig);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 6: {
                        type = R.drawable.bg_camap;
                        fav = true;
                        name = "Shark";
                        text = getString(R.string.text_shark);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 7: {
                        type = R.drawable.bg_ran;
                        fav = true;
                        name = "Snake";
                        text = getString(R.string.text_snake);
                        showDetail(type, fav, name, text);
                    }
                    break;
                    case 8: {
                        type = R.drawable.bg_rua;
                        fav = true;
                        name = "Turtle";
                        text = getString(R.string.text_turtle);
                        showDetail(type, fav, name, text);
                    }
                    break;
                }

                vitri = position;


                //animation
                overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
            }
        });

    }

    public void showDetail(int type, boolean fav, String name, String text) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("KEY", type);
        bundle.putBoolean("FAV", fav);
        bundle.putString("NAME", name);
        bundle.putString("TEXT", text);
        intent.putExtras(bundle);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Animal animal = arrayListAnimals.get(vitri);
        animal.isSelected = data.getBooleanExtra("isOn", false);

        if (animal != null) {
            if (animal.isSelected) {
                animal.setIc(R.drawable.ig_heart_asm1);
            } else {
                animal.setIc(0);
            }
        } else {
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        }

        arrayListAnimals.set(vitri, animal);
        animalAdapter.notifyDataSetChanged();


        super.onActivityResult(requestCode, resultCode, data);
    }


    private void addAnimal() {
        arrayListAnimals.add(new Animal(R.drawable.img_cat_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_dog_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_dolphin_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_giraffe_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_panda_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_pig_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_shark_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_snake_asm1, 0));
        arrayListAnimals.add(new Animal(R.drawable.img_turtle_asm1, 0));

    }
}