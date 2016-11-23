*******
Music Preference Visualization (MPV) - Group 68
*******

.. contents::
    :local:
    :depth: 1
    :backlinks: none

========
Synopsis
========
The project will be a visualization of the music survey data we collected for the two sections of 2114. Information Visualization allows users to view multidimensional data from different perspectives and can give insight into data patterns and relationships. 

===================
Program Design
===================

- Student: A class to store a student’s survey information.

- StudentCollection: Implements Iterator interface. Extends LinkedList. Stores the entire survey information of students by storing Student classes. Has methods to poll through the Students and gather heard and liked data according to a song’s title and the representation type.

- Song: A class to store a song’s information. The data inside can change when representation type of the data change. Since for each representation type, there are fixed number of 4 variances, (i.e. for Hobby there are read, art, sports, music) the data for each variances (number of heard and number of liked) can be stored in a single integer array of length 8. (4 variances * (heard and likes (2)))

- SongCollection: Implements Iterator interface. Extends LinkedList. Stores all the Song classes and each of their associated data. Has methods to sort the stored Song classes by using certain comparing methods, (Comparators) and request data changes to each of the Song class in the list. These methods are called when buttons in the GUIWindow are pressed.

- LinkedList<T>: Implements List with linked Nodes. Will be the main data structure to store and process the program’s data.

============
Installation
============
Clone the git repository into working directory. Use::

    $ git clone https://github.com/nguyenjulian/Project-5

Now, open up Eclipse.

- File -> Import
- General -> Existing Projects Into Workspace -> Next
- "Select root directory" and select directory with cloned repository. Ensure that "Copy projects into workspace is unchecked".
- Click Finish

Hopefully, all of that worked out for you and you are ready to start using MPV.

=======================
Gitflow
=======================
Once you have made some changes and are ready to push to the remote repository. Use::

    $ git add .

This collects all new and modified files for a commit to your local repository. Then use::

    $ git commit -m "Commit message."
    
This creates a commit to your local repository. Option -m allows for a commit message describing the commit. Then use::

    $ git pull
   
This ensures that you have the latest content from the remote/master repository. You may have to deal with merge conflicts after which you will have to "add" and "commit" once again. Another pull request should have everthing up-to-date. Finally use::

    $ git push -u origin master
   
This pushes local changes to the remote repository for all contributors to see.    
