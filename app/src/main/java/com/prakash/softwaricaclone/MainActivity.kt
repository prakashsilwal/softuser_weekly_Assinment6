package com.prakash.softwaricaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prakash.softwaricaclone.Fragments.AboutFragment
import com.prakash.softwaricaclone.Fragments.AddStudentFragment
import com.prakash.softwaricaclone.model.Student

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    lateinit var linear: LinearLayout
    var studentArrayList:ArrayList<student>?= ArrayList()

    class student(
        studentName: String,
        studentAge: String,
        studentGender: String,
        studentAddress: String,
        imageLink: String
    ) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment=HomeFragment()
        val addStudentFragment= AddStudentFragment()
        val aboutUsFragment= AboutFragment()
        linear=findViewById(R.id.linear)

        Student.addStudent()
        makeCurrentFragment(homeFragment)

        bottomNavigation=findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener {item->
            when(item.itemId){
                R.id.icHome ->{makeCurrentFragment(homeFragment)
                    true
                }
                R.id.icAddStudent ->{makeCurrentFragment(addStudentFragment)
                    true
                }
                R.id.icAbout ->{makeCurrentFragment(aboutUsFragment)
                    true
                }

                else -> false
            }
        }

        bottomNavigation.setOnNavigationItemReselectedListener {item->
            when(item.itemId){
                R.id.icHome ->{makeCurrentFragment(homeFragment)
                    true
                }
                R.id.icAddStudent ->{makeCurrentFragment(addStudentFragment)
                    true
                }
                R.id.icAbout ->{makeCurrentFragment(aboutUsFragment)
                    true
                }
                else -> false
            }
        }
    }


