package com.example.madlevel5task2.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentAddGameBinding
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.viewmodel.GameViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.time.LocalDate

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabAddGame.setOnClickListener{
            onAddGame()
        }
    }

    private fun onAddGame() {
        val gameTitle = etTitle.text.toString()
        val gamePlatform = etPlatform.text.toString()
        val gameDay = etDay.text.toString().toInt()
        val gameMonth = etMonth.text.toString().toInt()
        val gameYear = etYear.text.toString().toInt()

        if (gameTitle.isNotBlank()) {
            gameViewModel.insertGame(
                Game(
                    gameTitle,
                    gamePlatform,
                    LocalDate.of(gameYear, gameMonth, gameDay)
                )
            )
            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_reminder, Toast.LENGTH_SHORT
            ).show()
        }
    }
}