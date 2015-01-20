Wordladder
==========

The question posed by the Talko team for this interview is a well known computer science problem with multiple solutions based 
on variations of breadth first search (BFS) and depth first search (DFS) algorithms.  Variations on BFS include:

+ Simple BFS (not using a graph, non-threaded)
+ Graph based BFS (build graph in advance)
+ Threaded BFS (use multiple threads to search a large data set to assemble a path)

## My Choice

For the purposes of this test, I chose a Graph based BFS without threading for the following reasons:

+ The initial data set is not going to change (always the same 5-letter words in the American Dictionary). I take a single one-time hit to build the entire graph up front.
+ If I were to implement this as a service, I would not have memory concerns, so putting the entire graph parent-child structure in memory allows for fast searching without thread overhead.
+ This method eliminates the need to search letter by letter for candidate matches in the valid word set.

If I were to consider a threaded option, I would determine the number of cores on the current machine and create a thread pool of that size to push search tasks and wait on the results.

## Tools

I used IntelliJ IDEA 14 to build this project and manage unit tests and coverage (100% of classes are covered--Main is the only code not covered).
 I excluded the actual .iml files in .gitignore, but you can import the code, set the "test" directory as a test code source, and run all the tests.
 
 ### Sample Data
 
 I have included "dict5.txt", which contains the American Dictionary list of 5 letter words.
 