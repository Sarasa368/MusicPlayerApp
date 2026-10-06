package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<android.view.View>(R.id.song1).setOnClickListener {
            openNowPlaying("Cinematic Music", "Audio Track")
        }

        findViewById<android.view.View>(R.id.song2).setOnClickListener {
            openNowPlaying("City Lights", "Nova")
        }

        findViewById<android.view.View>(R.id.song3).setOnClickListener {
            openNowPlaying("Ocean Eyes", "Blue Horizon")
        }

        findViewById<android.view.View>(R.id.song4).setOnClickListener {
            openNowPlaying("Golden Hour", "Sol")
        }

        findViewById<android.view.View>(R.id.song5).setOnClickListener {
            openNowPlaying("Afterglow", "Echo")
        }
    }

    private fun openNowPlaying(songName: String, artistName: String) {
        val intent = Intent(this, NowPlayingActivity::class.java)

        intent.putExtra("SONG_NAME", songName)
        intent.putExtra("ARTIST_NAME", artistName)

        startActivity(intent)
    }
}