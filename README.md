# Virtual Piano Player

## "Unleash the musician within: Play the Virtual piano anytime, anywhere with our app"

My **virtual piano** application would allow users to play piano 
on their devices, the application will allow users to record their performance and
share with others, my aim will be to provide users with convenient and
user-friendly environment to learn piano at their own pace.

A piano costs a lot and not everyone can afford it, even if they can afford it finding time from their busy schedule would be difficult 
In that scenario my application will come in handy, also the feature to share your recording will allow users to showcase their progress and get feedback.

The application interests me because of my passion for music.

A *bulleted* list:
- As a user, I want to play piano anywhere and anytime.
- As a user, I want to record my music.
- As a user, I want to play my recorded music.
- As a user, I want to learn to play different beats with a help of a game.
- As a user, I want to have an option save my recordings.
- As a user, I want to have an option to load my recordings and play them.


# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by clicking on Record 
 and entering the keys you want to record. You see your record by clicking on Recording.
- You can generate the second required action related to adding Xs to a Y by removing a recorder from recordings 
 you can do this by clicking on remove record.
- You can generate the third required action related to adding Xs to a Y by shuffling your records in recordings 
 by clicking on reorder.
- You can locate my visual component by running the code, and my visual components opens up on the JFrame as the background
- You can save the state of my application  by clicking on save.
- You can reload the state of my application by clicking yes on the popup that appears just after 
 running the code.

# Phase 4 : task 2
This is what will happen when I add three Recorders, shuffle them and delete one of them.

`Thu Apr 13 15:14:19 PDT 2023
Added a recorder to list of Records`


`Thu Apr 13 15:14:21 PDT 2023
Added a recorder to list of Records`


`Thu Apr 13 15:14:23 PDT 2023
Added a recorder to list of Records`


`Thu Apr 13 15:14:25 PDT 2023
Shuffled Records in list of Records`


`Thu Apr 13 15:14:27 PDT 2023
Removed the record at 1 from list of Records`


# Phase 4 : task 3



#### Refactoring I would have done if I had more time.

I would have implemented an iterator for my Progress class
that would give access to list of Recorder without knowing 
progress internal implementation.
With this implementation, I can use the iterator to access the list of Recorders
and play them efficiently,because external code can access the necessary data without relying on the implementation specifics of the Progress class,
this can help my code be easier to maintain and understand.

Cohesion in my classes could be improved by refactoring the methods that are performing unrelated tasks, which is something I would do if I had more time to work on it.
This would make my code easier to understand and reusable.

#### Design pattern i used:

I implemented singleton pattern to the EventLog class to ensure that
only one instance of class is created and provides global point of
access for it.
