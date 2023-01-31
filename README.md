# Lazy-Hungry-Potato
"Data Structures &amp; Algorithms" course project, Fall 2022.


### This projrct is written in java.

The thecnique which I used for handling this project is as below:
We need a min-heap for sorting all the restaurants that the user gave us input. Then when we call the queries,  in addition to removing them from the heap and putting the n-called restaurant to a trie-tree, we also need to put them into a stack to protect the order of the algorithm we used.
Note that removing from the min-heap is by calling the min-heapify function.
