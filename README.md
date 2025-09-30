# CS501 - Homework 3 - Question 4: Scaffold with Bars and FAB

This shows how to use the `Scaffold` layout to build a basic screen with a top bar, a bottom navigation bar, and a floating action button (FAB).



## Explanation of the App

This app is built mainly using the `Scaffold` composable, just like we saw in the lecture on **slides 26-28**.

* **`Scaffold`**: I used this as the main "skeleton" for the whole screen. It has slots for all the different parts like the top bar and bottom bar.

* **`TopAppBar`**: I put a `TopAppBar` in the `topBar` slot of the Scaffold to show the app's title, "Mounts".

* **`NavigationBar`**: For the bottom bar, I used a `NavigationBar` with three `NavigationBarItem`s for "Home," "Settings," and "Profile." The text in the middle of the screen changes when you tap on them.

* **`FloatingActionButton` (FAB)**: I added a FAB to the `floatingActionButton` slot. As shown on ** Lec slide 31**, the FAB is for the main action on the screen.

* **`Snackbar`**: When you click the FAB, a `Snackbar` message pops up. I used a `SnackbarHostState` and a `coroutineScope` to make this happen, which is the Material 3 way of showing these messages.

* **`innerPadding`**: In the `content` part of the `Scaffold`, I made sure to apply the `innerPadding` it gives you. The lecture on **slide 27** said it was super important to do this so the content doesn't get hidden under the top and bottom bars.

## How to Use the App

1.  **Run the app**. You'll see the main screen with "Home" selected.
2.  Tap on **"Settings"** or **"Profile"** in the bottom bar to see the text in the center of the screen change.
3.  Click the **`+` button (the FAB)** on the bottom right. A message that says "FAB Clicked!" will pop up from the bottom.
