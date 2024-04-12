# BookFlipAnimation

This project demonstrates a book flip animation in Compose Android. The animation is achieved by rotating a card on the Y-axis, creating a 3D effect.

## Technique Used

The project uses Compose Android to create the UI. Compose is a modern UI toolkit for Android that uses a declarative approach to building UIs. The book flip animation is implemented using the `graphicsLayer` API provided by Compose.

## Code Overview

The project consists of four main files:

1. **MainActivity.kt**: This file contains the `MainActivity` class, which sets the content of the activity to the `FlipBook` composable.
2. **FlipBook.kt**: This file contains the `FlipBook` composable, which is the main screen of the app. It contains a `FlipCard` and a `Switch` that allows the user to flip the card.
3. **FlipCard.kt**: This file contains the `FlipCard` composable, which is a card that can be flipped. It contains two child components, `BookCoverBack` and `BookCoverFront`, which are placed on top of each other.
4. **BookCoverFront.kt**: This file contains the `BookCoverFront` composable, which represents the front of the card. It contains an image and a shadow that give the illusion of depth.
5. **BookCoverBack.kt**: This file contains the `BookCoverBack` composable, which represents the back of the card. It contains an image and some text that are displayed when the card is flipped.

![book_flip_animation](https://github.com/swatii-solanki/BookFlipAnimation/assets/43872077/026829a0-09a9-435e-b549-a5e8ef13e5af)

## Conclusion

This project demonstrates how to implement a book flip animation in Compose Android. It uses the `graphicsLayer` API to rotate the card on the Y-axis, creating a 3D effect.
