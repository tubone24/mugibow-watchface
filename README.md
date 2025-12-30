# Mugibow Watch Face

A custom watch face for Pixel Watch using Watch Face Format (WFF) v2, compatible with Wear OS 4+.

## Demo

<!-- Add your demo screenshots here -->
![Watch Face Demo](demo.png)

## Features

- Custom digital clock with bitmap font digits
- Weather display with day/night icons (tap to open Weather app)
- Temperature range (high/low), precipitation %, and UV index
- Day/night background switching
- Moon phase icon
- Step count with circular progress arc
- Heart rate display (tap to open Health app)
- Battery level with progress arc
- Date with day of week
- Ambient mode support

## Supported Devices

- Pixel Watch / Watch 2 / Watch 3
- Galaxy Watch 4/5/6/7/Ultra
- Other Wear OS 4+ smartwatches

## Build

### Requirements

- Android Studio (latest version recommended)
- JDK 17 or higher

### Steps

1. Open this project in Android Studio
2. Go to `Build > Build Bundle(s) / APK(s) > Build APK(s)`
3. The APK will be generated at `app/build/outputs/apk/debug/app-debug.apk`

Or build from command line:

```bash
./gradlew assembleDebug
```

## Install

### Wear OS Emulator

1. Open Android Studio
2. Go to `Tools > Device Manager`
3. Create a new Wear OS emulator (API 33+)
4. Start the emulator
5. Drag and drop the APK onto the emulator window

Or use ADB:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Real Device (Pixel Watch)

#### Option 1: WiFi Debugging (Recommended)

1. On your watch, go to `Settings > Developer options > Wireless debugging`
2. Enable wireless debugging and note the IP address and port
3. On your PC, connect via ADB:

```bash
adb connect <IP_ADDRESS>:<PORT>
adb install app/build/outputs/apk/debug/app-debug.apk
```

#### Option 2: ADB via Phone

1. Enable Developer options on both your phone and watch
2. Enable ADB debugging on the watch
3. On your phone, use Wear OS app or ADB over Bluetooth
4. Install the APK through the connected ADB session

### After Installation

1. Long press on your watch face
2. Swipe to find "Mugibow Watch Face"
3. Tap to select it

## License

MIT License
