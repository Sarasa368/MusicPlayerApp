package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NowPlayingActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)

        val songName = intent.getStringExtra("SONG_NAME") ?: "Unknown Song"
        val artistName = intent.getStringExtra("ARTIST_NAME") ?: "Unknown Artist"

        val songTitle = findViewById<TextView>(R.id.songTitle)
        val songArtist = findViewById<TextView>(R.id.songArtist)
        val backButton = findViewById<Button>(R.id.backButton)
        val playPauseButton = findViewById<Button>(R.id.playPauseButton)

        songTitle.text = songName
        songArtist.text = artistName

        mediaPlayer = MediaPlayer.create(this, R.raw.music1)

        playPauseButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer?.pause()
                playPauseButton.text = "▶  Play"
                isPlaying = false
            } else {
                mediaPlayer?.start()
                playPauseButton.text = "⏸  Pause"
                isPlaying = true
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}