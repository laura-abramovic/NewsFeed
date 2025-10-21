# NewsFeed

NewsFeed is an Android app that uses [Koog](https://docs.koog.ai/) and [OpenAI](https://openai.com/api/) to scan news articles from various sources and delivers bullet-point summaries of current events.

News are split into three main categories: 
- global (world)
- local (Croatia)
- tech

# Overview

The app is simple to use. When you first start the app, you will see the empty screen prompting you to generate news. Once you press the "Generate news" button, a spinner will be shown on the screen while the summary is being generated. 
This can take a little bit longer. Once the process is complete, the summarized news will appear on the screen.

<img width=25% height=25% alt="starting screen" src="https://github.com/user-attachments/assets/07fe4108-68bb-49b2-8381-fc5525f1927c" />

<img width=25% height=25% alt="image" src="https://github.com/user-attachments/assets/fa01ddab-6f4b-4ea3-a44e-f50ce80df536" />

<img width=25% height=25% alt="image" src="https://github.com/user-attachments/assets/816de0b2-0791-4c20-b232-7242acfd9498" />

# Setup

1. Clone the repository

```bash
git clone https://github.com/laura-abramovic/NewsFeed.git
```

2. Open the project in Android Studio
  
3. Add your OpenAI api keys to `NewsAgent.kt` file

```kotlin
    val apiKey = "" // your API key here
```
4. Optional: Configure prompts in the `Prompts.kt` file to customize the feed

5. Build and run the app on a device or emulator.

# License 

This repository and all of its content is free to use within the [MIT](https://github.com/laura-abramovic/NewsFeed?tab=MIT-1-ov-file) license.
