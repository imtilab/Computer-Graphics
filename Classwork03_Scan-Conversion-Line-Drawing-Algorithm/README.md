# Classwork03_Scan-Conversion-Line-Drawing-Algorithm

SCAN CONVERSION LINE DRAWING (Slope dependent):

1. Given the start and endpoints write a java program to draw the line (slope m = 1,-1, 0, ∞) using points.
 a. If slope m is 1 then, increment x and y draw the point
 b. If slope m is -1 then, increment x and decrement y
 c. If slope m is 0 then, increment x
 d. If slope m is ∞ then, increment y
 e. For any other slope declare invalid

Procedure:
- Read the coordinates (from user or a .txt file)
- Calculate the slope m
- Choose among the four orientation of straight lines (diagonal {m = +/- 1}, horizontal {m = 0}, vertical {m = ∞})
- Draw the line using points. Always start drawing from the left most points. (How do you determine which is leftmost?)
- Draw the first and last points manually (outside any loops)


-----------
Requirements: 

You must configure your IDE for graphics project.

See here https://github.com/imtilab/jogamp-all-platforms how to set up JOGL in Eclipse for Graphics projects
