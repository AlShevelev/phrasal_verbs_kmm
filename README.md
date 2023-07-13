[![Android](https://img.shields.io/badge/Android-red.svg)](https://www.android.com/)
[![iOs](https://img.shields.io/badge/iOs-red.svg)](https://www.apple.com/ios/ios-16/)
[![Platform](https://img.shields.io/badge/Platform-KMM-blue.svg)](https://kotlinlang.org/docs/multiplatform-mobile-getting-started.html)
[![UI](https://img.shields.io/badge/UI-Compose_Multiplatform-blue.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![Koin](https://img.shields.io/badge/DI-Koin-blue.svg)](https://insert-koin.io)
[![SQL](https://img.shields.io/badge/Storage-SQLDelight-blue.svg)](https://github.com/cashapp/sqldelight)
[![License](https://img.shields.io/badge/License-Apache_2.0-green.svg)](https://opensource.org/licenses/Apache-2.0)
# English phrasal verbs for Russian speakers

This application has been written for learning Kotlin Multiplatform technology (for mobile). It contains a set of cards with English phrasal verbs translated to Russian. I hope it can help Russian native speakers (like your humble servant) to drill this tricky topic.

<img src="readme_images/combined_small.png" height="500">

While perusing a code of the app, you may pay attention for next tricky moments. I'm not gonna explain "how it works" in details  - you have to figure it out by yoursefl. With just a little bit of my help, of course.

## View models
View models are quite a convenient way to store a state of your view. I like to use them in my apps and I managed to simulate their behaviour in a cross-platform world using Koin scopes. The base class for all my view models can be found [here](https://github.com/AlShevelev/phrasal_verbs_kmm/tree/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/viewmodel). And [here](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/feature/Feature.kt) you can see how to link the view model and a view (lines 27 and 56). According to my implementation, all view models live inside a Koin scope. [Here](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/editgroups/di/EditGroupsKoinModule.kt) is an example how to wrap a view model in a scope.


## Navigation (simple & custom)
During the development of the application, I created my own simple navigation system based on the switching of the states of Compose.
All navigation logic can be seen [here](https://github.com/AlShevelev/phrasal_verbs_kmm/tree/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/navigation). And [here (line 20)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/App.kt) you can find out how to attach the navigaton to an app.


## Cross-screen animation
In addition to navigation, I made simple animated transitions between screens. The implementation can be found [here (line 50)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/feature/Feature.kt).


## Drag & Drop items from one list to other
To create custom groups of cards with phrasal verbs, I used the Drag&Drop technique as the easiest and most visual way to populate one list of items based on another list of items. This solution if quite complex. The base functions for Drag&Drop technique implementaion can be seen [here](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/editgroups/ui/DragAndDrop.kt). You can find [here (line 25)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/editgroups/ui/ContentState.kt) how to define a draggable area. And [here (line 39)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/editgroups/ui/CardBrief.kt) how to define your draggable object. And, last, but not least - how to define a [drop target (line 23)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/editgroups/ui/CardSeparator.kt).


## Android Toast-like popups
Popup messages (aka Toasts in Android world) most likely the most convenient way to show a simple message to a user. Compose Multiplatform hasn't got such elements and I had to develop them by myself. An implementation of the popups can be found [here](https://github.com/AlShevelev/phrasal_verbs_kmm/tree/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/popup). And [here (line 33, 35, 46)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/feature/Feature.kt), and [here (line 20)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/viewmodel/ViewModelBase.kt) you can see examples of their use.


## Infinity lists (LazyColumn with an infinity scrolling)
We all worked with LazyColumn in Compose, but what if you need to show an infinite looped list of items instead of a regular one? I had to solve this challenge as well. All details can be found [here](https://github.com/AlShevelev/phrasal_verbs_kmm/tree/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/watchallcards/viewmodel/contentprovider) and [here (line 28)](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/watchallcards/ui/ContentState.kt).


## Flip card animation
Each of the card contains two sides  - an English and a Russian one. A user can switch the sides by tapping the card. Instant switching is too dull, from my humble opinion, so I added a flipping animation to the switching. You can see exactly how I did it [here](https://github.com/AlShevelev/phrasal_verbs_kmm/blob/main/shared/src/commonMain/kotlin/com/shevelev/phrasalverbs/ui/features/watchallcards/ui/CardFull.kt).


## Alert dialog
Compose Multiplatform hasn't got Alert Dialogs from the box, so I had to create them. The implementation can be found [here](https://github.com/AlShevelev/phrasal_verbs_kmm/tree/main/sharedCore/src/commonMain/kotlin/com/shevelev/phrasalverbs/core/ui/dialogs).