package com.calvinnor.dontkeepactivitiesgame.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.calvinnor.dontkeepactivitiesgame.R
import com.calvinnor.dontkeepactivitiesgame.data.PlayerDetails
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PlayerDetailsFragment.InteractionsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // If we have some state, the FragmentManager will restore it
        if (savedInstanceState == null) inflatePlayerDetailsFragment()
    }

    override fun onPlayerDetailsEntered(
        playerOneDetails: PlayerDetails,
        playerTwoDetails: PlayerDetails
    ) {
        if (flFragmentContainer.left == 0) {
            flFragmentContainer.left = 500
            return
        }
        inflateGameFragment(Pair(playerOneDetails, playerTwoDetails))
    }

    private fun inflatePlayerDetailsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(flFragmentContainer.id, PlayerDetailsFragment())
            .commit()
    }

    private fun inflateGameFragment(playersDetails: Pair<PlayerDetails, PlayerDetails>) {
        supportFragmentManager.beginTransaction()
            .replace(
                flFragmentContainer.id,
                GameFragment.newInstance(playersDetails)
            )
            .commit()
    }
}
