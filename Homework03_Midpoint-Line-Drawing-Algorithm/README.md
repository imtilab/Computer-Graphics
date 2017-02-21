# Homework03_Midpoint-Line-Drawing-Algorithm
<p>
Implement the midpoint line drawing algorithm (slope dependent) only for zone 0. For all the other zones use the GL library function GL_LINES. 
</p>

1. For given set of coordinates (from a file or randomly generated) determine the zone (0...7)
2. if the zone is '0' implement the midpoint line drawing algorithm for zone 0. draw the line in green color. 
3. if the zone is anything other than '0' use the GL_LINES function to draw the line in red color. 

Hint:

gl.glColor3f(1f,0f,0f);   //gives us red          
gl.glColor3f(0f,1f,0f);   //gives us green            
gl.glColor3f(0f,0f,1f);   //gives us blue

- Step 1:x0=?, y0=?, x1=?, y1=? 
- Step 2: determine zone
- Step 3: 
  - step 3.1: if zone==0
  - step 3.1.1 midpoint line drawing 
    - dinit, dn, dnw etc.
    - glColor3f(green)
    - drawPixel()
 
  - step 3.2: else
		- glColor3f(red)
		- glBegin(GL_LINES)
		- glVertex(x0,y0)
		- glVertex(x1,y1)
		- glEnd 


--------------------
Requirements: 

You must configure your IDE for graphics project.

See here https://github.com/imtilab/jogamp-all-platforms how to set up JOGL in Eclipse for Graphics projects
