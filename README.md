# Tic Tac Toe Game

This is a very simple and easy to use android game of Tic Tac Toe.
# Screenshots
 <img src="https://github.com/ravi6446/2019_DEV_019/blob/master/screenshots/1.png" width="300">  <img src="https://github.com/ravi6446/2019_DEV_019/blob/master/screenshots/2.png" width="300">  <img src="https://github.com/ravi6446/2019_DEV_019/blob/master/screenshots/3.png" width="300">  <img src="https://github.com/ravi6446/2019_DEV_019/blob/master/screenshots/4.png" width="300">
 
# Rules 

-   The  **game**  is played on a grid that's 3 squares by 3 squares.
-    It is a two player game one is 'X' and other 'O'.
- **Players** take **turns** putting their marks in empty squares.
-  The first  **player**  to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.
- When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.

# Environment setup
 ## Install Android Studio
Install Android studio from following link
https://developer.android.com/studio/?gclid=EAIaIQobChMInqyfyIed3wIV0g0rCh2SKgGXEAAYASAAEgJEcPD_BwE
-  After installing android studio check if the Android Emulator is installed.
-  If not installed, click **Tools > SDK Manager**  in  Android Studio and select the **SDK Tools** component and install Android Emulator.

# Run application
**For downloading the apk of the game use following link**
https://github.com/ravi6446/2019_DEV_019/blob/master/Tic-Tac-Toe.apk
## On the emulator

You can run an app from an Android Studio project, or you can run an app that's been installed on the Android Emulator as you would run any app on a device.
To start the Android Emulator and run an app in your project:

1.  Open an Android Studio project and click  **Run**  ![](https://developer.android.com/studio/images/buttons/toolbar-run.png).
    
    The  **Select Deployment Target**  dialog appears.
    
    ![Select Deployment Target dialog](https://developer.android.com/studio/images/run/e-selectdeploymenttarget_2-2_2x.png)
In the **Select Deployment Target** dialog, select an existing emulator definition, and then click **OK**.

2. If you don’t see a definition you want to use, click  **Create New Virtual Device**  to launch the AVD Manager. After you define a new AVD, in the  **Select Deployment Target**  dialog, click  **OK**. If you want to use this emulator definition as the default for your project, select  **Use same selection for future launches**.

**While the emulator is running, you can also drag one or more APKs onto the emulator to install them, and then run them.**


## On the device

**Set up a device for development** 
Before you can start debugging on your device, there are a few things you must do:
-  On the device, open the **Settings** app, select **Developer options**, and then enable **USB debugging**.
- Set up your system to detect your device.

  **Windows:**  Install a USB driver for ADB. For an installation guide and links to OEM drivers, see the  [Install OEM USB drivers](https://developer.android.com/studio/run/oem-usb.html)  document.
  **Mac OS X:**  It just works. Skip this step.
   **Ubuntu Linux:**  Use  `apt-get install`  to install the  `adb`  package. This gives you a community-maintained default set of  `udev`  rules for all Android devices.    
    Make sure that you are in the plugdev group. If you see the following error message, adb did not find you in the plugdev group:    
    error: insufficient permissions for device: udev requires plugdev group membership    
    Use  `id`  to see what groups you are in. Use  `sudo usermod -aG plugdev $LOGNAME`  to add yourself to the plugdev group.    
    The following example shows how to install the Android adb tools package.
    
    apt-get install adb


**Connect to your device** 
When you are set up and plugged in over USB, you can click  **Run**  ![](https://developer.android.com/studio/images/buttons/toolbar-run.png)  in Android Studio to  [build and run your app on the device](https://developer.android.com/studio/run/index.html).

You can also use  [adb](https://developer.android.com/studio/command-line/adb.html)  to issue commands, as follows:

-   Verify that your device is connected by running the  `adb devices`  command from your`android_sdk/platform-tools/`  directory. If connected, you'll see the device listed.
-   Issue any  [adb command](https://developer.android.com/studio/command-line/adb.html#issuingcommands)  with the  `-d`  flag to target your device.
