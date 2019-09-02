package com.calvinnor.dontkeepactivitiesgame.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvinnor.dontkeepactivitiesgame.R
import com.calvinnor.dontkeepactivitiesgame.data.PlayerDetails
import kotlinx.android.synthetic.main.fragment_player_details.*

class PlayerDetailsFragment : Fragment() {

    private lateinit var interactions: InteractionsListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactions = when {
            context is InteractionsListener -> context
            parentFragment is InteractionsListener -> parentFragment as InteractionsListener
            else -> throw IllegalStateException("Parent Fragment or Activity must implement InteractionsListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_player_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        btnPlay.setOnClickListener { validateNamesAndStartGame() }
    }

    private fun validateNamesAndStartGame() {
        val playerOneName = etPlayer1Name.text.toString()
        val playerTwoName = etPlayer2Name.text.toString()

        interactions.onPlayerDetailsEntered(
            playerOneDetails = PlayerDetails(1, playerOneName),
            playerTwoDetails = PlayerDetails(2, playerTwoName)
        )
    }

    interface InteractionsListener {

        fun onPlayerDetailsEntered(playerOneDetails: PlayerDetails, playerTwoDetails: PlayerDetails)
    }
}
