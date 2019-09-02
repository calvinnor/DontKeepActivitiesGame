package com.calvinnor.dontkeepactivitiesgame.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvinnor.dontkeepactivitiesgame.R
import com.calvinnor.dontkeepactivitiesgame.data.GameState
import com.calvinnor.dontkeepactivitiesgame.data.PlayerDetails
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    private val gameState: GameState by lazy {
        arguments?.getParcelable(ARGS_GAME_STATE) as? GameState
            ?: throw IllegalArgumentException("Must call through newInstance()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setScoreListeners()
        setupPlayerNames()
        updateScores()
    }

    private fun setScoreListeners() {
        ivPlayerOneAddScore.setOnClickListener {
            gameState.playerOneScore += 1
            updateScores()
        }

        ivPlayerTwoAddScore.setOnClickListener {
            gameState.playerTwoScore += 1
            updateScores()
        }
    }

    private fun setupPlayerNames() = with(gameState) {
        tvPlayerOneName.text = playerOneDetails.name
        tvPlayerTwoName.text = playerTwoDetails.name
    }

    private fun updateScores() = with(gameState) {
        tvPlayerOneScore.text = playerOneScore.toString()
        tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    companion object {

        private const val ARGS_GAME_STATE = "args_game_state"

        fun newInstance(playerOneDetails: PlayerDetails, playerTwoDetails: PlayerDetails) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARGS_GAME_STATE, buildNewGame(playerOneDetails, playerTwoDetails))
                }
            }

        private fun buildNewGame(playerOneDetails: PlayerDetails, playerTwoDetails: PlayerDetails) =
            GameState(
                playerOneDetails, playerTwoDetails, 0, 0
            )
    }
}
