The main Victron part of this project is in the com.lightningsports.VictronBatteryMonitor package. At the moment, this will only read from the serial port. There is functionality for both Hex and Direct protocols. The rest of the code is a wrapper used to read a settings file and run the victron program on a schedule. At this point, this program will open the port and listen. If any "register" settings are set, it will send them and listen for a response. When the VictronData fields are filled, this program will try to post them to a URL.

This is for remote monitoring of the battery monitor.

Future development will include write commands. The foundation of write commands is there, I just need to build on that foundation.
