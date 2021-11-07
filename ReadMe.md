# Project 5: Trees

Here is my submission for [Project 5](https://landmark.instructure.com/courses/3993/assignments/97877).  

## Bikary Search Tree

Rather than using 26 binary search trees, I decided to use a single 26-ary search tree, which I call a "Bikary", from *bi-* meaning 2 and *baker* meaning "baker's dozen" or 13, since 2 &times; 13 = 26. (This is based on a naming convention by [Jan Misali](https://www.seximal.net/names-of-other-bases)) It could also be called a "Hexavigesimal" Tree (6+20) or a "Literal Search Tree" since it's based on letters.

In other words, rather than have the first node have 26 children, and all others have 2, I decided to make *every* node have up to 26 children.  This had several advantages and disadvantages.

#### Advantages

* **Time Complexity**: The amount of time to find the node corresponding to a particular word is proportional only to the length of the word, rather than the number of words in the entire tree.  
* **Comparisons**: Words do not have to be "compared" to one another.  They simply fall under the branch of their corresponding letter.
* **Memory Economy**: No memory is needed to store the actual words, as this information is embedded in the structure of the tree itself.

#### Disadvantages

* **Null Values**: Since every word is represented by a node containing an array of size 26, there is usually a substantial number of null array elements.  *Moby Dick*, which contains 212,872 words in total, yeilds a tree containing 1,353,051 null elements.
* **No Punctuation**: All non-alpha characters are removed when a word is stored, so words differentiated only by such characters are indistinguishable, and their entries merged.  The words "were" and "we're" appear cumulatively 678 times in *Moby Dick*, but it is impossible to tell from the tree which is which.

A tree can be generated from *Moby Dick* by Herman Melville in less than 250 milliseconds. I downloaded a [text file](https://www.gutenberg.org/files/2701/2701-0.txt) from Project Gutenberg. (The actual work occupies lines 845-21960 of the file.) I would be interested to see how this compares to binary implementations.

## Questions

### Is this the best way to store a concordance?

Based on my experience so far, I think the Bikary is a better way to store a concordance than the Binary Search Tree, for the reasons discussed above.  However, I would want to see how a BST performs on comparable tasks before forming a stronger opinion.  Further research is needed.

### Why do you think we didn’t store all words in 1 big Binary Search Tree (versus in 26 separate BST’s depending on their first letter. 

Using a fully 2-child paradigm could lead to significant balancing issues, and the first word stored would have a huge influence on how the tree was balanced.  Creating 26 separate trees helps to mitigate this problem, due to the Law of Large Numbers.  

Also, when looking up a word, using 26 nodes for the first step skips about 5 binary comparisons, since 26&asymp;2<sup>5</sup>, leading to faster lookup times.

## Summary

### If you worked in pairs...

I completed this project alone.

### Where did you have trouble with this assignment? How did you move forward? What topics still confuse you? 



### What did you learn from this assignment?

It's usually best to traverse this kind of tree in pre-order. 