## Android Studio Support

This is designed to run against Android Studio 1.1.0 with
"Unit Testing support" enabled in Studio's Gradle settings.

### Importing
Import the project into Android Studio by selecting 'Import Project' and selecting the project's `build.gradle`. When prompted, you can just pick the default gradle wrapper.

### Running the Robolectric Test
To run Robolectric tests (example can be found in DeckardActivityTest) open Studio's
"Build Variants" pane and change the "Test Artifact" to "Unit Tests". You can then run
Robolectric tests using the JUnit test runner.

### Running the Espresso Test
To run Robolectric tests (example can be found in DeckardEspressoTest) open Studio's
"Build Variants" pane and change the "Test Artifact" to "Android Instrumentation Tests".
You can then run Espresso tests using the Android test runner.
