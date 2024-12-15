package com.example.platformerplain.utils;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

import static com.example.platformerplain.Start.*;


public class Counter {
    public static void startCountdown(Label timerLabel) {
        // Countdown from 5 minutes (300 seconds)
        final int totalTime = 300; // 5 minutes in seconds
        final int[] countdownTime = {totalTime}; // Using an array to modify inside the timer

        // Create an AnimationTimer for the countdown
        getInstance().timerLabelTimer = new AnimationTimer() {
            private long lastUpdate = System.nanoTime(); // Track the last update time

            @Override
            public void handle(long now) {
                // Calculate the elapsed time in seconds
                if (now - lastUpdate >= 1_000_000_000) { // 1 second in nanoseconds
                    if (countdownTime[0] > 0) {
                        int minutes = countdownTime[0] / 60;
                        int seconds = countdownTime[0] % 60;
                        timerLabel.setText(String.format("Time left: %d:%02d", minutes, seconds));
                        countdownTime[0]--; // Decrement the remaining time
                    } else {
                        // Timer has finished
                        timerLabel.setText("Time's up!");
                        this.stop(); // Stop the timer
                        onCountdownEnd(totalTime - countdownTime[0]); // Pass the elapsed time
                    }
                    lastUpdate = now; // Update the last update time
                }
            }
        };

        getInstance().timerLabelTimer.start(); // Start the countdown timer
    }
}
