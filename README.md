# Tutorials for Simple-Stack

This repository contains tutorials for the [`simple-stack` navigation library]([Simple-Stack](https://github.com/Zhuinden/simple-stack)) for Android.

## [1.) Using `Backstack` directly](https://github.com/Zhuinden/simple-stack-tutorials/tree/534a2c63a6827bbfd3179ac2d2dd75d863dd843e/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_1)

In this step, we create a `Backstack` in our Activity to track our navigation state.

Then, we forward the necessary callbacks to make it work, even if there's a meteor storm or equivalent in Android's ecosystem.

We see that we can pass in any Parcelable and can navigate between them seamlessly, and handle a change between them in the `handleStateChange` callback.

Please note that this is the rawest form of simple-stack and will be greatly improved in step 2.

## [2.) Using `Navigator` to hide the lifecycle callbacks](https://github.com/Zhuinden/simple-stack-tutorials/tree/534a2c63a6827bbfd3179ac2d2dd75d863dd843e/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_2)

In this step, we replace `Backstack` with `Navigator`, to see how much we can simplify the installation of a Backstack - down to just `onCreate` and `onBackPressed`.

## [3.) Setting the title text based on our navigation history](https://github.com/Zhuinden/simple-stack-tutorials/tree/534a2c63a6827bbfd3179ac2d2dd75d863dd843e/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_3)

In this step, we can see how easy it is to set up any arbitrary state based on our current navigation history.

The example shows how to show the "back" button when there is an available screen to go back to, and how to change the title text accordingly.

## [4.) Using custom views instead of handling navigation state directly in the Activity](https://github.com/Zhuinden/simple-stack-tutorials/tree/534a2c63a6827bbfd3179ac2d2dd75d863dd843e/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_4)

In this step, we can see how to use custom views (compound viewgroups) to create self-contained components that can contain their own views and manage their own behavior.

## [5.) Using fragments instead of custom views because that's also possible](https://github.com/Zhuinden/simple-stack-tutorials/tree/534a2c63a6827bbfd3179ac2d2dd75d863dd843e/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_5)

In this step, we replace custom views (compound viewgroups) with Fragments, because they're more commonly found in the wild.

We can see that the Fragment framework (thanks to `attach`/`detach`/`add`/`remove`) is customizable enough that we can keep our Fragments exactly in the state as we expect them to be in based on our current navigation history.

## [6.) Using `setHistory()` to implement "conditional navigation"](https://github.com/Zhuinden/simple-stack-tutorials/tree/bace8b7b00abcf1c66af0a9a5e91665c8746cdf5/app/src/main/java/com/zhuinden/simplestacktutorials/steps/step_6)

In this step, we can see how to implement a simple splash screen using `backstack.setHistory()`.

## License

    Copyright 2020 Gabor Varadi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
