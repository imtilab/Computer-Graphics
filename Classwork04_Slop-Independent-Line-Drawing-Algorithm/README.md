# Classwork04_Slop-Independent-Line-Drawing-Algorithm


Write a program to implement the slope independent line drawing algorithm. 
Steps:

1. Generate coordinates for a line AB. A(x0,y0) and B(x1,y1)
2. Determine the zone of the line [0 … 7]
    - If(|dx|>|dy|) [zones 0,7,3,4]
        - If(dx>0 && dy>0)
           - Return Zone=0
        - Else if (?)
           - Return zone=7
        - Else if (?)
           - Return zone=3
        - Else 
           - Return zone=4
    - Else [zones 1,2,5,6
        - If(?)
            - Return Zone=1
        - Else if (?)
            - Return zone=2
        - Else if (?)
            - Return zone=5
        - Else 
            - Return zone=6
3.	Calculate next pixel for zone 0
    - If (zone 1|| 2||5||6)
        - Swap (x0,y0)
        - Swap (x1,y1)
    - Dinit=2dy-dx
    - dNE=?
    - dE=?
    - Loop until (x0<x1)
        - If(dinit<0)
            - Dinit+=dE
        - Else 
            - Dinit+=dNE
            - Y++
        - X++
        - Convert back to correct zones coordinates ConvBack(x,y)

4.	ConvBack(x,y){ //each zone should have a different color
    - If(zone==0)
        - gl.glColor3f(1f,0f,0f);
        - drawPixel(x,y)
    - else if (zone==7)
        - drawPixel(x,-y)
    - else if(zone==3)
        - drawPixel(?,?)
    - else if(zone==4)
        - drawPixel(?,?))
    - else if(zone==1)
        - drawPixel(?,?)
    - else if(zone==2)
        - drawPixel(?,?)
    - else if(zone==3)
        - drawPixel(?,?)
    - else if(zone==4)
        - drawPixel(?,?)


}

gl.glColor3f(1f,0f,0f); //gives us red
gl.glColor3f(0f,1f,0f); //gives us green
gl.glColor3f(0f,0f,1f); //gives us blue



----------------
Requirements: 

You must configure your IDE for graphics project.

See here https://github.com/imtilab/jogamp-all-platforms how to set up JOGL in Eclipse for Graphics projects
